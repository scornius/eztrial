package org.nerdizin.eztrial.xml.odm.study.def;

import org.nerdizin.eztrial.xml.odm.base.OidNameElement;

import javax.xml.bind.annotation.XmlElement;
import java.util.ArrayList;
import java.util.List;


public class MetaDataVersion extends OidNameElement {

    @XmlElement(name = "Protocol")
	private Protocol protocol;

    @XmlElement(name = "StudyEventDef")
    private List<StudyEventDef> studyEventDefs;

    @XmlElement(name = "FormDef")
    private List<FormDef> formDefs;

    @XmlElement(name = "ItemGroupDef")
    private List<ItemGroupDef> itemGroupDefs;

    @XmlElement(name = "ItemDef")
    private List<ItemDef> itemDefs;


	public Protocol getProtocol() {
		return protocol;
	}

	public void setProtocol(final Protocol protocol) {
		this.protocol = protocol;
	}

	public List<StudyEventDef> getStudyEventDefs() {
        return studyEventDefs;
    }

    public void setStudyEventDefs(final List<StudyEventDef> studyEventDefs) {
        this.studyEventDefs = studyEventDefs;
    }

    public void addStudyEventDef(final StudyEventDef studyEventDef) {
		if (this.studyEventDefs == null) {
			this.studyEventDefs = new ArrayList<>();
		}
		this.studyEventDefs.add(studyEventDef);
	}

    public List<FormDef> getFormDefs() {
        return formDefs;
    }

    public void setFormDefs(final List<FormDef> formDefs) {
        this.formDefs = formDefs;
    }

    public void addFormDef(final FormDef formDef) {
		if (this.formDefs == null) {
			this.formDefs = new ArrayList<>();
		}
		this.formDefs.add(formDef);
	}

    public List<ItemGroupDef> getItemGroupDefs() {
        return itemGroupDefs;
    }

    public void setItemGroupDefs(final List<ItemGroupDef> itemGroupDefs) {
        this.itemGroupDefs = itemGroupDefs;
    }

    public void addItemGroupDef(final ItemGroupDef itemGroupDef) {
		if (this.itemGroupDefs == null) {
			this.itemGroupDefs = new ArrayList<>();
		}
		this.itemGroupDefs.add(itemGroupDef);
	}

    public List<ItemDef> getItemDefs() {
        return itemDefs;
    }

    public void setItemDefs(final List<ItemDef> itemDefs) {
        this.itemDefs = itemDefs;
    }

    public void addItemDef(final ItemDef itemDef) {
		if (this.itemDefs == null) {
			this.itemDefs = new ArrayList<>();
		}
		this.itemDefs.add(itemDef);
	}
}
