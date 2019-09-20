package org.nerdizin.eztrial.entities.base;

import org.nerdizin.eztrial.entities.admin.User;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;


import javax.persistence.*;
import java.time.LocalDateTime;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseEntity {

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long id;

	@CreatedBy
	@ManyToOne(optional = false)
	private User createdBy;

	@CreatedDate
	@Column(name = "created_on", nullable = false)
	private LocalDateTime createdDate;

	@LastModifiedBy
	@ManyToOne(optional = false)
	private User modifiedBy;

	@LastModifiedDate
	@Column(name = "modified_on", nullable = false)
	private LocalDateTime modifiedDate;


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

	public LocalDateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(final LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}

	public User getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(final User modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public LocalDateTime getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(final LocalDateTime modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

}
