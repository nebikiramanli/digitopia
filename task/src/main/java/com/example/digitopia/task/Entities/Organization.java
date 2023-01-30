package com.example.digitopia.task.Entities;

import java.time.LocalDate;
import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="organization")
public class Organization extends AbstractAuditingEntity{

	@Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Type(type = "uuid-char")
    @Column(name="org_id", updatable = false, columnDefinition = "VARCHAR(36)")
    private UUID orgId;
	

	@Column(name="organization_name")
	private String organizationName;
	
	@Column(name="normalized_organization_name")
	private String normalizedOrganizationName;
	
	@Column(name="register_number")
	private String registerNumber;
	
	@Column(name="contact_mail")
	private String contactMail;
	
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	@JsonFormat(pattern = "yyyy")
	@Column(name="year_founded")
	private LocalDate yearFounded;
	
	@Column(name="phone")
	private String phone;
	
	@Column(name="company_size")
	private String companySize;
	
	/*
	@JsonIgnoreProperties(value= {"normalizedName","email", "fullName", "status"})
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinTable(name="user", joinColumns = @JoinColumn(name="user_id"),  inverseJoinColumns = @JoinColumn(name = "org_id"))
	@Column(name="user_id")
	private List<User> users;
	*/
	@JsonIgnoreProperties(value= {"normalizedName","email", "fullName", "status"})
	@ManyToMany()
    @JoinTable(name = "org_users",
            joinColumns = {@JoinColumn(name = "org_id", referencedColumnName = "org_id",
                            nullable = false, updatable = false)},
            inverseJoinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "user_id",
                            nullable = false, updatable = false)})
    private Set<User> users = new HashSet<>();

	public Organization(UUID orgId, String organizationName, String normalizedOrganizationName, String registerNumber,
			String contactMail, LocalDate yearFounded, String phone, String companySize) {
		super();
		this.orgId = orgId;
		this.organizationName = organizationName;
		this.normalizedOrganizationName = normalizedOrganizationName;
		this.registerNumber = registerNumber;
		this.contactMail = contactMail;
		this.yearFounded = yearFounded;
		this.phone = phone;
		this.companySize = companySize;

	}

	public UUID getOrgId() {
		return orgId;
	}

	public void setOrgId(UUID orgId) {
		this.orgId = orgId;
	}

	public String getOrganizationName() {
		return organizationName;
	}

	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}

	public String getNormalizedOrganizationName() {
		return normalizedOrganizationName;
	}

	public void setNormalizedOrganizationName(String normalizedOrganizationName) {
		this.normalizedOrganizationName = normalizedOrganizationName;
	}

	public String getRegisterNumber() {
		return registerNumber;
	}

	public void setRegisterNumber(String registerNumber) {
		this.registerNumber = registerNumber;
	}

	public String getContactMail() {
		return contactMail;
	}

	public void setContactMail(String contactMail) {
		this.contactMail = contactMail;
	}

	public LocalDate getYearFounded() {
		return yearFounded;
	}

	public void setYearFounded(LocalDate yearFounded) {
		this.yearFounded = yearFounded;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getCompanySize() {
		return companySize;
	}

	public void setCompanySize(String companySize) {
		this.companySize = companySize;
	}
	
}
