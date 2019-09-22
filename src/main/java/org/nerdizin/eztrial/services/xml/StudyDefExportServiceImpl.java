package org.nerdizin.eztrial.services.xml;

import org.nerdizin.eztrial.entities.admin.Location;
import org.nerdizin.eztrial.entities.admin.MetaDataVersionRef;
import org.nerdizin.eztrial.entities.admin.SignatureDef;
import org.nerdizin.eztrial.entities.admin.User;
import org.nerdizin.eztrial.entities.elementconverter.*;
import org.nerdizin.eztrial.entities.study.*;
import org.nerdizin.eztrial.repositories.*;
import org.nerdizin.eztrial.util.Constants;
import org.nerdizin.eztrial.xml.odm.FileType;
import org.nerdizin.eztrial.xml.odm.Odm;
import org.nerdizin.eztrial.xml.odm.admin.AdminData;
import org.nerdizin.eztrial.xml.odm.study.BasicDefinitions;
import org.nerdizin.eztrial.xml.odm.study.Study;
import org.nerdizin.eztrial.xml.odm.study.StudyEventDef;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class StudyDefExportServiceImpl implements StudyDefExportService {

	private static final Logger LOG = LoggerFactory.getLogger(StudyDefExportServiceImpl.class);

	private final LocationRepository locationRepository;
	private final UserRepository userRepository;
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
		final Study study = studyConverter.convert2Element(studyEntity);

		final List<MeasurementUnit> measurementUnits = measurementUnitRepository.findAllByStudy(studyEntity);
		if (measurementUnits != null) {
			final BasicDefinitions basicDefinitions = new BasicDefinitions();
			final MeasurementUnitConverter measurementUnitConverter = new MeasurementUnitConverter();
			for (final MeasurementUnit measurementUnit : measurementUnits) {
				basicDefinitions.addMeasurementUnit(measurementUnitConverter.convert2Element(measurementUnit));
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

		for (final MetaDataVersion metaDataVersion : metaDataVersions) {
			final org.nerdizin.eztrial.xml.odm.study.MetaDataVersion metaDataVersionElement =
					new org.nerdizin.eztrial.xml.odm.study.MetaDataVersion();
			final Protocol protocol = metaDataVersion.getProtocol();
			if (protocol != null) {
				final ProtocolConverter protocolConverter = new ProtocolConverter();
				metaDataVersionElement.setProtocol(protocolConverter.convert2Element(protocol));
			}

			loadEventDefs(metaDataVersion, metaDataVersionElement);
			loadFormDefs(metaDataVersion, metaDataVersionElement);
			study.addMetaDataVersion(metaDataVersionElement);
		}
	}

	private void loadEventDefs(final MetaDataVersion metaDataVersion,
			final org.nerdizin.eztrial.xml.odm.study.MetaDataVersion metaDataVersionElement) {

		final Iterable<EventDef> eventDefs = eventDefRepository.findAllByMetaDataVersion(metaDataVersion);
		if (eventDefs != null) {
			final EventDefConverter eventDefConverter = new EventDefConverter();
			for (final EventDef eventDef : eventDefs) {
				metaDataVersionElement.addStudyEventDef(eventDefConverter.convert2Element(eventDef));
			}
		}
	}

	private void loadFormDefs(final MetaDataVersion metaDataVersion,
			final org.nerdizin.eztrial.xml.odm.study.MetaDataVersion metaDataVersionElement) {

		final Iterable<FormDef> formDefs = formDefRepository.findAllByMetaDataVersion(metaDataVersion);
		if (formDefs != null) {
			final FormDefConverter formDefConverter = new FormDefConverter();
			for (final FormDef formDef : formDefs) {
				metaDataVersionElement.addFormDef(formDefConverter.convert2Element(formDef));
			}
		}
	}

	private AdminData loadAdminData() {

		final AdminData result = new AdminData();

		final Iterable<User> users = userRepository.findAll();
		if (users != null) {
			loadUsers(users, result);
		}

		final Iterable<Location> locations = locationRepository.findAll();
		if (locations != null) {
			loadLocations(locations, result);
		}

		final Iterable<SignatureDef> signatureDefs = signatureDefRepository.findAll();
		if (signatureDefs != null) {
			loadSignatureDefs(signatureDefs, result);
		}

		return result;
	}

	private void loadUsers(final Iterable<User> users, final AdminData adminData) {
		final UserConverter userConverter = new UserConverter();
		for (final User user : users) {
			adminData.addUser(userConverter.convert2Element(user));
		}
	}

	private void loadLocations(final Iterable<Location> locations, final AdminData adminData) {
		final LocationConverter locationConverter = new LocationConverter();
		for (final Location location : locations) {
			adminData.addLocation(locationConverter.convert2Element(location));
		}
	}

	private void loadSignatureDefs(final Iterable<SignatureDef> signatureDefs, final AdminData adminData) {
		final SignatureDefConverter signatureDefConverter = new SignatureDefConverter();
		for (final SignatureDef signatureDef : signatureDefs) {
			adminData.addSignatureDef(signatureDefConverter.convert2Element(signatureDef));
		}
	}
}
