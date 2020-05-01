package org.nerdizin.eztrial.services.xml;

import org.nerdizin.eztrial.entities.elementconverter.data.*;
import org.nerdizin.eztrial.entities.study.data.*;
import org.nerdizin.eztrial.entities.study.def.MetaDataVersion;
import org.nerdizin.eztrial.repositories.study.data.*;
import org.nerdizin.eztrial.repositories.study.def.MetaDataVersionRepository;
import org.nerdizin.eztrial.xml.odm.FileType;
import org.nerdizin.eztrial.xml.odm.study.data.ClinicalData;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudyDataExportServiceImpl implements StudyDataExportService {

    private final MetaDataVersionRepository metaDataVersionRepository;
    private final SubjectDataRepository subjectDataRepository;
    private final StudyEventDataRepository eventDataRepository;
    private final FormDataRepository formDataRepository;
    private final ItemGroupDataRepository itemGroupDataRepository;
    private final ItemDataRepository itemDataRepository;

    private static final SubjectConverter subjectConverter = new SubjectConverter();
    private final static StudyEventDataConverter eventDataConverter = new StudyEventDataConverter();
    private final static FormDataConverter formDataConverter = new FormDataConverter();
    private final static ItemGroupDataConverter itemGroupDataConverter = new ItemGroupDataConverter();
    private final static ItemDataConverter itemDataConverter = new ItemDataConverter();

    public StudyDataExportServiceImpl(final SubjectDataRepository subjectDataRepository,
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
    public ClinicalData exportStudyData(final String studyOid,
                                        final String mdvOid,
                                        final FileType fileType) {

        final Optional<MetaDataVersion> mdvOpt = metaDataVersionRepository.findByOid(mdvOid);
        if (mdvOpt.isEmpty()) {
            throw new IllegalArgumentException(String.format("Could not find mdv with oid %s", mdvOid));
        }

        final ClinicalData clinicalData = new ClinicalData();
        clinicalData.setStudyOid(studyOid);
        clinicalData.setMetaDataVersionOid(mdvOid);

        final List<SubjectData> subjects = subjectDataRepository.findAllByMdv(mdvOpt.get());
        for (final SubjectData subject : subjects) {
            exportSubject(clinicalData, subject);
        }

        return clinicalData;
    }

    private void exportSubject(final ClinicalData clinicalData, final SubjectData subjectDataEntity) {

        final org.nerdizin.eztrial.xml.odm.study.data.SubjectData subjectData =
                subjectConverter.convertToElement(subjectDataEntity);
        clinicalData.addSubjectData(subjectData);

        final List<StudyEventData> events = eventDataRepository.findAllBySubject(subjectDataEntity);
        for (final StudyEventData event : events) {
            exportEvent(subjectData, event);
        }
    }

    private void exportEvent(final org.nerdizin.eztrial.xml.odm.study.data.SubjectData subject,
                             final StudyEventData eventEntity) {

        final org.nerdizin.eztrial.xml.odm.study.data.StudyEventData eventData =
                eventDataConverter.convertToElement(eventEntity);
        subject.addStudyEventData(eventData);

        final List<FormData> forms = formDataRepository.findAllByEvent(eventEntity);
        for (final FormData form : forms) {
            exportForm(eventData, form);
        }
    }

    private void exportForm(final org.nerdizin.eztrial.xml.odm.study.data.StudyEventData event,
                            final FormData formEntity) {

        final org.nerdizin.eztrial.xml.odm.study.data.FormData formData =
                formDataConverter.convertToElement(formEntity);
        event.addFormData(formData);

        final List<ItemGroupData> itemGroups = itemGroupDataRepository.findAllByForm(formEntity);
        for (final ItemGroupData itemGroup : itemGroups) {
            exportItemGroup(formData, itemGroup);
        }
    }

    private void exportItemGroup(final org.nerdizin.eztrial.xml.odm.study.data.FormData formData,
                                 final ItemGroupData itemGroupEntity) {

        final org.nerdizin.eztrial.xml.odm.study.data.ItemGroupData itemGroupData =
                itemGroupDataConverter.convertToElement(itemGroupEntity);
        formData.addItemGroup(itemGroupData);

        final List<ItemData> items = itemDataRepository.findAllByItemGroup(itemGroupEntity);
        for (final ItemData item : items) {
            exportItem(itemGroupData, item);
        }
    }

    private void exportItem(final org.nerdizin.eztrial.xml.odm.study.data.ItemGroupData itemGroupData,
                            final ItemData item) {

        org.nerdizin.eztrial.xml.odm.study.data.ItemData itemData =
                itemDataConverter.convertToElement(item);
        itemGroupData.addItemData(itemData);
    }
}
