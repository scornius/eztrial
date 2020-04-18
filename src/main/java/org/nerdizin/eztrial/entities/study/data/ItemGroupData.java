package org.nerdizin.eztrial.entities.study.data;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.nerdizin.eztrial.entities.base.OidEntity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "data_item_groups")
public class ItemGroupData extends OidEntity {

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "form_id")
    private FormData form;

    @OneToMany(mappedBy = "itemGroup", orphanRemoval = true, cascade = CascadeType.MERGE)
    private List<ItemData> items;


    public FormData getForm() {
        return form;
    }

    public void setForm(final FormData form) {
        this.form = form;
    }

    public List<ItemData> getItems() {
        return items;
    }

    public void setItems(final List<ItemData> items) {
        this.items = items;
    }

    public void addItem(final ItemData item) {
        if (this.items == null) {
            this.items = new ArrayList<>();
        }
        this.items.add(item);
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
