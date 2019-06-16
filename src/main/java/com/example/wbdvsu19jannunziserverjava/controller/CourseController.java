package com.example.wbdvsu19jannunziserverjava.controller;

import com.example.wbdvsu19jannunziserverjava.models.Course;
import com.example.wbdvsu19jannunziserverjava.models.Module;
import com.example.wbdvsu19jannunziserverjava.models.Widget;
import com.example.wbdvsu19jannunziserverjava.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*" , allowCredentials = "true" , allowedHeaders = "*")
public class CourseController {

    @Autowired
    CourseRepository repository;

    @GetMapping("/api/courses")
    public List<Course> findAllCourses() {
        return repository.findAllCourses();
    }

    @GetMapping("/api/courses/{cid}")
    public Course findCourseById(
            @PathVariable("cid") Integer id) {
        return repository.findCourseById(id);
    }
    
    @PostMapping("/api/courses")
    public Course addCourse(
            @RequestBody Course newCourse
    ) {
        return repository.save(newCourse);
    }
    
    @DeleteMapping("/api/courses/{cid}")
    public void deleteWidget(
            @PathVariable("cid") Integer courseId) {
        repository.deleteById(courseId);
    }
    
    @PutMapping("/api/courses/{cid}")
    public Course updateCourse(
    		@PathVariable("cid") Integer courseId, @RequestBody Course newCourse ) {
    	Course c = repository.findCourseById(courseId);
    	c.setId(newCourse.getId());
    	c.setTitle(newCourse.getTitle());
		return repository.save(c);
    	
    }
}
