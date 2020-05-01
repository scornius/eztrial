package org.nerdizin.eztrial.xml.odm.study.def;

import org.nerdizin.eztrial.xml.Namespaces;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlValue;

public class TranslatedText {

	@XmlAttribute(name = "lang", namespace = Namespaces.XML)
	private String language;

	@XmlValue
	private String text;

	public TranslatedText() {}

	public TranslatedText(final String language, final String text) {
		this.language = language;
		this.text = text;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(final String language) {
		this.language = language;
	}

	public String getText() {
		return text;
	}

	public void setText(final String text) {
		this.text = text;
	}
}
