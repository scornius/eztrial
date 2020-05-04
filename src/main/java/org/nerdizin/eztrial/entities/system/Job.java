package org.nerdizin.eztrial.entities.system;

import org.nerdizin.eztrial.entities.base.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "sys_jobs")
public class Job extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "parent_id")
    private Job parent;


    public Job getParent() {
        return parent;
    }

    public void setParent(final Job parent) {
        this.parent = parent;
    }
}
