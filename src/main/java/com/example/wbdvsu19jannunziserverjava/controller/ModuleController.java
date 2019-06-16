package com.example.wbdvsu19jannunziserverjava.controller;

import com.example.wbdvsu19jannunziserverjava.models.Course;
import com.example.wbdvsu19jannunziserverjava.models.Module;
import com.example.wbdvsu19jannunziserverjava.repositories.CourseRepository;
import com.example.wbdvsu19jannunziserverjava.repositories.ModuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*" , allowCredentials = "true" , allowedHeaders = "*")
public class ModuleController {

    @Autowired
    ModuleRepository repository;

    @Autowired
    CourseRepository courseRepository;

    @GetMapping("/api/modules")
    public List<Module> findAllModules() {
        return repository.findAllModules();
    }

    @GetMapping("/api/courses/{cid}/modules")
    public List<Module> findAllModulesForCourse(
            @PathVariable("cid") Integer courseId) {
        return repository.findAllModulesForCourse(courseId);
    }

    @PostMapping("/api/courses/{cid}/modules")
    public List<Module> addModuleToCourse(
            @PathVariable("cid") Integer courseId,
            @RequestBody Module newModule) {
        Course course = courseRepository.findCourseById(courseId);
        newModule.setCourse(course);
        repository.save(newModule);
        return repository.findAllModulesForCourse(courseId);
    }

    @GetMapping("/api/modules/{mid}")
    public Module findModuleById(@PathVariable("mid") Integer id) {
        return repository.findModuleById(id);
    }
    
    @PutMapping("/api/modules/{mid}")
	public Module updateCourse(@PathVariable("mid") int mid, @RequestBody Module module) {
		Module m =  findModuleById(mid);
		m.setId(module.getId());
		m.setTitle(module.getTitle());
		return repository.save(m);
	}
	
	@DeleteMapping("/api/modules/{mid}")
	public void deleteCourse(@PathVariable("mid") int mid) {
		repository.deleteById(mid);
	}
}
