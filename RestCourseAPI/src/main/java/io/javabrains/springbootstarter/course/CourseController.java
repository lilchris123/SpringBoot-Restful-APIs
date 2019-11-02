package io.javabrains.springbootstarter.course;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.javabrains.springbootstarter.topic.Topic;

@RestController
public class CourseController {
	
	@Autowired
	private CourseService courseService;

	@GetMapping("/topics/{id}/courses")
	private List<Course> getAllCourses(@PathVariable String id) {
		return courseService.getAllCourses(id);
		}
	
	@GetMapping("/topics/{topicId}/courses/{courseId}")
	private Course getCourse(@PathVariable String courseId) {
		return courseService.getCourse(courseId);
		}
	
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("/topics/{topicId}/courses")
	private void addCourse(@PathVariable String topicId, @RequestBody Course course) {
		course.setTopic(new Topic(topicId,"",""));
		courseService.addCourse(course);
	}
	
	@PutMapping("/topics/{topicId}/courses/{id}")
	private void updateCourse(@PathVariable String topicId, @RequestBody Course course) {
		course.setTopic(new Topic(topicId,"",""));
		courseService.updateCourse(course);
	}

	@DeleteMapping("/topics/{id}/courses/{id}")
	private void deletecourse(@PathVariable String id) {
		courseService.deleteCourse(id);
	}
	
	@DeleteMapping("/topics/{topicId}/courses")
	private void deleteAllcourses() {
		courseService.deleteAllCourses();
	}

}
