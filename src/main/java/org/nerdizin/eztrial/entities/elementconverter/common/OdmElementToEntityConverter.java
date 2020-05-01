package org.nerdizin.eztrial.entities.elementconverter.common;

public interface OdmElementToEntityConverter<OdmElement,BaseEntity> {

	BaseEntity convertToEntity(OdmElement odmElement);

	OdmElement convertToElement(BaseEntity entity);
}
