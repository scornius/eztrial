package org.nerdizin.eztrial.web.model.admin;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class PasswordReset {

    private String userNameOrEmail;

    public String getUserNameOrEmail() {
        return userNameOrEmail;
    }

    public PasswordReset setUserNameOrEmail(String userNameOrEmail) {
        this.userNameOrEmail = userNameOrEmail;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
