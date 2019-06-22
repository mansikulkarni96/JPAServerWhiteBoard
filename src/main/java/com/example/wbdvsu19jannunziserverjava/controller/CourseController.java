package com.example.wbdvsu19jannunziserverjava.controller;

import com.example.wbdvsu19jannunziserverjava.models.Course;
import com.example.wbdvsu19jannunziserverjava.models.Module;
import com.example.wbdvsu19jannunziserverjava.models.Widget;
import com.example.wbdvsu19jannunziserverjava.repositories.CourseRepository;
import com.example.wbdvsu19jannunziserverjava.services.CourseService;
import com.example.wbdvsu19jannunziserverjava.services.WidgetService;

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
    CourseService service;

    @GetMapping("/api/courses")
    public List<Course> findAllCourses() {
        return service.findAllCourses();
    }

    @GetMapping("/api/courses/{cid}")
    public Course findCourseById(
            @PathVariable("cid") Integer id) {
        return service.findCourseById(id);
    }
    
    @PostMapping("/api/courses")
    public Course addCourse(
            @RequestBody Course newCourse
    ) {
        return service.addCourse(newCourse);
    }
    
    @DeleteMapping("/api/courses/{cid}")
    public void deleteCourse(
            @PathVariable("cid") Integer courseId) {
    	service.deleteCourse(courseId);
    }
    
    @PutMapping("/api/courses/{cid}")
    public Course updateCourse(
    		@PathVariable("cid") Integer courseId, @RequestBody Course newCourse ) {
    	return service.updateCourse(courseId, newCourse);
    	
    }
}
