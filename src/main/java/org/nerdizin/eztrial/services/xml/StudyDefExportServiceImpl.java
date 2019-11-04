package org.nerdizin.eztrial.services.xml;

import org.nerdizin.eztrial.entities.admin.Location;
import org.nerdizin.eztrial.entities.admin.Role;
import org.nerdizin.eztrial.entities.admin.SignatureDef;
import org.nerdizin.eztrial.entities.admin.User;
import org.nerdizin.eztrial.entities.elementconverter.*;
import org.nerdizin.eztrial.entities.study.*;
import org.nerdizin.eztrial.repositories.*;
import org.nerdizin.eztrial.repositories.admin.*;
import org.nerdizin.eztrial.util.Constants;
import org.nerdizin.eztrial.xml.odm.FileType;
import org.nerdizin.eztrial.xml.odm.Odm;
import org.nerdizin.eztrial.xml.odm.admin.AdminData;
import org.nerdizin.eztrial.xml.odm.study.BasicDefinitions;
import org.nerdizin.eztrial.xml.odm.study.Study;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class StudyDefExportServiceImpl implements StudyDefExportService {

	private final LocationRepository locationRepository;
	private final UserRepository userRepository;
	private final RoleRepository roleRepository;
	private final AddressRepository addressRepository;
	private final SignatureDefRepository signatureDefRepository;
	private final MetaDataVersionRefRepository metaDataVersionRefRepository;

	private final StudyRepository studyRepository;
	private final MeasurementUnitRepository measurementUnitRepository;
	private final MetaDataVersionRepository metaDataVersionRepository;
	private final ProtocolRepository protocolRepository;
	private final EventDefRepository eventDefRepository;
	private final FormDefRepository formDefRepository;
	private final ItemGroupDefRepository itemGroupDefRepository;
	private final ItemDefRepository itemDefRepository;

	private final EventRefRepository eventRefRepository;
	private final FormRefRepository formRefRepository;
	private final ItemGroupRefRepository itemGroupRefRepository;
	private final ItemRefRepository itemRefRepository;

	@Autowired
	public StudyDefExportServiceImpl(final LocationRepository locationRepository,
			final UserRepository userRepository,
			final RoleRepository roleRepository,
			final AddressRepository addressRepository,
			final SignatureDefRepository signatureDefRepository,
			final MetaDataVersionRefRepository metaDataVersionRefRepository,
			final StudyRepository studyRepository,
			final MeasurementUnitRepository measurementUnitRepository,
			final MetaDataVersionRepository metaDataVersionRepository,
			final ProtocolRepository protocolRepository,
			final EventDefRepository eventDefRepository,
			final FormDefRepository formDefRepository,
			final ItemGroupDefRepository itemGroupDefRepository,
			final ItemDefRepository itemDefRepository,
			final EventRefRepository eventRefRepository,
			final FormRefRepository formRefRepository,
			final ItemGroupRefRepository itemGroupRefRepository,
			final ItemRefRepository itemRefRepository) {
		this.locationRepository = locationRepository;
		this.userRepository = userRepository;
		this.roleRepository = roleRepository;
		this.addressRepository = addressRepository;
		this.signatureDefRepository = signatureDefRepository;
		this.metaDataVersionRefRepository = metaDataVersionRefRepository;
		this.studyRepository = studyRepository;
		this.measurementUnitRepository = measurementUnitRepository;
		this.metaDataVersionRepository = metaDataVersionRepository;
		this.protocolRepository = protocolRepository;
		this.eventDefRepository = eventDefRepository;
		this.formDefRepository = formDefRepository;
		this.itemGroupDefRepository = itemGroupDefRepository;
		this.itemDefRepository = itemDefRepository;
		this.eventRefRepository = eventRefRepository;
		this.formRefRepository = formRefRepository;
		this.itemGroupRefRepository = itemGroupRefRepository;
		this.itemRefRepository = itemRefRepository;
	}

	@Override
	public Odm exportStudyDef(final String studyOid, final FileType fileType) {

		final Odm result = new Odm();
		result.setFileType(fileType);
		result.setFileOid(UUID.randomUUID().toString());
		result.setOdmVersion(Constants.ODM_VERSION);
		result.setCreationDateTime(LocalDateTime.now());

		result.setStudy(loadStudy(studyOid));
		result.setAdminData(loadAdminData());

		return result;
	}

	private Study loadStudy(final String oid) {

		final org.nerdizin.eztrial.entities.study.Study studyEntity = studyRepository.findByOid(oid);
		final StudyConverter studyConverter = new StudyConverter();
		final Study study = studyConverter.convertToElement(studyEntity);

		final List<MeasurementUnit> measurementUnits = measurementUnitRepository.findAllByStudy(studyEntity);
		if (measurementUnits != null) {
			final BasicDefinitions basicDefinitions = new BasicDefinitions();
			final MeasurementUnitConverter measurementUnitConverter = new MeasurementUnitConverter();
			for (final MeasurementUnit measurementUnit : measurementUnits) {
				basicDefinitions.addMeasurementUnit(measurementUnitConverter.convertToElement(measurementUnit));
			}
			study.setBasicDefinitions(basicDefinitions);
		}

		final Iterable<MetaDataVersion> metaDataVersions = studyEntity.getMetaDataVersions();
		if (metaDataVersions != null) {
			loadMetaDataVersions(metaDataVersions, study);
		}

		return study;
	}

	private void loadMetaDataVersions(final Iterable<MetaDataVersion> metaDataVersions,
			final Study study) {

		final MetaDataVersionConverter metaDataVersionConverter = new MetaDataVersionConverter();
		for (final MetaDataVersion metaDataVersion : metaDataVersions) {
			final org.nerdizin.eztrial.xml.odm.study.MetaDataVersion metaDataVersionElement =
					metaDataVersionConverter.convertToElement(metaDataVersion);

			final Protocol protocol = metaDataVersion.getProtocol();
			if (protocol != null) {
				final ProtocolConverter protocolConverter = new ProtocolConverter();
				metaDataVersionElement.setProtocol(protocolConverter.convertToElement(protocol));
			}

			loadEventDefs(metaDataVersion, metaDataVersionElement);
			loadFormDefs(metaDataVersion, metaDataVersionElement);
			loadItemGroupDefs(metaDataVersion, metaDataVersionElement);
			loadItemDefs(metaDataVersion, metaDataVersionElement);
			study.addMetaDataVersion(metaDataVersionElement);
		}
	}

	private void loadEventDefs(final MetaDataVersion metaDataVersion,
			final org.nerdizin.eztrial.xml.odm.study.MetaDataVersion metaDataVersionElement) {

		final Iterable<EventDef> eventDefs = eventDefRepository.findAllByMetaDataVersion(metaDataVersion);
		if (eventDefs != null) {
			final EventDefConverter eventDefConverter = new EventDefConverter();
			for (final EventDef eventDef : eventDefs) {
				metaDataVersionElement.addStudyEventDef(eventDefConverter.convertToElement(eventDef));
			}
		}
	}

	private void loadFormDefs(final MetaDataVersion metaDataVersion,
			final org.nerdizin.eztrial.xml.odm.study.MetaDataVersion metaDataVersionElement) {

		final Iterable<FormDef> formDefs = formDefRepository.findAllByMetaDataVersion(metaDataVersion);
		if (formDefs != null) {
			final FormDefConverter formDefConverter = new FormDefConverter();
			for (final FormDef formDef : formDefs) {
				metaDataVersionElement.addFormDef(formDefConverter.convertToElement(formDef));
			}
		}
	}

	private void loadItemGroupDefs(final MetaDataVersion metaDataVersion,
			final org.nerdizin.eztrial.xml.odm.study.MetaDataVersion metaDataVersionElement) {

		final Iterable<ItemGroupDef> itemGroupDefs = itemGroupDefRepository.findAllByMetaDataVersion(metaDataVersion);
		if (itemGroupDefs != null) {
			final ItemGroupDefConverter itemGroupDefConverter = new ItemGroupDefConverter();
			for (final ItemGroupDef itemGroupDef : itemGroupDefs) {
				metaDataVersionElement.addItemGroupDef(itemGroupDefConverter.convertToElement(itemGroupDef));
			}
		}
	}

	private void loadItemDefs(final MetaDataVersion metaDataVersion,
			final org.nerdizin.eztrial.xml.odm.study.MetaDataVersion metaDataVersionElement) {

		final Iterable<ItemDef> itemDefs = itemDefRepository.findAllByMetaDataVersion(metaDataVersion);
		if (itemDefs != null) {
			final ItemDefConverter itemDefConverter = new ItemDefConverter();
			for (final ItemDef itemDef : itemDefs) {
				metaDataVersionElement.addItemDef(itemDefConverter.convertToElement(itemDef));
			}
		}
	}

	private AdminData loadAdminData() {

		final AdminData result = new AdminData();

		final Iterable<User> users = userRepository.findAllByOrderByOid();
		if (users != null) {
			loadUsers(users, result);
		}

		final Iterable<Role> roles = roleRepository.findAllByOrderByOid();
		if (roles != null) {
			loadRoles(roles, result);
		}

		final Iterable<Location> locations = locationRepository.findAllByOrderByOid();
		if (locations != null) {
			loadLocations(locations, result);
		}

		final Iterable<SignatureDef> signatureDefs = signatureDefRepository.findAllByOrderByOid();
		if (signatureDefs != null) {
			loadSignatureDefs(signatureDefs, result);
		}

		return result;
	}

	private void loadUsers(final Iterable<User> users, final AdminData adminData) {
		final UserConverter userConverter = new UserConverter();
		for (final User user : users) {
			adminData.addUser(userConverter.convertToElement(user));
		}
	}

	private void loadRoles(final Iterable<Role> roles, final AdminData adminData) {
		final RoleConverter roleConverter = new RoleConverter();
		for (final Role role : roles) {
			adminData.addRole(roleConverter.convertToElement(role));
		}
	}

	private void loadLocations(final Iterable<Location> locations, final AdminData adminData) {
		final LocationConverter locationConverter = new LocationConverter();
		for (final Location location : locations) {
			adminData.addLocation(locationConverter.convertToElement(location));
		}
	}

	private void loadSignatureDefs(final Iterable<SignatureDef> signatureDefs, final AdminData adminData) {
		final SignatureDefConverter signatureDefConverter = new SignatureDefConverter();
		for (final SignatureDef signatureDef : signatureDefs) {
			adminData.addSignatureDef(signatureDefConverter.convertToElement(signatureDef));
		}
	}
}
