package org.nerdizin.eztrial.xml.odm.study;

import org.nerdizin.eztrial.xml.adapter.YesNoBooleanAdapter;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

public class ItemGroupDef extends AbstractDef {

    @XmlAttribute(name = "Repeating")
    @XmlJavaTypeAdapter(YesNoBooleanAdapter.class)
    private Boolean repeating;


    public boolean getRepeating() {
        return repeating;
    }

    public void setRepeating(final boolean repeating) {
        this.repeating = repeating;
    }

}
