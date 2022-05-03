package com.optrident.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.optrident.Student;
import com.optrident.dao.StudentRepo;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class StudentController {

	private static final Logger log = LoggerFactory.getLogger(StudentController.class);

	@Autowired
	StudentRepo repo;

	@GetMapping("/getStudents")
	public List<Student> getStudents() {
		log.info("Get Students Request Raised.");
		List<Student> students = null;
		try {
			students = repo.findAll();
			log.info("Get Students Request Completed.");
		} catch (Exception e) {
			log.error("Get Students Request Failed." + e.getMessage());
			e.printStackTrace();
		}
		return students;
	}

	@GetMapping("/getStudent/{id}")
	public Optional<Student> getStudent(@PathVariable(value = "id") String id) {
		log.info("Get Student Request Raised for Student Id : " + id);
		Optional<Student> student = null;
		try {
			student = repo.findById(id);
			log.info("Get Student Request Raised for Student Id : " + id + " is Completed.");
		} catch (Exception e) {
			log.info("Get Student Request Raised for Student Id : " + id + " has Failed." + e.getMessage());
			e.printStackTrace();
		}
		return student;
	}

	@PostMapping("/addStudents")
	public Student addStudent(@RequestBody Student student) {
		log.info("Add Student Request Raised for Student Id : " + student.getStudent_id() + " Name - " +
				student.getName());
		try {
			student.getSubject().setRoll_no(student.getRoll_no());
			student.getSubject().setStudent_id(student.getStudent_id());
			repo.save(student);
			log.info("Add Student Request Raised for Student Id : " + student.getStudent_id() + " is Completed.");
		} catch (Exception e) {
			log.info("Add Student Request Raised for Student Id : " + student.getStudent_id() + " has Failed." +
					e.getMessage());
			e.printStackTrace();
		}
		return student;
	}

	@DeleteMapping("/deleteStudent/{id}")
	public String deleteStudent(@PathVariable(value = "id") String id) {
		log.info("Delete Student Request Raised for Student Id : " + id);
		try {
			repo.deleteById(id);
			log.info("Delete Student Request Raised for Student Id : " + id + " is Completed.");
		} catch (Exception e) {
			log.info("Delete Student Request Raised for Student Id : " + id + " has Failed." + e.getMessage());
			e.printStackTrace();
		}
		return id;
	}

}
