package com.example.wbdvsu19jannunziserverjava.services;

import com.example.wbdvsu19jannunziserverjava.models.Widget;
import com.example.wbdvsu19jannunziserverjava.repositories.WidgetRepository;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@CrossOrigin(origins = "*" , allowCredentials = "true" , allowedHeaders = "*")
@Service
public class WidgetService {

    @Autowired
    WidgetRepository repository;

    public List<Widget> findAllWidgets() {
        return repository.findAllWidgets();
    }

    public Widget findWidgetById(Integer id) {
        return repository.findWidgetById(id);
    }

    public List<Widget> createWidget(Widget widget){
    	repository.save(widget);
    	return repository.findAllWidgets();
    }
    
    public List<Widget> deleteWidget(Integer id) {
        repository.deleteById(id);
        return repository.findAllWidgets();
    }
    
    public Widget updateWidget(Integer id, Widget widget) {
    	Widget wid =repository.findWidgetById(id); 
    	wid.setName(widget.getName());
    	wid.setSize(widget.getSize());
    	wid.setSrc(widget.getSrc());
    	wid.setText(widget.getText());
    	wid.setType(widget.getType());
    	return repository.save(wid);
    }
}
