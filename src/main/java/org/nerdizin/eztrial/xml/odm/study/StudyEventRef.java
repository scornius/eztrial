package org.nerdizin.eztrial.xml.odm.study;

import javax.xml.bind.annotation.XmlAttribute;

public class StudyEventRef extends AbstractRef {

	@XmlAttribute(name = "StudyEventOID")
	private String studyEventOid;


	public String getStudyEventOid() {
		return studyEventOid;
	}

	public void setStudyEventOid(final String studyEventOid) {
		this.studyEventOid = studyEventOid;
	}
}
