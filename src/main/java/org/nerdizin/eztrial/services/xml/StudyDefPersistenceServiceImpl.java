package org.nerdizin.eztrial.services.xml;

import org.nerdizin.eztrial.entities.admin.Address;
import org.nerdizin.eztrial.entities.elementconverter.*;
import org.nerdizin.eztrial.entities.study.EventDef;
import org.nerdizin.eztrial.entities.study.EventRef;
import org.nerdizin.eztrial.repositories.*;
import org.nerdizin.eztrial.xml.odm.Odm;
import org.nerdizin.eztrial.xml.odm.admin.*;
import org.nerdizin.eztrial.xml.odm.study.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudyDefPersistenceServiceImpl implements StudyDefPersistenceService {

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
	public StudyDefPersistenceServiceImpl(final LocationRepository locationRepository,
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
	public void persistStudyDef(final Odm odm) {

		if (odm.getAdminData() != null) {
			persistAdminData(odm.getAdminData());
		}
		if (odm.getStudy() != null) {
			persistStudy(odm.getStudy());
		}
		if (odm.getAdminData() != null) {
			persistAdminDataRefs(odm.getAdminData());
		}
	}

	private void persistStudy(final Study study) {

		final StudyConverter studyConverter = new StudyConverter();
		final org.nerdizin.eztrial.entities.study.Study studyEntity = studyConverter.convert2Entity(study);
		studyRepository.save(studyEntity);

		if (study.getBasicDefinitions() != null) {
			if (study.getBasicDefinitions().getMeasurementUnits() != null) {
				final MeasurementUnitConverter measurementUnitConverter = new MeasurementUnitConverter();
				for (final MeasurementUnit measurementUnit : study.getBasicDefinitions().getMeasurementUnits()) {
					final org.nerdizin.eztrial.entities.study.MeasurementUnit measurementEntity =
							measurementUnitConverter.convert2Entity(measurementUnit);
					measurementEntity.setStudy(studyEntity);
					measurementUnitRepository.save(measurementEntity);
					studyEntity.addMeasurementUnit(measurementEntity);
				}
			}
		}

		if (study.getMetaDataVersions() != null) {
			for (final MetaDataVersion metaDataVersion : study.getMetaDataVersions()) {
				final org.nerdizin.eztrial.entities.study.MetaDataVersion metaDataVersionEntity =
						persistDefs(studyEntity, metaDataVersion);
				persistRefs(studyEntity, metaDataVersion, metaDataVersionEntity);
			}
		}
	}

	private org.nerdizin.eztrial.entities.study.MetaDataVersion persistDefs(
			final org.nerdizin.eztrial.entities.study.Study studyEntity,
			final MetaDataVersion metaDataVersion) {

		final MetaDataVersionConverter metaDataVersionConverter = new MetaDataVersionConverter();

		final org.nerdizin.eztrial.entities.study.MetaDataVersion metaDataVersionEntity =
				metaDataVersionConverter.convert2Entity(metaDataVersion);
		metaDataVersionEntity.setStudy(studyEntity);
		metaDataVersionRepository.save(metaDataVersionEntity);
		studyEntity.addMetaDataVersion(metaDataVersionEntity);

		if (metaDataVersion.getProtocol() != null) {
			persistProtocolDef(metaDataVersion, metaDataVersionEntity);
		}
		if (metaDataVersion.getStudyElementDefs() != null) {
			persistEventDef(metaDataVersion, metaDataVersionEntity);
		}
		if (metaDataVersion.getFormDefs() != null) {
			persistFormDef(metaDataVersion, metaDataVersionEntity);
		}
		if (metaDataVersion.getItemGroupDefs() != null) {
			persistItemGroupDef(metaDataVersion, metaDataVersionEntity);
		}
		if (metaDataVersion.getItemDefs() != null) {
			persistItemDef(metaDataVersion, metaDataVersionEntity);
		}
		return metaDataVersionEntity;
	}

	private void persistItemDef(final MetaDataVersion metaDataVersion,
			final org.nerdizin.eztrial.entities.study.MetaDataVersion metaDataVersionEntity) {
		final ItemDefConverter itemDefConverter = new ItemDefConverter();
		for (final ItemDef itemDef : metaDataVersion.getItemDefs()) {
			final org.nerdizin.eztrial.entities.study.ItemDef itemDefEntity = itemDefConverter.convert2Entity(itemDef);
			itemDefEntity.setMetaDataVersion(metaDataVersionEntity);
			itemDefRepository.save(itemDefEntity);
			metaDataVersionEntity.addItemDef(itemDefEntity);
		}
	}

	private void persistItemGroupDef(final MetaDataVersion metaDataVersion,
			final org.nerdizin.eztrial.entities.study.MetaDataVersion metaDataVersionEntity) {
		final ItemGroupDefConverter itemGroupDefConverter = new ItemGroupDefConverter();
		for (final ItemGroupDef itemGroupDef : metaDataVersion.getItemGroupDefs()) {
			final org.nerdizin.eztrial.entities.study.ItemGroupDef itemGroupDefEntity =
					itemGroupDefConverter.convert2Entity(itemGroupDef);
			itemGroupDefEntity.setMetaDataVersion(metaDataVersionEntity);
			itemGroupDefRepository.save(itemGroupDefEntity);
			metaDataVersionEntity.addItemGroupDef(itemGroupDefEntity);
		}
	}

	private void persistFormDef(final MetaDataVersion metaDataVersion,
			final org.nerdizin.eztrial.entities.study.MetaDataVersion metaDataVersionEntity) {
		final FormDefConverter formDefConverter = new FormDefConverter();
		for (final FormDef formDef : metaDataVersion.getFormDefs()) {
			final org.nerdizin.eztrial.entities.study.FormDef formDefEntity = formDefConverter.convert2Entity(formDef);
			formDefEntity.setMetaDataVersion(metaDataVersionEntity);
			formDefRepository.save(formDefEntity);
			metaDataVersionEntity.addFormDef(formDefEntity);
		}
	}

	private void persistEventDef(final MetaDataVersion metaDataVersion,
			final org.nerdizin.eztrial.entities.study.MetaDataVersion metaDataVersionEntity) {
		final EventDefConverter eventDefConverter = new EventDefConverter();
		for (final StudyEventDef studyElementDef : metaDataVersion.getStudyElementDefs()) {
			final EventDef eventDefEntity = eventDefConverter.convert2Entity(studyElementDef);
			eventDefEntity.setMetaDataVersion(metaDataVersionEntity);
			eventDefRepository.save(eventDefEntity);
			metaDataVersionEntity.addEventDef(eventDefEntity);
		}
	}

	private void persistProtocolDef(final MetaDataVersion metaDataVersion,
			final org.nerdizin.eztrial.entities.study.MetaDataVersion metaDataVersionEntity) {
		final ProtocolConverter protocolConverter = new ProtocolConverter();
		final org.nerdizin.eztrial.entities.study.Protocol protocolEntity =
				protocolConverter.convert2Entity(metaDataVersion.getProtocol());
		protocolEntity.setMetaDataVersion(metaDataVersionEntity);
		protocolRepository.save(protocolEntity);
		metaDataVersionEntity.setProtocol(protocolEntity);
	}

	private void persistRefs(final org.nerdizin.eztrial.entities.study.Study studyEntity,
			final MetaDataVersion metaDataVersion,
			final org.nerdizin.eztrial.entities.study.MetaDataVersion metaDataVersionEntity) {

		if (metaDataVersion.getProtocol() != null && metaDataVersion.getProtocol().getStudyEventRefs() != null) {
			for (final StudyEventRef eventRef : metaDataVersion.getProtocol().getStudyEventRefs()) {
				final org.nerdizin.eztrial.entities.study.Protocol protocolEntity = metaDataVersionEntity.getProtocol();
				final EventDef targetEventDef = metaDataVersionEntity.findEventDefByOid(eventRef.getStudyEventOid());
				final EventRef eventRefEntity = new EventRef();
				eventRefEntity.setProtocol(protocolEntity);
				eventRefEntity.setEventDef(targetEventDef);
				eventRefEntity.setMandatory(eventRef.getMandatory());
				eventRefRepository.save(eventRefEntity);
				protocolEntity.addEventRef(eventRefEntity);
			}
		}

		if (metaDataVersion.getStudyElementDefs() != null) {
			persistFormRefs(metaDataVersion, metaDataVersionEntity);
		}
		if (metaDataVersion.getFormDefs() != null) {
			persistItemGroupRefs(metaDataVersion, metaDataVersionEntity);
		}
		if (metaDataVersion.getItemGroupDefs() != null) {
			persistItemRefs(metaDataVersion, metaDataVersionEntity);
		}
	}

	private void persistFormRefs(final MetaDataVersion metaDataVersion,
			final org.nerdizin.eztrial.entities.study.MetaDataVersion metaDataVersionEntity) {

		for (final StudyEventDef eventDef : metaDataVersion.getStudyElementDefs()) {
			if (eventDef.getFormRefs() != null) {
				final EventDef eventDefEntity = metaDataVersionEntity.findEventDefByOid(eventDef.getOid());
				for (final FormRef formRef : eventDef.getFormRefs()) {
					final org.nerdizin.eztrial.entities.study.FormDef targetFormDef =
							metaDataVersionEntity.findFormDefByOid(formRef.getFormOid());
					final org.nerdizin.eztrial.entities.study.FormRef formRefEntity =
							new org.nerdizin.eztrial.entities.study.FormRef();
					formRefEntity.setEventDef(eventDefEntity);
					formRefEntity.setFormDef(targetFormDef);
					formRefEntity.setMandatory(formRef.getMandatory());
					formRefRepository.save(formRefEntity);
					eventDefEntity.addFormRef(formRefEntity);
				}
			}
		}
	}

	private void persistItemGroupRefs(final MetaDataVersion metaDataVersion,
			final org.nerdizin.eztrial.entities.study.MetaDataVersion metaDataVersionEntity) {

		for (final FormDef formDef : metaDataVersion.getFormDefs()) {
			if (formDef.getItemGroupRefs() != null) {
				final org.nerdizin.eztrial.entities.study.FormDef formDefEntity = metaDataVersionEntity.findFormDefByOid(formDef.getOid());
				for (final ItemGroupRef itemGroupRef : formDef.getItemGroupRefs()) {
					final org.nerdizin.eztrial.entities.study.ItemGroupDef targetItemGroupDef =
							metaDataVersionEntity.findItemGroupDefByOid(itemGroupRef.getItemGroupOid());
					final org.nerdizin.eztrial.entities.study.ItemGroupRef itemGroupRefEntity =
							new org.nerdizin.eztrial.entities.study.ItemGroupRef();
					itemGroupRefEntity.setFormDef(formDefEntity);
					itemGroupRefEntity.setItemGroupDef(targetItemGroupDef);
					itemGroupRefEntity.setMandatory(itemGroupRef.getMandatory());
					itemGroupRefRepository.save(itemGroupRefEntity);
					formDefEntity.addItemGroupRef(itemGroupRefEntity);
				}
			}
		}
	}

	private void persistItemRefs(final MetaDataVersion metaDataVersion,
			final org.nerdizin.eztrial.entities.study.MetaDataVersion metaDataVersionEntity) {

		for (final ItemGroupDef itemGroupDef : metaDataVersion.getItemGroupDefs()) {
			if (itemGroupDef.getItemRefs() != null) {
				final org.nerdizin.eztrial.entities.study.ItemGroupDef itemGroupDefEntity =
						metaDataVersionEntity.findItemGroupDefByOid(itemGroupDef.getOid());
				for (final ItemRef itemRef : itemGroupDef.getItemRefs()) {
					final org.nerdizin.eztrial.entities.study.ItemDef targetItemDef =
							metaDataVersionEntity.findItemDefByOid(itemRef.getItemOid());
					final org.nerdizin.eztrial.entities.study.ItemRef itemRefEntity =
							new org.nerdizin.eztrial.entities.study.ItemRef();
					itemRefEntity.setItemGroupDef(itemGroupDefEntity);
					itemRefEntity.setItemDef(targetItemDef);
					itemRefEntity.setMandatory(itemRef.getMandatory());
					itemRefRepository.save(itemRefEntity);
					itemGroupDefEntity.addItemRef(itemRefEntity);
				}
			}
		}
	}

	private void persistAdminData(final AdminData adminData) {

		if (adminData.getLocations() != null) {
			final LocationConverter locationConverter = new LocationConverter();
			for (final Location location : adminData.getLocations()) {
				locationRepository.save(locationConverter.convert2Entity(location));
			}
		}
		if (adminData.getUsers() != null) {
			final UserConverter userConverter = new UserConverter();
			for (final User user : adminData.getUsers()) {
				final org.nerdizin.eztrial.entities.admin.User userEntity = userConverter.convert2Entity(user);
				if (user.getAddress() != null) {
					final AddressConverter addressConverter = new AddressConverter();
					final Address address = addressConverter.convert2Entity(user.getAddress());
					addressRepository.save(address);
					userEntity.setAddress(address);
				}
				userRepository.save(userEntity);
			}
		}
		if (adminData.getSignatureDefs() != null) {
			final SignatureDefConverter signatureDefConverter = new SignatureDefConverter();
			for (final SignatureDef signatureDef : adminData.getSignatureDefs()) {
				signatureDefRepository.save(signatureDefConverter.convert2Entity(signatureDef));
			}
		}
	}

	private void persistAdminDataRefs(final AdminData adminData) {

		if (adminData.getLocations() != null) {
			for (final Location location : adminData.getLocations()) {
				if (location.getMetaDataVersionRefs() != null) {
					for (final MetaDataVersionRef metaDataVersionRef : location.getMetaDataVersionRefs()) {

						final org.nerdizin.eztrial.entities.study.MetaDataVersion targetMetaDataVersion =
								metaDataVersionRepository.findByOid(metaDataVersionRef.getMetaDataVersionOid());
						final org.nerdizin.eztrial.entities.study.Study targetStudy =
								studyRepository.findByOid(metaDataVersionRef.getStudyOid());

						final org.nerdizin.eztrial.entities.admin.MetaDataVersionRef metaDataVersionRefEntity =
								new org.nerdizin.eztrial.entities.admin.MetaDataVersionRef();
						metaDataVersionRefEntity.setMetaDataVersion(targetMetaDataVersion);
						metaDataVersionRefEntity.setStudy(targetStudy);
						metaDataVersionRefEntity.setEffectiveDate(metaDataVersionRef.getEffectiveDate());
						
						metaDataVersionRefRepository.save(metaDataVersionRefEntity);
					}
				}
			}
		}
	}
}
