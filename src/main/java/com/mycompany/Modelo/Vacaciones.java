/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Modelo;

import java.util.Date;
import org.eclipse.persistence.jpa.jpql.parser.DateTime;

/**
 *
 * @author 56974
 */
public class Vacaciones {

    int vacaciones_id;
    String vacaciones_titulo;
    String vacaciones_inicio;
    String vacaciones_fin;
    String vacaciones_url;
    int usuario_id;
    int vacaciones_className;
    boolean vacaciones_editable;
    public Vacaciones() {
    }

    public Vacaciones(int vacaciones_id, String vacaciones_titulo, String vacaciones_inicio, String vacaciones_fin, String vacaciones_url, int usuario_id, int vacaciones_className, boolean vacaciones_editable) {
        this.vacaciones_id = vacaciones_id;
        this.vacaciones_titulo = vacaciones_titulo;
        this.vacaciones_inicio = vacaciones_inicio;
        this.vacaciones_fin = vacaciones_fin;
        this.vacaciones_url = vacaciones_url;
        this.usuario_id = usuario_id;
        this.vacaciones_className = vacaciones_className;
        this.vacaciones_editable = vacaciones_editable;
    }

    public int getVacaciones_id() {
        return vacaciones_id;
    }

    public void setVacaciones_id(int vacaciones_id) {
        this.vacaciones_id = vacaciones_id;
    }

    public String getVacaciones_titulo() {
        return vacaciones_titulo;
    }

    public void setVacaciones_titulo(String vacaciones_titulo) {
        this.vacaciones_titulo = vacaciones_titulo;
    }

    public String getVacaciones_inicio() {
        return vacaciones_inicio;
    }

    public void setVacaciones_inicio(String vacaciones_inicio) {
        this.vacaciones_inicio = vacaciones_inicio;
    }

    public String getVacaciones_fin() {
        return vacaciones_fin;
    }

    public void setVacaciones_fin(String vacaciones_fin) {
        this.vacaciones_fin = vacaciones_fin;
    }

    public String getVacaciones_url() {
        return vacaciones_url;
    }

    public void setVacaciones_url(String vacaciones_url) {
        this.vacaciones_url = vacaciones_url;
    }

    public int getUsuario_id() {
        return usuario_id;
    }

    public void setUsuario_id(int usuario_id) {
        this.usuario_id = usuario_id;
    }

    public int getVacaciones_className() {
        return vacaciones_className;
    }

    public void setVacaciones_className(int vacaciones_className) {
        this.vacaciones_className = vacaciones_className;
    }

    public boolean isVacaciones_editable() {
        return vacaciones_editable;
    }

    public void setVacaciones_editable(boolean vacaciones_editable) {
        this.vacaciones_editable = vacaciones_editable;
    }

   
    

}
