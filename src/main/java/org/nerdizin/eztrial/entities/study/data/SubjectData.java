package org.nerdizin.eztrial.entities.study.data;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.nerdizin.eztrial.entities.base.BaseEntity;
import org.nerdizin.eztrial.entities.study.def.MetaDataVersion;

import javax.persistence.*;

@Entity
@Table(name = "data_subjects")
public class SubjectData extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "mdv_id")
    private MetaDataVersion mdv;

    @Column(name = "subject_key")
    private String subjectKey;


    public MetaDataVersion getMdv() {
        return mdv;
    }

    public void setMdv(MetaDataVersion mdv) {
        this.mdv = mdv;
    }

    public String getSubjectKey() {
        return subjectKey;
    }

    public void setSubjectKey(String subjectKey) {
        this.subjectKey = subjectKey;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
