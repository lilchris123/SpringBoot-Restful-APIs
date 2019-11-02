package io.javabrains.springbootstarter.course;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CourseService {
	
	@Autowired
	private CourseRepository repository;
	
	public List<Course> getAllCourses(String topicId){
		List<Course> courses=new ArrayList<Course>();
		repository.findByTopicId(topicId).forEach(courses::add);
		return courses;
	}
	
	public Course getCourse(String id){
		return repository.findById(id).get();
	}
	
	public void addCourse(Course entity) {
		repository.save(entity);
	}
	
	public void updateCourse(Course updatedCourse) {
		repository.save(updatedCourse);		
	}
	
	public void deleteCourse(String id) {
		repository.deleteById(id);
	}
	
	public void deleteAllCourses(){
		repository.deleteAll();
	}
	
	
}
