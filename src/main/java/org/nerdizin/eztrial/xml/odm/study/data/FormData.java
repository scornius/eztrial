package org.nerdizin.eztrial.xml.odm.study.data;

import org.nerdizin.eztrial.xml.odm.base.OdmElement;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import java.util.ArrayList;
import java.util.List;

public class FormData implements OdmElement {

    @XmlAttribute(name = "FormOID")
    private String formOid;

    @XmlElement(name = "ItemGroupData")
    private List<ItemGroupData> itemGroupDatas;


    public String getFormOid() {
        return formOid;
    }

    public void setFormOid(final String formOid) {
        this.formOid = formOid;
    }

    public List<ItemGroupData> getItemGroupDatas() {
        return itemGroupDatas;
    }

    public void setItemGroupDatas(final List<ItemGroupData> itemGroupDatas) {
        this.itemGroupDatas = itemGroupDatas;
    }

    public void addItemGroup(final ItemGroupData itemGroupData) {
        if (this.itemGroupDatas == null) {
            this.itemGroupDatas = new ArrayList<>();
        }
        this.itemGroupDatas.add(itemGroupData);
    }
}
