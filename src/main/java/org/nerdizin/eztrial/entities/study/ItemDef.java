package org.nerdizin.eztrial.entities.study;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.nerdizin.eztrial.entities.base.DefEntity;
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
	@MapKeyColumn(name = "language")
	@Column(name = "text")
	@CollectionTable(name="def_items_questions",
			joinColumns=@JoinColumn(name="id"),
			uniqueConstraints = @UniqueConstraint(columnNames={"id", "language"}))
	private Map<String,String> questions;

	@ElementCollection
	@MapKeyColumn(name = "language")
	@Column(name = "text")
	@CollectionTable(name="def_items_descriptions",
			joinColumns=@JoinColumn(name="id"),
			uniqueConstraints = @UniqueConstraint(columnNames={"id", "language"}))
	private Map<String,String> descriptions;


	public void addQuestion(final String language, final String text) {
		if (questions == null) {
			questions = new HashMap<>();
		}
		this.questions.put(language, text);
	}

	public void addDescription(final String language, final String text) {
		if (descriptions == null) {
			descriptions = new HashMap<>();
		}
		this.descriptions.put(language, text);
	}

	public DataType getDataType() {
		return dataType;
	}

	public void setDataType(final DataType dataType) {
		this.dataType = dataType;
	}

	public Map<String,String> getQuestions() {
		return questions;
	}

	public void setQuestions(final Map<String,String> questions) {
		this.questions = questions;
	}

	@Override
	public Map<String,String> getDescriptions() {
		return descriptions;
	}

	@Override
	public void setDescriptions(final Map<String,String> descriptions) {
		this.descriptions = descriptions;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
