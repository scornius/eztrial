package org.nerdizin.eztrial.xml.odm.study;

import org.nerdizin.eztrial.xml.odm.base.RefElement;

import javax.xml.bind.annotation.XmlAttribute;

public class StudyEventRefElement extends RefElement {

	@XmlAttribute(name = "StudyEventOID")
	private String studyEventOid;


	public String getStudyEventOid() {
		return studyEventOid;
	}

	public void setStudyEventOid(final String studyEventOid) {
		this.studyEventOid = studyEventOid;
	}
}
