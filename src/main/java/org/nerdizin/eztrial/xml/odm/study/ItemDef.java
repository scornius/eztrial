package org.nerdizin.eztrial.xml.odm.study;

import org.nerdizin.eztrial.xml.Namespaces;

import javax.xml.bind.annotation.XmlElement;

public class ItemDef extends AbstractDef {

    @XmlElement(name = "Script", namespace = Namespaces.EZTRIAL)
    private Script script;

}
