package org.nerdizin.eztrial.xml.odm.study.data;

import org.nerdizin.eztrial.xml.odm.base.OdmElement;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

public class ItemGroupData implements OdmElement {

    @XmlAttribute(name = "ItemGroupOID")
    private String itemGroupOid;

    @XmlElements({
            @XmlElement(name = "ItemDataString", type = ItemDataString.class),
            @XmlElement(name = "ItemDataInteger", type = ItemDataInteger.class),
            @XmlElement(name = "ItemDataFloat", type = ItemDataFloat.class)
    })
    private List<ItemData> itemDatas;


    public String getItemGroupOid() {
        return itemGroupOid;
    }

    public void setItemGroupOid(final String itemGroupOid) {
        this.itemGroupOid = itemGroupOid;
    }

    public List<ItemData> getItemDatas() {
        return itemDatas;
    }

    public void setItemDatas(final List<ItemData> itemDatas) {
        this.itemDatas = itemDatas;
    }

    public void addItemData(final ItemData itemData) {
        if (this.itemDatas == null) {
            this.itemDatas = new ArrayList<>();
        }
        this.itemDatas.add(itemData);
    }
}
