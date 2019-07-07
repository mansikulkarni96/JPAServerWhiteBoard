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
import com.example.wbdvsu19jannunziserverjava.repositories.CourseRepository;
import com.example.wbdvsu19jannunziserverjava.repositories.LessonRepository;
import com.example.wbdvsu19jannunziserverjava.repositories.ModuleRepository;

@RestController
@CrossOrigin(origins = "*" , allowCredentials = "true" , allowedHeaders = "*")
@Service
public class LessonService {
	 @Autowired
	    LessonRepository repository;
	 @Autowired
	    ModuleRepository moduleRepository;
	 
	    public List<Lesson> findAllLessons() {
	        return repository.findAllLessons();
	    }

	    public List<Lesson> findAllLessonsForModule(
	            @PathVariable("mid") Integer moduleId) {
	        return repository.findAllLessonsForModule(moduleId);
	    }

	    public List<Lesson> addLessonToModule(
	            @PathVariable("mid") Integer moduleId,
	            @RequestBody Lesson newLesson) {
	        Module module = moduleRepository.findModuleById(moduleId);
	        newLesson.setModule(module);
	        repository.save(newLesson);
	        return repository.findAllLessonsForModule(moduleId);
	    }

	    public Lesson findLessonById(@PathVariable("lid") Integer id) {
	        return repository.findLessonById(id);
	    }
	    
		public Lesson updateLesson(@PathVariable("lid") int lid, @RequestBody Lesson lesson) {
			Lesson l =  findLessonById(lid);
			l.setId(lesson.getId());
			l.setTitle(lesson.getTitle());
			return repository.save(l);
		}
		
		public void deleteLesson(@PathVariable("lid") int lid) {
			repository.deleteById(lid);
		}

}

