package com.Duane.springrosterI.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.Duane.springrosterI.models.ContactInfo;
import com.Duane.springrosterI.models.Student;
import com.Duane.springrosterI.services.StudentService;

@Controller
public class HomeController {
	
	private StudentService studentServ;

	public HomeController(StudentService studentServ) {
		super();
		this.studentServ = studentServ;
	}
	
	@GetMapping("/dashboard")
	public String Dashboard(Model model) {
		model.addAttribute("allStudents", studentServ.getAllStudents());
		model.addAttribute("allContactInfo", studentServ.getAllContactInfo());
		return "Dashboard.jsp";
	}
//	***********************************************
	@GetMapping("/students/new")
	public String newStudent(Model model) {
		model.addAttribute("aStudent", new Student()); // binds to form helper in index.jsp
		model.addAttribute("allStudents", studentServ.getAllStudents()); // displays all students 
		return "NewStudent.jsp"	;
	}
	
	@PostMapping("/student/create")
	public String createStudent(@Valid @ModelAttribute("aStudent") Student aStudent, 
			BindingResult result, Model model) {
		if(result.hasErrors()) {
			// still display notes if validation error
			model.addAttribute("allStudents", studentServ.getAllStudents());
			System.out.println(result.getAllErrors());
			return "NewStudent.jsp";
		}else {
			studentServ.create(aStudent);
		// otherwise create a note and redirect back
		}
		return "redirect:/contact/new";
	}
//	*************************************************
	@GetMapping("/contact/new")
	public String newContact(Model model) {
		model.addAttribute("newContact", new ContactInfo()); // binds to form helper in index.jsp
		model.addAttribute("allStudents", studentServ.getAllStudents()); // displays all students 
		return "ContactInfo.jsp"	;
	}
	
	@PostMapping("/contact/create")
	public String createContact(@Valid @ModelAttribute("newContact") ContactInfo newContact, 
			BindingResult result, Model model) {
		if(result.hasErrors()) {
			// still display notes if validation error
			System.out.println(result.getAllErrors());
			model.addAttribute("allContactInfo", studentServ.getAllContactInfo());
			return "ContactInfo.jsp";
		}else {
			studentServ.create(newContact);
		// otherwise create a note and redirect back
		}
		return "redirect:/dashboard";
	}
//	****************************************************
	
};
