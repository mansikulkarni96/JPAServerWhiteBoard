package com.example.wbdvsu19jannunziserverjava.models;

import javax.persistence.*;

@Entity
@Table(name="widgets")
public class Widget {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
  
	public enum type 
    { 
 		HEADING, LIST, PARAGRAPH, IMAGE, YOUTUBE, HTML, LINK;
    }
 	
 	private enum dataType{
 		INTEGER,STRING,DATE,BOOLEAN
 	}

 	private enum listType{
 		ol,ul
 	}
 	
 	private String name;
    private String text;
    @Enumerated(EnumType.STRING)
    @Column(length = 10)
    private type widType; 
    private int size;
    private int ord;
    private String url;
    private String href;
    private int width;
    private int height;
    private String cssClass;
    private String style;
    private String value;
    @Enumerated(EnumType.STRING)
    @Column(length = 10)
    private listType lType;
    
    @Enumerated(EnumType.STRING)
    @Column(length = 10)
    private dataType dType;
    
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
		return dType;
	}

	public void setValueType(dataType valueType) {
		this.dType = valueType;
	}

	private String src;

    public Widget(Integer id, String name, type t) {
        this.id = id;
        this.name = name;
        this.widType = t;
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
        return widType;
    }

    public void setType(type t) {
        this.widType = t;
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

	public int getOrder() {
		return ord;
	}

	public void setOrder(int ord) {
		this.ord = ord;
	}
	 public listType getlType() {
			return lType;
		}

		public void setlType(listType lType) {
			this.lType = lType;
		}

		public type getWidType() {
			return widType;
		}

		public void setWidType(type widType) {
			this.widType = widType;
		}

		public dataType getdType() {
			return dType;
		}

		public void setdType(dataType dType) {
			this.dType = dType;
		}
}
