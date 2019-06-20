package com.example.wbdvsu19jannunziserverjava.models;

import javax.persistence.*;

@Entity
@Table(name="widgets")
public class Widget {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
 	private String name;
    private String text;
    private type type; 
    private int size;
    private String url;
    private String href;
    private int width;
    private int height;
    private String cssClass;
    private String style;
    private String value;
    private dataType dataType;
    
    public static enum type 
    { 
 		HEADING, LIST, PARAGRAPH, IMAGE, YOUTUBE, HTML, LINK;
    }
 	
 	private enum dataType{
 		INTEGER,STRING,DATE,BOOLEAN
 	}

	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public String getCssClass() {
		return cssClass;
	}

	public void setCssClass(String cssClass) {
		this.cssClass = cssClass;
	}

	public String getStyle() {
		return style;
	}

	public void setStyle(String style) {
		this.style = style;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public dataType getValueType() {
		return dataType;
	}

	public void setValueType(dataType valueType) {
		this.dataType = valueType;
	}

	private String src;

    public Widget(Integer id, String name, type t) {
        this.id = id;
        this.name = name;
        this.type = t;
    }

    public Widget() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

  
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public type getType() {
        return type;
    }

    public void setType(type t) {
        this.type = t;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }
}
