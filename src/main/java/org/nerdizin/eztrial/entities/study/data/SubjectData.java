package org.nerdizin.eztrial.entities.study.data;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.nerdizin.eztrial.entities.base.BaseEntity;
import org.nerdizin.eztrial.entities.study.def.MetaDataVersion;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "data_subjects")
public class SubjectData extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "mdv_id")
    private MetaDataVersion mdv;

    @OneToMany(mappedBy = "subject", orphanRemoval = true, cascade = CascadeType.MERGE)
    private List<StudyEventData> events;

    @Column(name = "subject_key")
    private String subjectKey;


    public MetaDataVersion getMdv() {
        return mdv;
    }

    public void setMdv(final MetaDataVersion mdv) {
        this.mdv = mdv;
    }

    public String getSubjectKey() {
        return subjectKey;
    }

    public void setSubjectKey(final String subjectKey) {
        this.subjectKey = subjectKey;
    }

    public List<StudyEventData> getEvents() {
        return events;
    }

    public void setEvents(final List<StudyEventData> events) {
        this.events = events;
    }

    public void addEvent(final StudyEventData event) {
        if (this.events == null) {
            this.events = new ArrayList<>();
        }
        this.events.add(event);
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
