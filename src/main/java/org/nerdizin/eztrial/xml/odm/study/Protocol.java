package org.nerdizin.eztrial.xml.odm.study;

import javax.xml.bind.annotation.XmlElement;
import java.util.List;

public class Protocol {

	@XmlElement(name = "StudyEventRef")
	private List<StudyEventRef> studyEventRefs;


	public List<StudyEventRef> getStudyEventRefs() {
		return studyEventRefs;
	}

	public void setStudyEventRefs(final List<StudyEventRef> studyEventRefs) {
		this.studyEventRefs = studyEventRefs;
	}
}
