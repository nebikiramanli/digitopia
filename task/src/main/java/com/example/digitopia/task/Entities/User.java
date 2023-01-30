package com.example.digitopia.task.Entities;
import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import com.example.digitopia.task.Enums.UserStatusType;

import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
@Table(name="user")
//@Access(value=AccessType.FIELD)
public class User extends AbstractAuditingEntity{
	
	@Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Type(type = "uuid-char")
    @Column(name="user_id", updatable = false, nullable = false, columnDefinition = "VARCHAR(36)")
    private UUID userId;
	
	@Column(name="status")
	private String status;

	@Column(name="full_name")
	private String fullName;
	
	@Column(name="email")
	private String email;
	
	@Column(name="normalized_name")
	private String normalizedName;
	
	
	@ManyToMany(mappedBy = "users", fetch = FetchType.EAGER)
    private Set<Organization> organizations = new HashSet<>();

	public User(UUID userId, String fullName, String email, String normalizedName, String status) {
		super();
		this.userId = userId;
		this.fullName = fullName;
		this.email = email;
		this.normalizedName = normalizedName;
		this.status = status;
	}

	public UUID getId() {
		return userId;
	}

	public void setId(UUID userId) {
		this.userId = userId;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNormalizedName() {
		return normalizedName;
	}

	public void setNormalizedName(String normalizedName) {
		this.normalizedName = normalizedName;
	}
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}	

	
}
