package org.nerdizin.eztrial.xml.odm.study;

import org.nerdizin.eztrial.xml.Namespaces;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;

@XmlType(namespace = Namespaces.EZTRIAL)
public class Script {

    @XmlAttribute(name = "trigger")
    private String trigger;

    @XmlValue
    private String source;


    public String getTrigger() {
        return trigger;
    }

    public void setTrigger(final String trigger) {
        this.trigger = trigger;
    }

    public String getSource() {
        return source;
    }

    public void setSource(final String source) {
        this.source = source;
    }
}
