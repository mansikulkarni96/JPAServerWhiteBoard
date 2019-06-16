package com.example.wbdvsu19jannunziserverjava.controller;

import com.example.wbdvsu19jannunziserverjava.models.Course;
import com.example.wbdvsu19jannunziserverjava.models.Widget;
import com.example.wbdvsu19jannunziserverjava.services.WidgetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin("*")
public class WidgetController {

    @Autowired
    WidgetService service;

    @GetMapping("/api/widgets")
    public List<Widget> findAllWidgets() {
        return service.findAllWidgets();
    }

    @GetMapping("/api/widgets/{wid}")
    public Widget findWidgetById(
            @PathVariable("wid") Integer id) {
        return service.findWidgetById(id);
    }

    @PostMapping("/api/widgets")
    public List<Widget> createWidget(
    		 @RequestBody Widget newWidget) {
    	return service.createWidget(newWidget);
    }
    
    @DeleteMapping("/api/widgets/{wid}")
    public List<Widget> deleteWidget(
            @PathVariable("wid") Integer widgetId) {
        return service.deleteWidget(widgetId);
    }
    
    @PutMapping("/api/widgets/{wid}")
    public Widget updateWidget(
    		 @PathVariable("wid") Integer id,  @RequestBody Widget widget)
    {
    	return service.updateWidget(id,widget);
    }
}
