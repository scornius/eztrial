package org.nerdizin.eztrial.entities.study;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.nerdizin.eztrial.entities.base.DefEntity;
import org.nerdizin.eztrial.entities.base.OidNameEntity;
import org.nerdizin.eztrial.entities.enums.DataType;
import org.nerdizin.eztrial.entities.enums.DataTypeConverter;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;

@Entity
@Table(name = "def_items")
public class ItemDef extends DefEntity {

	@Column(name = "datatype")
	@Convert(converter = DataTypeConverter.class)
	private DataType dataType;

	@ElementCollection
	@MapKeyColumn(name = "language", unique = true)
	@Column(name = "text")
	@CollectionTable(name="def_item_translations", joinColumns=@JoinColumn(name="id"))
	private Map<String,String> translations;


	public DataType getDataType() {
		return dataType;
	}

	public void setDataType(final DataType dataType) {
		this.dataType = dataType;
	}

	public Map<String,String> getTranslations() {
		return translations;
	}

	public void setTranslations(final Map<String,String> translations) {
		this.translations = translations;
	}

	public void addTranslation(final String language, final String text) {
		if (translations == null) {
			translations = new HashMap<>();
		}
		this.translations.put(language, text);
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
