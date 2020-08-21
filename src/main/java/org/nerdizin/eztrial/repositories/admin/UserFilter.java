package org.nerdizin.eztrial.repositories.admin;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class UserFilter {

    private String userName;
    private Boolean active;


    public String getUserName() {
        return userName;
    }

    public void setUserName(final String userName) {
        this.userName = userName;
    }

    public boolean hasUserName() {
        return StringUtils.isNotEmpty(userName);
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(final Boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
