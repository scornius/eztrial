package org.nerdizin.eztrial.xml.odm.study.data;

import org.nerdizin.eztrial.xml.odm.base.OdmElement;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import java.util.ArrayList;
import java.util.List;

public class StudyEventData implements OdmElement {

    @XmlAttribute(name = "StudyEventOID")
    private String studyEventOid;

    @XmlElement(name = "FormData")
    private List<FormData> formDatas;


    public String getStudyEventOid() {
        return studyEventOid;
    }

    public void setStudyEventOid(final String studyEventOid) {
        this.studyEventOid = studyEventOid;
    }

    public List<FormData> getFormDatas() {
        return formDatas;
    }

    public void setFormDatas(final List<FormData> formDatas) {
        this.formDatas = formDatas;
    }

    public void addFormData(final FormData formData) {
        if (this.formDatas == null) {
            this.formDatas = new ArrayList<>();
        }
        this.formDatas.add(formData);
    }
}
