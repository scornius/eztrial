package org.nerdizin.eztrial.entities.study.def;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.nerdizin.eztrial.entities.base.RepeatingDefEntity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Entity
@Table(name = "def_forms")
public class FormDef extends RepeatingDefEntity {

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "formDef")
	private List<ItemGroupRef> itemGroupRefs;

	@ElementCollection
	@MapKeyColumn(name = "language")
	@Column(name = "text")
	@CollectionTable(name="def_forms_descriptions",
			joinColumns=@JoinColumn(name="id"),
			uniqueConstraints = @UniqueConstraint(columnNames={"id", "language"}))
	private Map<String,String> descriptions;


	public void addItemGroupRef(final ItemGroupRef itemGroupRef) {
		if (this.itemGroupRefs == null) {
			this.itemGroupRefs = new ArrayList<>();
		}
		this.itemGroupRefs.add(itemGroupRef);
	}

	public void addDescription(final String language, final String text) {
		if (descriptions == null) {
			descriptions = new HashMap<>();
		}
		this.descriptions.put(language, text);
	}

	public List<ItemGroupRef> getItemGroupRefs() {
		return itemGroupRefs;
	}

	public void setItemGroupRefs(final List<ItemGroupRef> itemGroupRefs) {
		this.itemGroupRefs = itemGroupRefs;
	}

	public Map<String,String> getDescriptions() {
		return descriptions;
	}

	public void setDescriptions(final Map<String,String> descriptions) {
		this.descriptions = descriptions;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
