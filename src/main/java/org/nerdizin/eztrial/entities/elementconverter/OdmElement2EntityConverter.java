package org.nerdizin.eztrial.entities.elementconverter;

public interface OdmElement2EntityConverter<OdmElement,BaseEntity> {

	BaseEntity convert2Entity(OdmElement odmElement);

}
