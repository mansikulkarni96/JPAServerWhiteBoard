package com.example.wbdvsu19jannunziserverjava.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.wbdvsu19jannunziserverjava.models.Course;
import com.example.wbdvsu19jannunziserverjava.repositories.CourseRepository;

@RestController
@CrossOrigin(origins = "*" , allowCredentials = "true" , allowedHeaders = "*")
@Service
public class CourseService {
	 @Autowired
	    CourseRepository repository;
	    public List<Course> findAllCourses() {
	        return repository.findAllCourses();
	    }

	    public Course findCourseById(
	            @PathVariable("cid") Integer id) {
	        return repository.findCourseById(id);
	    }
	    
	    public Course addCourse(
	            @RequestBody Course newCourse
	    ) {
	        return repository.save(newCourse);
	    }
	    
	    public void deleteCourse(
	            @PathVariable("cid") Integer courseId) {
	    	repository.deleteById(courseId);
	    }
	    
	    public Course updateCourse(
    		@PathVariable("cid") Integer courseId, @RequestBody Course newCourse ) {
		Course c = repository.findCourseById(courseId);
		c.setId(newCourse.getId());
		c.setTitle(newCourse.getTitle());
		return repository.save(c);
    }
	
}
