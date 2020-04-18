package org.nerdizin.eztrial.services.xml;

import org.nerdizin.eztrial.entities.elementconverter.data.SubjectConverter;
import org.nerdizin.eztrial.entities.study.def.MetaDataVersion;
import org.nerdizin.eztrial.repositories.study.data.SubjectDataRepository;
import org.nerdizin.eztrial.repositories.study.def.MetaDataVersionRepository;
import org.nerdizin.eztrial.xml.odm.Odm;
import org.nerdizin.eztrial.xml.odm.study.data.SubjectData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudyDataImportServiceImpl implements StudyDataImportService {

    private final static Logger log = LoggerFactory.getLogger(StudyDataImportServiceImpl.class);

    private final SubjectDataRepository subjectDataRepository;
    private final MetaDataVersionRepository metaDataVersionRepository;

    @Autowired
    public StudyDataImportServiceImpl(final SubjectDataRepository subjectDataRepository,
                                      final MetaDataVersionRepository metaDataVersionRepository) {
        this.subjectDataRepository = subjectDataRepository;
        this.metaDataVersionRepository = metaDataVersionRepository;
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

        final SubjectConverter subjectConverter = new SubjectConverter();
        final org.nerdizin.eztrial.entities.study.data.SubjectData subjectEntity =
                subjectConverter.convertToEntity(subjectData);
        subjectEntity.setMdv(mdv);
        subjectDataRepository.save(subjectEntity);

        // TODO
    }
}
