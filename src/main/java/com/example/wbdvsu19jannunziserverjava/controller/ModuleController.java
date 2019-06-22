package com.example.wbdvsu19jannunziserverjava.controller;

import com.example.wbdvsu19jannunziserverjava.models.Course;
import com.example.wbdvsu19jannunziserverjava.models.Module;
import com.example.wbdvsu19jannunziserverjava.repositories.CourseRepository;
import com.example.wbdvsu19jannunziserverjava.repositories.ModuleRepository;
import com.example.wbdvsu19jannunziserverjava.services.ModuleService;
import com.example.wbdvsu19jannunziserverjava.services.WidgetService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*" , allowCredentials = "true" , allowedHeaders = "*")
public class ModuleController {

	 @Autowired
	 ModuleService service;

    @GetMapping("/api/modules")
    public List<Module> findAllModules() {
        return service.findAllModules();
    }

    @GetMapping("/api/courses/{cid}/modules")
    public List<Module> findAllModulesForCourse(
            @PathVariable("cid") Integer courseId) {
        return service.findAllModulesForCourse(courseId);
    }

    @PostMapping("/api/courses/{cid}/modules")
    public List<Module> addModuleToCourse(
            @PathVariable("cid") Integer courseId,
            @RequestBody Module newModule) {
        return service.addModuleToCourse(courseId, newModule);
    }

    @GetMapping("/api/modules/{mid}")
    public Module findModuleById(@PathVariable("mid") Integer id) {
        return service.findModuleById(id);
    }
    
    @PutMapping("/api/modules/{mid}")
	public Module updateModule(@PathVariable("mid") int mid, @RequestBody Module module) {
		return service.updateModule(mid, module);
	}
	
	@DeleteMapping("/api/modules/{mid}")
	public void deleteModule(@PathVariable("mid") int mid) {
		service.deleteModule(mid);
	}
}
