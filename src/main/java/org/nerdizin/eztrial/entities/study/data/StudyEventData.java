package org.nerdizin.eztrial.entities.study.data;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.nerdizin.eztrial.entities.base.OidEntity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "data_events")
public class StudyEventData extends OidEntity {

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "subject_id")
    private SubjectData subject;

    @OneToMany(mappedBy = "event", orphanRemoval = true, cascade = CascadeType.MERGE)
    private List<FormData> forms;


    public SubjectData getSubject() {
        return subject;
    }

    public void setSubject(final SubjectData subjectData) {
        this.subject = subjectData;
    }

    public List<FormData> getForms() {
        return forms;
    }

    public void setForms(final List<FormData> forms) {
        this.forms = forms;
    }

    public void addForm(final FormData form) {
        if (this.forms == null) {
            this.forms = new ArrayList<>();
        }
        this.forms.add(form);
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
