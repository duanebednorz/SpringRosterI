package com.Duane.springrosterI.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.Duane.springrosterI.models.ContactInfo;
import com.Duane.springrosterI.models.Student;
import com.Duane.springrosterI.repositories.ContactRepository;
import com.Duane.springrosterI.repositories.StudentRepository;

@Service
public class StudentService {
	private StudentRepository studentRepo;
	private ContactRepository contactRepo;
	
	public StudentService(StudentRepository studentRepo, ContactRepository contactRepo) {
		super();
		this.studentRepo = studentRepo;
		this.contactRepo = contactRepo;
	}
	
	public Student create(Student aStudent) {
		return studentRepo.save(aStudent);
	}
	
	public ContactInfo create(ContactInfo newContact) {
		return contactRepo.save(newContact);
	}
	
	public List<Student> getAllStudents() {
		return (List<Student>) studentRepo.findAll();
	}
	
	public List<ContactInfo> getAllContactInfo() {
		return (List<ContactInfo>) contactRepo.findAll();
	}
	
	
};
