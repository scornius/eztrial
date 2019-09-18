package org.nerdizin.eztrial.xml.odm.study;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import java.util.List;


public class MetaDataVersion {

    @XmlAttribute(name = "OID")
    private String oid;

    @XmlAttribute(name = "Name")
    private String name;

    @XmlElement(name = "Protocol")
	private Protocol protocol;

    @XmlElement(name = "StudyEventDef")
    private List<StudyEventDef> studyElementDefs;

    @XmlElement(name = "FormDef")
    private List<FormDef> formDefs;

    @XmlElement(name = "ItemGroupDef")
    private List<ItemGroupDef> itemGroupDefs;

    @XmlElement(name = "ItemDef")
    private List<ItemDef> itemDefs;


    public String getOid() {
        return oid;
    }

    public void setOid(final String oid) {
        this.oid = oid;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

	public Protocol getProtocol() {
		return protocol;
	}

	public void setProtocol(final Protocol protocol) {
		this.protocol = protocol;
	}

	public List<StudyEventDef> getStudyElementDefs() {
        return studyElementDefs;
    }

    public void setStudyElementDefs(final List<StudyEventDef> studyElementDefs) {
        this.studyElementDefs = studyElementDefs;
    }

    public List<FormDef> getFormDefs() {
        return formDefs;
    }

    public void setFormDefs(final List<FormDef> formDefs) {
        this.formDefs = formDefs;
    }

    public List<ItemGroupDef> getItemGroupDefs() {
        return itemGroupDefs;
    }

    public void setItemGroupDefs(final List<ItemGroupDef> itemGroupDefs) {
        this.itemGroupDefs = itemGroupDefs;
    }

    public List<ItemDef> getItemDefs() {
        return itemDefs;
    }

    public void setItemDefs(final List<ItemDef> itemDefs) {
        this.itemDefs = itemDefs;
    }
}
