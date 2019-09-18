package org.nerdizin.eztrial.xml.odm.study;

import javax.xml.bind.annotation.XmlElement;

public class Protocol {

	@XmlElement(name = "StudyEventRef")
	private StudyEventRef studyEventRef;


	public StudyEventRef getStudyEventRef() {
		return studyEventRef;
	}

	public void setStudyEventRef(final StudyEventRef studyEventRef) {
		this.studyEventRef = studyEventRef;
	}
}
