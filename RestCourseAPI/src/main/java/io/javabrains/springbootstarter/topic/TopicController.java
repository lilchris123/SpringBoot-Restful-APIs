package io.javabrains.springbootstarter.topic;

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

@RestController
public class TopicController {
	@Autowired
	private TopicService service;

	@GetMapping("/topics")
	private List<Topic> getAllTopics() {
		return service.getAllTopics();
		}
	
	@GetMapping("/topics/{id}")
	private Topic getTopic(@PathVariable String id) {
		return service.getTopic(id);
		}
	
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("/topics")
	private void addTopic(@RequestBody Topic topic) {
		service.addTopic(topic);
	}
	
	@PutMapping("/topics/{id}")
	private void updateTopic(@RequestBody Topic topic) {
		service.updateTopic(topic);
	}

	@DeleteMapping("/topics/{id}")
	private void deleteTopic(@PathVariable String id) {
		service.deleteTopic(id);
	}
	
	@DeleteMapping("/topics/")
	private void deleteAllTopics() {
		service.deleteAllTopics();
	}

}
