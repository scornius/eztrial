@XmlSchema(
        namespace = Namespaces.ODM,
        xmlns = {
                @javax.xml.bind.annotation.XmlNs(prefix = "", namespaceURI = Namespaces.ODM),
                @javax.xml.bind.annotation.XmlNs(prefix = "ez", namespaceURI = Namespaces.EZTRIAL)
        },
        elementFormDefault = XmlNsForm.QUALIFIED)
@XmlAccessorType(XmlAccessType.FIELD)
package org.nerdizin.eztrial.xml.odm;

import org.nerdizin.eztrial.xml.Namespaces;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlNsForm;
import javax.xml.bind.annotation.XmlSchema;