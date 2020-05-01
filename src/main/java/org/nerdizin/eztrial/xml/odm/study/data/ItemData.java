package org.nerdizin.eztrial.xml.odm.study.data;

import org.nerdizin.eztrial.entities.enums.DataType;
import org.nerdizin.eztrial.xml.odm.base.OdmElement;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlValue;

@XmlSeeAlso({ItemDataString.class,
    ItemDataInteger.class,
    ItemDataFloat.class })
public abstract class ItemData implements OdmElement {

    @XmlAttribute(name = "ItemOID")
    private String itemOid;

    @XmlValue
    private String value;


    public String getValue() {
        return value;
    }

    public void setValue(final String value) {
        this.value = value;
    }

    public String getItemOid() {
        return itemOid;
    }

    public void setItemOid(final String itemOid) {
        this.itemOid = itemOid;
    }

    public abstract DataType getDataType();

}
