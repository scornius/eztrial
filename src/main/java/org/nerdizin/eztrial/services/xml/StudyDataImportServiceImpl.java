package org.nerdizin.eztrial.services.xml;

import org.nerdizin.eztrial.entities.elementconverter.data.*;
import org.nerdizin.eztrial.entities.study.def.MetaDataVersion;
import org.nerdizin.eztrial.repositories.study.data.*;
import org.nerdizin.eztrial.repositories.study.def.MetaDataVersionRepository;
import org.nerdizin.eztrial.xml.odm.Odm;
import org.nerdizin.eztrial.xml.odm.study.data.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudyDataImportServiceImpl implements StudyDataImportService {

    private final static Logger log = LoggerFactory.getLogger(StudyDataImportServiceImpl.class);

    private final MetaDataVersionRepository metaDataVersionRepository;
    private final SubjectDataRepository subjectDataRepository;
    private final StudyEventDataRepository eventDataRepository;
    private final FormDataRepository formDataRepository;
    private final ItemGroupDataRepository itemGroupDataRepository;
    private final ItemDataRepository itemDataRepository;

    private final static SubjectConverter subjectConverter = new SubjectConverter();
    private final static StudyEventDataConverter eventDataConverter = new StudyEventDataConverter();
    private final static FormDataConverter formDataConverter = new FormDataConverter();
    private final static ItemGroupDataConverter itemGroupDataConverter = new ItemGroupDataConverter();
    private final static ItemDataConverter itemDataConverter = new ItemDataConverter();

    @Autowired
    public StudyDataImportServiceImpl(final SubjectDataRepository subjectDataRepository,
                                      final MetaDataVersionRepository metaDataVersionRepository,
                                      final StudyEventDataRepository eventDataRepository,
                                      final FormDataRepository formDataRepository,
                                      final ItemGroupDataRepository itemGroupDataRepository,
                                      final ItemDataRepository itemDataRepository) {
        this.subjectDataRepository = subjectDataRepository;
        this.metaDataVersionRepository = metaDataVersionRepository;
        this.eventDataRepository = eventDataRepository;
        this.formDataRepository = formDataRepository;
        this.itemGroupDataRepository = itemGroupDataRepository;
        this.itemDataRepository = itemDataRepository;
    }

    @Override
    public void importStudyData(final Odm odm) {

        if (odm.getClinicalData() != null) {
            final String mdvOid = odm.getClinicalData().getMetaDataVersionOid();
            final Optional<MetaDataVersion> opt = metaDataVersionRepository.findByOid(mdvOid);
            if (opt.isEmpty()) {
                throw new IllegalArgumentException(String.format("No mdv found with oid %s", mdvOid));
            }

            if (odm.getClinicalData().getSubjectDatas() != null) {
                for (final SubjectData subjectData : odm.getClinicalData().getSubjectDatas()) {
                    importSubjectData(subjectData, opt.get());
                }
            }
        }
    }

    private void importSubjectData(final SubjectData subjectData,
                                   final MetaDataVersion mdv) {

        final org.nerdizin.eztrial.entities.study.data.SubjectData subjectEntity =
                subjectConverter.convertToEntity(subjectData);
        subjectEntity.setMdv(mdv);
        subjectDataRepository.save(subjectEntity);

        if (subjectData.getStudyEventDatas() != null) {
            for (final StudyEventData eventData : subjectData.getStudyEventDatas()) {
                importStudyEventData(eventData, subjectEntity);
            }
        }
    }

    private void importStudyEventData(final StudyEventData studyEventData,
                                      final org.nerdizin.eztrial.entities.study.data.SubjectData subjectEntity) {

        final org.nerdizin.eztrial.entities.study.data.StudyEventData eventEntity =
                eventDataConverter.convertToEntity(studyEventData);
        eventEntity.setSubject(subjectEntity);
        eventDataRepository.save(eventEntity);

        if (studyEventData.getFormDatas() != null) {
            for (final FormData formData : studyEventData.getFormDatas()) {
                importFormData(formData, eventEntity);
            }
        }
    }

    private void importFormData(final FormData formData,
                                final org.nerdizin.eztrial.entities.study.data.StudyEventData eventEntity) {

        final org.nerdizin.eztrial.entities.study.data.FormData formEntity =
                formDataConverter.convertToEntity(formData);
        formEntity.setEvent(eventEntity);
        formDataRepository.save(formEntity);

        if (formData.getItemGroupDatas() != null) {
            for (final ItemGroupData itemGroupData : formData.getItemGroupDatas()) {
                importItemGroupData(itemGroupData, formEntity);
            }
        }
    }

    private void importItemGroupData(final ItemGroupData itemGroupData,
                                     final org.nerdizin.eztrial.entities.study.data.FormData formEntity) {

        final org.nerdizin.eztrial.entities.study.data.ItemGroupData itemGroupEntity =
                itemGroupDataConverter.convertToEntity(itemGroupData);
        itemGroupEntity.setForm(formEntity);
        itemGroupDataRepository.save(itemGroupEntity);

        if (itemGroupData.getItemDatas() != null) {
            for (final ItemData itemData : itemGroupData.getItemDatas()) {
                importItemData(itemData, itemGroupEntity);
            }
        }
    }

    private void importItemData(final ItemData itemData,
                                final org.nerdizin.eztrial.entities.study.data.ItemGroupData itemGroupEntity) {

        final org.nerdizin.eztrial.entities.study.data.ItemData itemEntity =
                itemDataConverter.convertToEntity(itemData);
        itemEntity.setItemGroup(itemGroupEntity);
        itemDataRepository.save(itemEntity);
    }
}