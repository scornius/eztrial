package org.nerdizin.eztrial.xml.odm.study;

import org.nerdizin.eztrial.xml.odm.base.OidNameElement;

import javax.xml.bind.annotation.XmlElement;
import java.util.List;


public class MetaDataVersion extends OidNameElement {

    @XmlElement(name = "Protocol")
	private Protocol protocol;

    @XmlElement(name = "StudyEventDef")
    private List<StudyEventDefElement> studyElementDefs;

    @XmlElement(name = "FormDef")
    private List<FormDefElement> formDefs;

    @XmlElement(name = "ItemGroupDef")
    private List<ItemGroupDefElement> itemGroupDefs;

    @XmlElement(name = "ItemDef")
    private List<ItemDef> itemDefs;


	public Protocol getProtocol() {
		return protocol;
	}

	public void setProtocol(final Protocol protocol) {
		this.protocol = protocol;
	}

	public List<StudyEventDefElement> getStudyElementDefs() {
        return studyElementDefs;
    }

    public void setStudyElementDefs(final List<StudyEventDefElement> studyElementDefs) {
        this.studyElementDefs = studyElementDefs;
    }

    public List<FormDefElement> getFormDefs() {
        return formDefs;
    }

    public void setFormDefs(final List<FormDefElement> formDefs) {
        this.formDefs = formDefs;
    }

    public List<ItemGroupDefElement> getItemGroupDefs() {
        return itemGroupDefs;
    }

    public void setItemGroupDefs(final List<ItemGroupDefElement> itemGroupDefs) {
        this.itemGroupDefs = itemGroupDefs;
    }

    public List<ItemDef> getItemDefs() {
        return itemDefs;
    }

    public void setItemDefs(final List<ItemDef> itemDefs) {
        this.itemDefs = itemDefs;
    }
}
