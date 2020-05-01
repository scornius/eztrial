package org.nerdizin.eztrial.entities.admin;

import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "admin_pw_reset")
public class PasswordReset {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private User user;

    @Column
    private String accessToken;

    @Column(name = "created_on", nullable = false)
    private LocalDateTime createdDate;

    @Column(name = "used_on")
    private LocalDateTime usedDate;


    public Long getId() {
        return id;
    }

    public PasswordReset setId(final Long id) {
        this.id = id;
        return this;
    }

    public User getUser() {
        return user;
    }

    public PasswordReset setUser(final User user) {
        this.user = user;
        return this;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public PasswordReset setAccessToken(final String accessToken) {
        this.accessToken = accessToken;
        return this;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public PasswordReset setCreatedDate(final LocalDateTime createdDate) {
        this.createdDate = createdDate;
        return this;
    }

    public LocalDateTime getUsedDate() {
        return usedDate;
    }

    public PasswordReset setUsedDate(final LocalDateTime usedDate) {
        this.usedDate = usedDate;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
