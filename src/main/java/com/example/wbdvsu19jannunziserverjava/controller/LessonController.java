package com.example.wbdvsu19jannunziserverjava.controller;
import com.example.wbdvsu19jannunziserverjava.models.Lesson;
import com.example.wbdvsu19jannunziserverjava.services.LessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*" , allowCredentials = "true" , allowedHeaders = "*")
public class LessonController {

	 @Autowired
	 LessonService service;

    @GetMapping("/api/lessons")
    public List<Lesson> findAllLessons() {
        return service.findAllLessons();
    }

    @GetMapping("/api/modules/{mid}/lessons")
    public List<Lesson> findAllLessonsForModule(
            @PathVariable("mid") Integer moduleId) {
        return service.findAllLessonsForModule(moduleId);
    }

    @PostMapping("/api/modules/{mid}/lessons")
    public List<Lesson> addLessonToModule(
            @PathVariable("mid") Integer moduleId,
            @RequestBody Lesson newLesson) {
        return service.addLessonToModule(moduleId, newLesson);
    }

    @GetMapping("/api/lessons/{lid}")
    public Lesson findLessonById(@PathVariable("lid") Integer id) {
        return service.findLessonById(id);
    }
    
    @PutMapping("/api/lessons/{lid}")
	public Lesson updateLesson(@PathVariable("lid") int lid, @RequestBody Lesson lesson) {
		return service.updateLesson(lid, lesson);
	}
	
	@DeleteMapping("/api/lessons/{lid}")
	public void deleteLesson(@PathVariable("lid") int lid) {
		service.deleteLesson(lid);
	}
}
