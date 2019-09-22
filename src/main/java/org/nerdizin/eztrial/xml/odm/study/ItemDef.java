package org.nerdizin.eztrial.xml.odm.study;

import org.nerdizin.eztrial.xml.Namespaces;
import org.nerdizin.eztrial.xml.adapter.DataTypeAdapter;
import org.nerdizin.eztrial.xml.odm.base.DefElement;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

public class ItemDef extends DefElement {

	@XmlElement(name = "Question")
	private Question question;

	@XmlAttribute(name = "DataType")
	@XmlJavaTypeAdapter(DataTypeAdapter.class)
	private DataType dataType;

    @XmlElement(name = "Script", namespace = Namespaces.EZTRIAL)
    private Script script;


	public Question getQuestion() {
		return question;
	}

	public void setQuestion(final Question question) {
		this.question = question;
	}

	public DataType getDataType() {
		return dataType;
	}

	public void setDataType(final DataType dataType) {
		this.dataType = dataType;
	}

	public Script getScript() {
		return script;
	}

	public void setScript(final Script script) {
		this.script = script;
	}
}
