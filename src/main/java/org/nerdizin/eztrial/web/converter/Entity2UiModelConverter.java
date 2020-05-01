package org.nerdizin.eztrial.web.converter;

public interface Entity2UiModelConverter<BaseEntity,UiModel> {

	UiModel convertToUiModel(BaseEntity entity);

	BaseEntity convertToEntity(UiModel uiModel);
}
