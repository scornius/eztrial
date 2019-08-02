package org.nerdizin.eztrial.entities.base;

import org.joda.time.DateTime;
import org.nerdizin.eztrial.entities.User;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;


import javax.persistence.*;
import java.time.LocalTime;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseEntity {

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long id;

	@CreatedBy
	@ManyToOne
	private User createdBy;

	@CreatedDate
	private LocalTime createdDate;

	@LastModifiedBy
	@ManyToOne
	private User modifiedBy;

	@LastModifiedDate
	private LocalTime modifiedDate;

	public Long getId() {
		return id;
	}

	public void setId(final Long id) {
		this.id = id;
	}

	public User getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(final User createdBy) {
		this.createdBy = createdBy;
	}

	public LocalTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(final LocalTime createdDate) {
		this.createdDate = createdDate;
	}

	public User getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(final User modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public LocalTime getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(final LocalTime modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

}
