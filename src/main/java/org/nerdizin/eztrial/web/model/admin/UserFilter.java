package org.nerdizin.eztrial.web.model.admin;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;

public class UserFilter implements Serializable {

    private String userName;
    private Boolean active;

    public String getUserName() {
        return userName;
    }

    public void setUserName(final String userName) {
        this.userName = userName;
    }

    public Boolean isActive() {
        return active;
    }

    public void setActive(final Boolean active) {
        this.active = active;
    }

    public boolean hasActive() {
        return active != null;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
