package com.example.wbdvsu19jannunziserverjava.controller;
import com.example.wbdvsu19jannunziserverjava.models.Lesson;
import com.example.wbdvsu19jannunziserverjava.models.Topic;
import com.example.wbdvsu19jannunziserverjava.services.LessonService;
import com.example.wbdvsu19jannunziserverjava.services.TopicService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*" , allowCredentials = "true" , allowedHeaders = "*")
public class TopicController {

	 @Autowired
	 TopicService service;

    @GetMapping("/api/topics")
    public List<Topic> findAllTopics() {
        return service.findAllTopics();
    }

    @GetMapping("/api/lessons/{lid}/topics")
    public List<Topic> findAllTopicsForLesson(
            @PathVariable("lid") Integer lessonId) {
        return service.findAllTopicsForLesson(lessonId);
    }

    @PostMapping("/api/lessons/{lid}/topics")
    public List<Topic> addTopicToLesson(
            @PathVariable("lid") Integer lessonId,
            @RequestBody Topic newTopic) {
        return service.addTopicToLesson(lessonId, newTopic);
    }

    @GetMapping("/api/topics/{tid}")
    public Topic findTopicById(@PathVariable("tid") Integer id) {
        return service.findTopicById(id);
    }
    
    @PutMapping("/api/topics/{tid}")
	public Topic updateTopic(@PathVariable("tid") int tid, @RequestBody Topic topic) {
		return service.updateTopic(tid, topic);
	}
	
	@DeleteMapping("/api/topics/{tid}")
	public void deleteTopic(@PathVariable("tid") int tid) {
		service.deleteTopic(tid);
	}
}
