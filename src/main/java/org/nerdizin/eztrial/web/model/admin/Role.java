package org.nerdizin.eztrial.web.model.admin;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.nerdizin.eztrial.web.model.UiModel;

import java.util.Objects;

public class Role implements UiModel {

    private String oid;
    private String name;
    private String description;

    public String getOid() {
        return oid;
    }

    public Role setOid(final String oid) {
        this.oid = oid;
        return this;
    }

    public String getName() {
        return name;
    }

    public Role setName(final String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Role setDescription(final String description) {
        this.description = description;
        return this;
    }

    @Override
    public boolean equals(final Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        return Objects.equals(oid, ((Role) other).oid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(oid);
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
