package org.nerdizin.eztrial.xml.odm.study;

import javax.xml.bind.annotation.XmlElement;
import java.util.List;

public class Question {

	@XmlElement(name = "TranslatedText")
	private List<TranslatedText> translatedTexts;


	public List<TranslatedText> getTranslatedTexts() {
		return translatedTexts;
	}

	public void setTranslatedTexts(final List<TranslatedText> translatedTexts) {
		this.translatedTexts = translatedTexts;
	}
}
