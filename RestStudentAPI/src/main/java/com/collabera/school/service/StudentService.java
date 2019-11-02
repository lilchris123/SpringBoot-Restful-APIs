package com.collabera.school.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;

import com.collabera.school.model.Student;

@Service
public class StudentService {
	private static List<Student> students= new ArrayList<Student>();
	private static int idCounter=1;
	
	static {
		students.add(new Student(idCounter++, "Jack", "Johnson", LocalDate.of(1998, 5, 22), "Computer Science"));
		students.add(new Student(idCounter++, "Marshall", "Matthews", LocalDate.of(1995, 7, 13), "Potions"));
		students.add(new Student(idCounter++, "Mattew", "Truelove", LocalDate.of(1950, 12, 12), "Computer Science"));
		students.add(new Student(idCounter++, "Lee", "Angioletti", LocalDate.of(1997, 1, 13), "Ping Pong"));
		students.add(new Student(idCounter++, "Daniel", "España", LocalDate.of(1969, 4, 20), "Spanish"));
	}
	
	//Create
	public Student addStudent(String firstName, String lastName, LocalDate dob, String major) {
		Student student =new Student(idCounter++, firstName,lastName, dob, major);
		students.add(student);
		return student;
	}
	
	//Read
	public List<Student> getAllStudents(){
		return students;
	}
	
	public Student getStudent(int id) {
		Student student= null;
		
		for(Student s: students) {
			if(s.getId()==id) {
				student=s;
				break;
			}
		}
		return student;
	}
	
	public List<Student> getStudentInMajor(String major) {
		List<Student> studentMajor= new ArrayList<Student>(); 
			
		for(Student s: students) {
			if(s.getMajor().equalsIgnoreCase(major)) {
				studentMajor.add(s);
				break;
			}
		}
		return studentMajor;
	}
	
	//Update
	public void updateStudent(Student student) {
		Student studentToUpdate = getStudent(student.getId());
		
		studentToUpdate.setFirstName(student.getFirstName());
		studentToUpdate.setLastName(student.getLastName());
		studentToUpdate.setDateOfBirth(student.getDateOfBirth());
		studentToUpdate.setMajor(student.getMajor());
	}
	
	//Delete
	public void deleteStudent(int id) {
		
		Iterator<Student> it= students.iterator();
		while(it.hasNext()) {
			if(it.next().getId()==id) {
				it.remove();
				break;
			}
		}
		
	}
	//Delete all
	public void deleteAllStudents() {
		students.clear();
	}
}
