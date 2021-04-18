package com.Duane.springrosterI.models;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "students")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotEmpty(message = "First name cannot be blank")
	@Size(min = 3, message = "Must be 3 characters or more")
	private String first_name;

	@NotEmpty(message = "Last name cannot be blank...")
	@Size(min = 3, message = "Must be 3 characters or more")
	private String last_name;

	@NotNull
	@Min(18)
	@Max(100)
	private Integer age;

	@Column(updatable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date createdAt;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date updatedAt;

	@OneToOne(mappedBy = "student", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private ContactInfo student;

//	@OneToMany(mappedBy ="student", fetch = FetchType.LAZY)
//	private List<Student> student;

	public Student() {
	}

	public Student(
			@NotEmpty(message = "First name cannot be blank") @Size(min = 3, message = "Must be 3 characters or more") String first_name,
			@NotEmpty(message = "Last name cannot be blank...") @Size(min = 3, message = "Must be 3 characters or more") String last_name,
			@NotNull @Min(18) @Max(100) Integer age) {
		super();
		this.first_name = first_name;
		this.last_name = last_name;
		this.age = age;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public ContactInfo getStudent() {
		return student;
	}

	public void setStudent(ContactInfo student) {
		this.student = student;
	}

	@PrePersist
	public void onCreate() {
		this.createdAt = new Date();
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	@PreUpdate
	public void onUpdate() {
		this.updatedAt = new Date();
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

};
