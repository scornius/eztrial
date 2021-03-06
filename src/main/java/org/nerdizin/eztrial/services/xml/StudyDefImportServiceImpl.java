package org.nerdizin.eztrial.services.xml;

import org.nerdizin.eztrial.entities.admin.Address;
import org.nerdizin.eztrial.entities.elementconverter.admin.*;
import org.nerdizin.eztrial.entities.elementconverter.def.*;
import org.nerdizin.eztrial.entities.study.def.EventDef;
import org.nerdizin.eztrial.entities.study.def.EventRef;
import org.nerdizin.eztrial.entities.study.def.ItemRef;
import org.nerdizin.eztrial.repositories.admin.*;
import org.nerdizin.eztrial.repositories.study.def.*;
import org.nerdizin.eztrial.xml.odm.Odm;
import org.nerdizin.eztrial.xml.odm.admin.*;
import org.nerdizin.eztrial.xml.odm.study.def.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudyDefImportServiceImpl implements StudyDefImportService {

	private final static Logger log = LoggerFactory.getLogger(StudyDefImportServiceImpl.class);

	private final LocationRepository locationRepository;
	private final UserRepository userRepository;
	private final AddressRepository addressRepository;
	private final SignatureDefRepository signatureDefRepository;
	private final MetaDataVersionRefRepository metaDataVersionRefRepository;
	private final RoleRepository roleRepository;
	private final PrivilegeRepository privilegeRepository;

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
	public StudyDefImportServiceImpl(final LocationRepository locationRepository,
			final UserRepository userRepository,
			final AddressRepository addressRepository,
			final SignatureDefRepository signatureDefRepository,
			final MetaDataVersionRefRepository metaDataVersionRefRepository,
			final RoleRepository roleRepository,
			final PrivilegeRepository privilegeRepository,
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
		this.roleRepository = roleRepository;
		this.privilegeRepository = privilegeRepository;
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
	public void importStudyDef(final Odm odm) {

		if (odm.getAdminData() != null) {
			importAdminData(odm.getAdminData());
		}
		if (odm.getStudy() != null) {
			importStudy(odm.getStudy());
		}
		if (odm.getAdminData() != null) {
			importAdminDataRefs(odm.getAdminData());
		}
	}

	private void importStudy(final Study study) {

		final StudyConverter studyConverter = new StudyConverter();
		final org.nerdizin.eztrial.entities.study.def.Study studyEntity = studyConverter.convertToEntity(study);
		studyRepository.save(studyEntity);

		if (study.getBasicDefinitions() != null) {
			if (study.getBasicDefinitions().getMeasurementUnits() != null) {
				final MeasurementUnitConverter measurementUnitConverter = new MeasurementUnitConverter();
				for (final MeasurementUnit measurementUnit : study.getBasicDefinitions().getMeasurementUnits()) {
					final org.nerdizin.eztrial.entities.study.def.MeasurementUnit measurementEntity =
							measurementUnitConverter.convertToEntity(measurementUnit);
					measurementEntity.setStudy(studyEntity);
					measurementUnitRepository.save(measurementEntity);
					studyEntity.addMeasurementUnit(measurementEntity);
				}
			}
		}

		if (study.getMetaDataVersions() != null) {
			for (final MetaDataVersion metaDataVersion : study.getMetaDataVersions()) {
				final org.nerdizin.eztrial.entities.study.def.MetaDataVersion metaDataVersionEntity =
						importDefs(studyEntity, metaDataVersion);
				metaDataVersionRepository.save(metaDataVersionEntity);
				importRefs(studyEntity, metaDataVersion, metaDataVersionEntity);
			}
		}
	}

	private org.nerdizin.eztrial.entities.study.def.MetaDataVersion importDefs(
			final org.nerdizin.eztrial.entities.study.def.Study studyEntity,
			final MetaDataVersion metaDataVersion) {

		final MetaDataVersionConverter metaDataVersionConverter = new MetaDataVersionConverter();

		final org.nerdizin.eztrial.entities.study.def.MetaDataVersion metaDataVersionEntity =
				metaDataVersionConverter.convertToEntity(metaDataVersion);
		metaDataVersionEntity.setStudy(studyEntity);
		metaDataVersionRepository.save(metaDataVersionEntity);
		studyEntity.addMetaDataVersion(metaDataVersionEntity);

		if (metaDataVersion.getProtocol() != null) {
			importProtocolDef(metaDataVersion, metaDataVersionEntity);
		}
		if (metaDataVersion.getStudyEventDefs() != null) {
			importEventDef(metaDataVersion, metaDataVersionEntity);
		}
		if (metaDataVersion.getFormDefs() != null) {
			importFormDef(metaDataVersion, metaDataVersionEntity);
		}
		if (metaDataVersion.getItemGroupDefs() != null) {
			importItemGroupDef(metaDataVersion, metaDataVersionEntity);
		}
		if (metaDataVersion.getItemDefs() != null) {
			importItemDef(metaDataVersion, metaDataVersionEntity);
		}
		return metaDataVersionEntity;
	}

	private void importItemDef(final MetaDataVersion metaDataVersion,
							   final org.nerdizin.eztrial.entities.study.def.MetaDataVersion metaDataVersionEntity) {
		final ItemDefConverter itemDefConverter = new ItemDefConverter();
		for (final ItemDef itemDef : metaDataVersion.getItemDefs()) {
			final org.nerdizin.eztrial.entities.study.def.ItemDef itemDefEntity = itemDefConverter.convertToEntity(itemDef);
			itemDefEntity.setMetaDataVersion(metaDataVersionEntity);
			itemDefRepository.save(itemDefEntity);
			metaDataVersionEntity.addItemDef(itemDefEntity);
		}
	}

	private void importItemGroupDef(final MetaDataVersion metaDataVersion,
									final org.nerdizin.eztrial.entities.study.def.MetaDataVersion metaDataVersionEntity) {
		final ItemGroupDefConverter itemGroupDefConverter = new ItemGroupDefConverter();
		for (final ItemGroupDef itemGroupDef : metaDataVersion.getItemGroupDefs()) {
			final org.nerdizin.eztrial.entities.study.def.ItemGroupDef itemGroupDefEntity =
					itemGroupDefConverter.convertToEntity(itemGroupDef);
			itemGroupDefEntity.setMetaDataVersion(metaDataVersionEntity);
			itemGroupDefRepository.save(itemGroupDefEntity);
			metaDataVersionEntity.addItemGroupDef(itemGroupDefEntity);
		}
	}

	private void importFormDef(final MetaDataVersion metaDataVersion,
							   final org.nerdizin.eztrial.entities.study.def.MetaDataVersion metaDataVersionEntity) {
		final FormDefConverter formDefConverter = new FormDefConverter();
		for (final FormDef formDef : metaDataVersion.getFormDefs()) {
			final org.nerdizin.eztrial.entities.study.def.FormDef formDefEntity = formDefConverter.convertToEntity(formDef);
			formDefEntity.setMetaDataVersion(metaDataVersionEntity);
			formDefRepository.save(formDefEntity);
			metaDataVersionEntity.addFormDef(formDefEntity);
		}
	}

	private void importEventDef(final MetaDataVersion metaDataVersion,
								final org.nerdizin.eztrial.entities.study.def.MetaDataVersion metaDataVersionEntity) {
		final EventDefConverter eventDefConverter = new EventDefConverter();
		for (final StudyEventDef studyElementDef : metaDataVersion.getStudyEventDefs()) {
			final EventDef eventDefEntity = eventDefConverter.convertToEntity(studyElementDef);
			eventDefEntity.setMetaDataVersion(metaDataVersionEntity);
			eventDefRepository.save(eventDefEntity);
			metaDataVersionEntity.addEventDef(eventDefEntity);
		}
	}

	private void importProtocolDef(final MetaDataVersion metaDataVersion,
								   final org.nerdizin.eztrial.entities.study.def.MetaDataVersion metaDataVersionEntity) {
		final ProtocolConverter protocolConverter = new ProtocolConverter();
		final org.nerdizin.eztrial.entities.study.def.Protocol protocolEntity =
				protocolConverter.convertToEntity(metaDataVersion.getProtocol());
		protocolEntity.setMetaDataVersion(metaDataVersionEntity);
		protocolRepository.save(protocolEntity);
		metaDataVersionEntity.setProtocol(protocolEntity);
	}

	private void importRefs(final org.nerdizin.eztrial.entities.study.def.Study studyEntity,
							final MetaDataVersion metaDataVersion,
							final org.nerdizin.eztrial.entities.study.def.MetaDataVersion metaDataVersionEntity) {

		if (metaDataVersion.getProtocol() != null && metaDataVersion.getProtocol().getStudyEventRefs() != null) {
			for (final StudyEventRef eventRef : metaDataVersion.getProtocol().getStudyEventRefs()) {
				final org.nerdizin.eztrial.entities.study.def.Protocol protocolEntity = metaDataVersionEntity.getProtocol();
				final EventDef targetEventDef = metaDataVersionEntity.findEventDefByOid(eventRef.getStudyEventOid());
				final EventRef eventRefEntity = new EventRef();
				eventRefEntity.setProtocol(protocolEntity);
				eventRefEntity.setEventDef(targetEventDef);
				eventRefEntity.setMandatory(eventRef.getMandatory());
				eventRefRepository.save(eventRefEntity);
				protocolEntity.addEventRef(eventRefEntity);
			}
		}

		if (metaDataVersion.getStudyEventDefs() != null) {
			importFormRefs(metaDataVersion, metaDataVersionEntity);
		}
		if (metaDataVersion.getFormDefs() != null) {
			importItemGroupRefs(metaDataVersion, metaDataVersionEntity);
		}
		if (metaDataVersion.getItemGroupDefs() != null) {
			importItemRefs(metaDataVersion, metaDataVersionEntity);
		}
	}

	private void importFormRefs(final MetaDataVersion metaDataVersion,
								final org.nerdizin.eztrial.entities.study.def.MetaDataVersion metaDataVersionEntity) {

		for (final StudyEventDef eventDef : metaDataVersion.getStudyEventDefs()) {
			if (eventDef.getFormRefs() != null) {
				final EventDef eventDefEntity = metaDataVersionEntity.findEventDefByOid(eventDef.getOid());
				for (final FormRef formRef : eventDef.getFormRefs()) {
					final org.nerdizin.eztrial.entities.study.def.FormDef targetFormDef =
							metaDataVersionEntity.findFormDefByOid(formRef.getFormOid());
					final org.nerdizin.eztrial.entities.study.def.FormRef formRefEntity =
							new org.nerdizin.eztrial.entities.study.def.FormRef();
					formRefEntity.setEventDef(eventDefEntity);
					formRefEntity.setFormDef(targetFormDef);
					formRefEntity.setMandatory(formRef.getMandatory());
					formRefRepository.save(formRefEntity);
					eventDefEntity.addFormRef(formRefEntity);
				}
			}
		}
	}

	private void importItemGroupRefs(final MetaDataVersion metaDataVersion,
									 final org.nerdizin.eztrial.entities.study.def.MetaDataVersion metaDataVersionEntity) {

		for (final FormDef formDef : metaDataVersion.getFormDefs()) {
			if (formDef.getItemGroupRefs() != null) {
				final org.nerdizin.eztrial.entities.study.def.FormDef formDefEntity = metaDataVersionEntity.findFormDefByOid(formDef.getOid());
				for (final ItemGroupRef itemGroupRef : formDef.getItemGroupRefs()) {
					final org.nerdizin.eztrial.entities.study.def.ItemGroupDef targetItemGroupDef =
							metaDataVersionEntity.findItemGroupDefByOid(itemGroupRef.getItemGroupOid());
					final org.nerdizin.eztrial.entities.study.def.ItemGroupRef itemGroupRefEntity =
							new org.nerdizin.eztrial.entities.study.def.ItemGroupRef();
					itemGroupRefEntity.setFormDef(formDefEntity);
					itemGroupRefEntity.setItemGroupDef(targetItemGroupDef);
					itemGroupRefEntity.setMandatory(itemGroupRef.getMandatory());
					itemGroupRefRepository.save(itemGroupRefEntity);
					formDefEntity.addItemGroupRef(itemGroupRefEntity);
				}
			}
		}
	}

	private void importItemRefs(final MetaDataVersion metaDataVersion,
								final org.nerdizin.eztrial.entities.study.def.MetaDataVersion metaDataVersionEntity) {

		for (final ItemGroupDef itemGroupDef : metaDataVersion.getItemGroupDefs()) {
			if (itemGroupDef.getItemRefs() != null) {
				final org.nerdizin.eztrial.entities.study.def.ItemGroupDef itemGroupDefEntity =
						metaDataVersionEntity.findItemGroupDefByOid(itemGroupDef.getOid());
				for (final ItemRefElement itemRef : itemGroupDef.getItemRefs()) {
					final org.nerdizin.eztrial.entities.study.def.ItemDef targetItemDef =
							metaDataVersionEntity.findItemDefByOid(itemRef.getItemOid());
					final ItemRef itemRefEntity =
							new ItemRef();
					itemRefEntity.setItemGroupDef(itemGroupDefEntity);
					itemRefEntity.setItemDef(targetItemDef);
					itemRefEntity.setMandatory(itemRef.getMandatory());
					itemRefRepository.save(itemRefEntity);
					itemGroupDefEntity.addItemRef(itemRefEntity);
				}
			}
		}
	}

	private void importAdminData(final AdminData adminData) {

		if (adminData.getLocations() != null) {
			final LocationConverter locationConverter = new LocationConverter();
			for (final Location location : adminData.getLocations()) {
				locationRepository.save(locationConverter.convertToEntity(location));
			}
		}
		if (adminData.getRoles() != null) {
			final RoleConverter roleConverter = new RoleConverter();
			for (final Role role : adminData.getRoles()) {
				final PrivilegeConverter privilegeConverter = new PrivilegeConverter();
				org.nerdizin.eztrial.entities.admin.Role roleEntity = roleConverter.convertToEntity(role);
				if (role.getPrivileges() != null) {
					for (final Privilege privilege : role.getPrivileges()) {
						final org.nerdizin.eztrial.entities.admin.Privilege privilegeEntity =
								privilegeConverter.convertToEntity(privilege);
						roleEntity.addPrivilege(privilegeEntity);
						privilegeRepository.save(privilegeEntity);
					}
				}
				roleRepository.save(roleEntity);
			}
		}
		if (adminData.getUsers() != null) {
			importUsers(adminData);
		}
		if (adminData.getSignatureDefs() != null) {
			final SignatureDefConverter signatureDefConverter = new SignatureDefConverter();
			for (final SignatureDef signatureDef : adminData.getSignatureDefs()) {
				signatureDefRepository.save(signatureDefConverter.convertToEntity(signatureDef));
			}
		}
	}

	private void importUsers(final AdminData adminData) {
		final UserConverter userConverter = new UserConverter();
		for (final User user : adminData.getUsers()) {
			final org.nerdizin.eztrial.entities.admin.User userEntity = userConverter.convertToEntity(user);
			if (user.getAddress() != null) {
				final AddressConverter addressConverter = new AddressConverter();
				final Address address = addressConverter.convertToEntity(user.getAddress());
				addressRepository.save(address);
				userEntity.setAddress(address);
			}
			if (user.getRoleRefs() != null) {
				for (final RoleRef roleRef : user.getRoleRefs()) {
					final Optional<org.nerdizin.eztrial.entities.admin.Role> targetRole =
							roleRepository.findByOid(roleRef.getRoleOid());
					if (targetRole.isPresent()) {
						userEntity.addRole(targetRole.get());
					} else {
						log.error(String.format("Could not find role with oid %s for user %s", roleRef.getRoleOid(), user.getOid()));
					}
				}
			}
			userRepository.save(userEntity);
		}
	}

	private void importAdminDataRefs(final AdminData adminData) {

		if (adminData.getLocations() != null) {
			for (final Location location : adminData.getLocations()) {
				if (location.getMetaDataVersionRefs() != null) {
					for (final MetaDataVersionRef metaDataVersionRef : location.getMetaDataVersionRefs()) {

						final Optional<org.nerdizin.eztrial.entities.study.def.MetaDataVersion> targetMetaDataVersionOpt =
								metaDataVersionRepository.findByOid(metaDataVersionRef.getMetaDataVersionOid());
						if (targetMetaDataVersionOpt.isEmpty()) {
							throw new IllegalArgumentException(String.format("Could not find mdv with oid %s",
									metaDataVersionRef.getMetaDataVersionOid()));
						}
						final Optional<org.nerdizin.eztrial.entities.study.def.Study> targetStudyOpt =
								studyRepository.findByOid(metaDataVersionRef.getStudyOid());
						if (targetStudyOpt.isEmpty()) {
							throw new IllegalArgumentException(String.format("Could not find study with oid %s",
									metaDataVersionRef.getStudyOid()));
						}
						final Optional<org.nerdizin.eztrial.entities.admin.Location> targetLocationOpt =
								locationRepository.findByOid(location.getOid());
						if (targetLocationOpt.isEmpty()) {
							throw new IllegalArgumentException(String.format("Could not find location with oid %s",
									location.getOid()));
						}
						org.nerdizin.eztrial.entities.admin.Location targetLocation = targetLocationOpt.get();

						final org.nerdizin.eztrial.entities.admin.MetaDataVersionRef metaDataVersionRefEntity =
								new org.nerdizin.eztrial.entities.admin.MetaDataVersionRef();
						metaDataVersionRefEntity.setLocation(targetLocation);
						metaDataVersionRefEntity.setMetaDataVersion(targetMetaDataVersionOpt.get());
						metaDataVersionRefEntity.setStudy(targetStudyOpt.get());
						metaDataVersionRefEntity.setEffectiveDate(metaDataVersionRef.getEffectiveDate());

						targetLocation.addMetaDataVersionRef(metaDataVersionRefEntity);
						locationRepository.save(targetLocation);
					}
				}
			}
		}
	}
}
