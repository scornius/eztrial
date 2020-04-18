package org.nerdizin.eztrial.entities.study.data;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.nerdizin.eztrial.entities.base.OidEntity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "data_forms")
public class FormData extends OidEntity {

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "event_id")
    private StudyEventData event;

    @OneToMany(mappedBy = "form", orphanRemoval = true, cascade = CascadeType.MERGE)
    private List<ItemGroupData> itemGroups;


    public StudyEventData getEvent() {
        return event;
    }

    public void setEvent(final StudyEventData event) {
        this.event = event;
    }

    public List<ItemGroupData> getItemGroups() {
        return itemGroups;
    }

    public void setItemGroups(final List<ItemGroupData> itemGroups) {
        this.itemGroups = itemGroups;
    }

    public void addItemGroup(final ItemGroupData itemGroup) {
        if (this.itemGroups == null) {
            this.itemGroups = new ArrayList<>();
        }
        this.itemGroups.add(itemGroup);
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
