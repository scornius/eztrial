package org.nerdizin.eztrial.xml.odm.study;

import javax.xml.bind.annotation.XmlElement;
import java.util.List;

public class Protocol {

	@XmlElement(name = "StudyEventRef")
	private List<StudyEventRefElement> studyEventRefs;


	public List<StudyEventRefElement> getStudyEventRefs() {
		return studyEventRefs;
	}

	public void setStudyEventRefs(final List<StudyEventRefElement> studyEventRefs) {
		this.studyEventRefs = studyEventRefs;
	}
}
