package com.Duane.springrosterI.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="contact")
public class ContactInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty(message="Address cannot be blank..")
	@Size(min=5, message="Must be 5 characters or more")
	private String address;
	
	@NotEmpty(message="City cannot be blank...")
	@Size(min=5, message="Must be 5 characters or more")
	private String city;
	
	@NotEmpty(message="State cannot be blank...")
	@Size(min=2, message="Must be 2 characters or more")
	private String state;
	
	@Column(updatable=false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date createdAt;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date updatedAt;
	
	@OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="student_id")
    private Student student;
	
//	@ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name="student_id")
//    private Student student;
	
    public ContactInfo() {}

	public ContactInfo(
			@NotEmpty(message = "Address cannot be blank..") @Size(min = 5, message = "Must be 5 characters or more") String address,
			@NotEmpty(message = "City cannot be blank...") @Size(min = 5, message = "Must be 5 characters or more") String city,
			@NotEmpty(message = "State cannot be blank...") @Size(min = 2, message = "Must be 2 characters or more") String state) {
		super();
		this.address = address;
		this.city = city;
		this.state = state;
//		this.student = student;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}
    
	@PrePersist
	public void onCreate() {
		this.createdAt = new Date();
	}
	
	@PreUpdate
	public void onUpdate() {
		this.updatedAt = new Date();
	}

	public Date getCreatedAt() {
		return createdAt;
	}


	public Date getUpdatedAt() {
		return updatedAt;
	}

	
	
    
    
};
