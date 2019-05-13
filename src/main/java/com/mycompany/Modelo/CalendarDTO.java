/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Modelo;

/**
 *
 * @author 56974
 */
public class CalendarDTO {

    int id;
    String title;
    String start;
    String end;
    String url;
    int className;
    boolean editable;

    public CalendarDTO() {
    }

    public CalendarDTO(int id, String title, String start, String end, String url, int className, boolean editable) {
        this.id = id;
        this.title = title;
        this.start = start;
        this.end = end;
        this.url = url;
        this.className = className;
        this.editable = editable;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getClassName() {
        return className;
    }

    public void setClassName(int className) {
        this.className = className;
    }

    public boolean isEditable() {
        return editable;
    }

    public void setEditable(boolean editable) {
        this.editable = editable;
    }

   
  
    
}
