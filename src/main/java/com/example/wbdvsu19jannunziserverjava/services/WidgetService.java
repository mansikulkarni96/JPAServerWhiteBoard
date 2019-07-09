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
    	if(widget.getName()!=null)
    		wid.setName(widget.getName());
    	if(widget.getSize() != 0)
    		wid.setSize(widget.getSize());
    	if(widget.getSrc() != null)
    		wid.setSrc(widget.getSrc());
    	if(widget.getText() != null)
    		wid.setText(widget.getText());
    	if(widget.getHref() != null)
    		wid.setHref(widget.getHref());
    	if(widget.getHeight() != 0)
    		wid.setHeight(widget.getHeight());
    	if(widget.getStyle() != null)
    		wid.setStyle(widget.getStyle());
    	if(widget.getUrl() != null)
    		wid.setUrl(widget.getUrl());
    	if(widget.getValue() != null)
    		wid.setValue(widget.getValue());
    	if(widget.getValueType() != null)
    		wid.setValueType(widget.getValueType());
    	if(widget.getWidth() != 0)
    		wid.setWidth(widget.getWidth());
    	if(widget.getType() != null)
    		wid.setlType(widget.getlType());
    	if(widget.getOrder() != 0)
    		wid.setOrder(widget.getOrder());
    	if(widget.getdType() != null)
    		wid.setdType(widget.getdType());   
    	if(widget.getWidType() != null)
    		wid.setWidType(widget.getWidType());
    	return repository.save(wid);
    }
}
