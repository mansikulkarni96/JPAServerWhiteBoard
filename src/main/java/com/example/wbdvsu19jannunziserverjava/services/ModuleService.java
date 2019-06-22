package com.example.wbdvsu19jannunziserverjava.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.wbdvsu19jannunziserverjava.models.Course;
import com.example.wbdvsu19jannunziserverjava.models.Module;
import com.example.wbdvsu19jannunziserverjava.repositories.CourseRepository;
import com.example.wbdvsu19jannunziserverjava.repositories.ModuleRepository;

@RestController
@CrossOrigin(origins = "*" , allowCredentials = "true" , allowedHeaders = "*")
@Service
public class ModuleService {
	 @Autowired
	    ModuleRepository repository;
	 @Autowired
	    CourseRepository courseRepository;
	 
	    public List<Module> findAllModules() {
	        return repository.findAllModules();
	    }

	    public List<Module> findAllModulesForCourse(
	            @PathVariable("cid") Integer courseId) {
	        return repository.findAllModulesForCourse(courseId);
	    }

	    public List<Module> addModuleToCourse(
	            @PathVariable("cid") Integer courseId,
	            @RequestBody Module newModule) {
	        Course course = courseRepository.findCourseById(courseId);
	        newModule.setCourse(course);
	        repository.save(newModule);
	        return repository.findAllModulesForCourse(courseId);
	    }

	    public Module findModuleById(@PathVariable("mid") Integer id) {
	        return repository.findModuleById(id);
	    }
	    
		public Module updateModule(@PathVariable("mid") int mid, @RequestBody Module module) {
			Module m =  findModuleById(mid);
			m.setId(module.getId());
			m.setTitle(module.getTitle());
			return repository.save(m);
		}
		
		public void deleteModule(@PathVariable("mid") int mid) {
			repository.deleteById(mid);
		}

}
