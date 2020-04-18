package org.nerdizin.eztrial.services.xml;

import org.nerdizin.eztrial.entities.elementconverter.data.SubjectConverter;
import org.nerdizin.eztrial.entities.study.data.SubjectData;
import org.nerdizin.eztrial.entities.study.def.MetaDataVersion;
import org.nerdizin.eztrial.repositories.study.data.SubjectDataRepository;
import org.nerdizin.eztrial.repositories.study.def.MetaDataVersionRepository;
import org.nerdizin.eztrial.xml.odm.FileType;
import org.nerdizin.eztrial.xml.odm.study.data.ClinicalData;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudyDataExportServiceImpl implements StudyDataExportService {

    private final SubjectDataRepository subjectDataRepository;
    private final MetaDataVersionRepository metaDataVersionRepository;

    private static final SubjectConverter subjectConverter = new SubjectConverter();

    public StudyDataExportServiceImpl(final SubjectDataRepository subjectDataRepository,
                                      final MetaDataVersionRepository metaDataVersionRepository) {
        this.subjectDataRepository = subjectDataRepository;
        this.metaDataVersionRepository = metaDataVersionRepository;
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
            loadSubject(clinicalData, subject);
        }

        return clinicalData;
    }

    private void loadSubject(final ClinicalData clinicalData, final SubjectData subjectDataEntity) {

        org.nerdizin.eztrial.xml.odm.study.data.SubjectData subjectData =
                subjectConverter.convertToElement(subjectDataEntity);

        // TODO

        clinicalData.addSubjectData(subjectData);
    }
}
