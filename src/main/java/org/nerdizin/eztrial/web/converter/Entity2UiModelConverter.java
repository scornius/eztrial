package org.nerdizin.eztrial.web.converter;

public interface Entity2UiModelConverter<UiModel,BaseEntity> {

	BaseEntity convertToUiModel(UiModel uiModel);

	UiModel convertToEntity(BaseEntity entity);

}
