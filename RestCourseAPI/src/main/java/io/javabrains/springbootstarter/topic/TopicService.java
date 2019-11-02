package io.javabrains.springbootstarter.topic;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {
	
	@Autowired
	private TopicRepository repository;
	
	public List<Topic> getAllTopics(){
		List<Topic> topics=new ArrayList<Topic>();
		repository.findAll().forEach(t->topics.add(t));
		return topics;
	}
	
	public Topic getTopic(String id){
		return repository.findById(id).get();
	}
	
	public void addTopic(Topic entity) {
		repository.save(entity);
	}
	
	public void updateTopic(Topic updatedTopic) {
		repository.save(updatedTopic);		
	}
	
	public void deleteTopic(String id) {
		repository.deleteById(id);
	}
	
	public void deleteAllTopics(){
		repository.deleteAll();
	}
	
	
}
