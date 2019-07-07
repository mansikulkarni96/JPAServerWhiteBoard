package com.example.wbdvsu19jannunziserverjava.services;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.wbdvsu19jannunziserverjava.models.Course;
import com.example.wbdvsu19jannunziserverjava.models.Lesson;
import com.example.wbdvsu19jannunziserverjava.models.Module;
import com.example.wbdvsu19jannunziserverjava.models.Topic;
import com.example.wbdvsu19jannunziserverjava.repositories.CourseRepository;
import com.example.wbdvsu19jannunziserverjava.repositories.LessonRepository;
import com.example.wbdvsu19jannunziserverjava.repositories.ModuleRepository;
import com.example.wbdvsu19jannunziserverjava.repositories.TopicRepository;

@RestController
@CrossOrigin(origins = "*" , allowCredentials = "true" , allowedHeaders = "*")
@Service
public class TopicService {
	 @Autowired
	    TopicRepository repository;
	 @Autowired
	    LessonRepository lessonRepository;
	 
	    public List<Topic> findAllTopics() {
	        return repository.findAllTopics();
	    }

	    public List<Topic> findAllTopicsForLesson(
	            @PathVariable("lid") Integer lessonId) {
	        return repository.findAllTopicsForLesson(lessonId);
	    }

	    public List<Topic> addTopicToLesson(
	            @PathVariable("lid") Integer lessonId,
	            @RequestBody Topic newTopic) {
	        Lesson lesson = lessonRepository.findLessonById(lessonId);
	        newTopic.setLesson(lesson);
	        repository.save(newTopic);
	        return repository.findAllTopicsForLesson(lessonId);
	    }

	    public Topic findTopicById(@PathVariable("tid") Integer id) {
	        return repository.findTopicById(id);
	    }
	    
		public Topic updateTopic(@PathVariable("tid") int tid, @RequestBody Topic topic) {
			Topic t =  findTopicById(tid);
			t.setId(topic.getId());
			t.setTitle(topic.getTitle());
			return repository.save(t);
		}
		
		public void deleteTopic(@PathVariable("tid") int tid) {
			repository.deleteById(tid);
		}

}

