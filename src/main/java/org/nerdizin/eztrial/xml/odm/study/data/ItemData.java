package org.nerdizin.eztrial.xml.odm.study.data;

import org.nerdizin.eztrial.xml.odm.base.OdmElement;

import javax.xml.bind.annotation.XmlAttribute;

public class ItemData implements OdmElement {

    @XmlAttribute(name = "ItemOID")
    private String itemOid;


    public String getItemOid() {
        return itemOid;
    }

    public void setItemOid(String itemOid) {
        this.itemOid = itemOid;
    }
}
