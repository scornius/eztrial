package org.nerdizin.eztrial.web.rest.converter;

public interface Entity2UiModelConverter<UiModel,BaseEntity> {

	BaseEntity convertToUiModel(UiModel uiModel);

	UiModel convertToEntity(BaseEntity entity);

}
