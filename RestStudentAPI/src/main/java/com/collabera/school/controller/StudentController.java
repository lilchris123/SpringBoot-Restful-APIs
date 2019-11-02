package com.collabera.school.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.collabera.school.model.Student;
import com.collabera.school.service.StudentService;

@RestController
public class StudentController {

	@Autowired
	StudentService service;
	
	@GetMapping("/api/students")
	public List<Student> getStudents(){
		return service.getAllStudents();
	}
	
	@GetMapping("/api/students/{studentid}")
	public Student getStudent(@PathVariable int studentid) {
		return service.getStudent(studentid);
	}
	
	@GetMapping("/api/students/major/{major}")
	public List<Student> getStudentsInMajor(@PathVariable String major) {
		return service.getStudentInMajor(major);
	}
	
	@PostMapping("/api/students/student")
	public ResponseEntity<String> addStudent(@RequestBody Student student){
		Student newStudent =service.addStudent(student.getFirstName(), student.getLastName(), student.getDateOfBirth(), student.getMajor());
		System.out.println(newStudent);
		
		URI location= ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(newStudent.getId()).toUri();
		
		return ResponseEntity.created(location)
				.header("student", newStudent.getId()+"").body(newStudent.getFirstName()+ " " + newStudent.getLastName());
	}
	
	@PutMapping("/api/students/student")
	public void updateStudent(@RequestBody Student student) {
		service.updateStudent(student);
	}
	
	@DeleteMapping("/api/students/{id}")
	public void deleteStudent(@PathVariable int id) {
		service.deleteStudent(id);
	}
	
	@DeleteMapping("/api/students")
	public void deleteAllStudents() {
		service.deleteAllStudents();
	}
}
