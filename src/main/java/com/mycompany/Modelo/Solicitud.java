/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.Modelo;

import java.util.Date;

/**
 *
 * @author 56974
 */
public class Solicitud {
    
    int solicitud_id;
    int usuario_id;
    Date solicitud_fecha;
    int solicitud_dias_cobrados;

    public Solicitud() {
    }

    public Solicitud(int solicitud_id, int usuario_id, Date solicitud_fecha
        , int solicitud_dias_cobrados) {
        this.solicitud_id = solicitud_id;
        this.usuario_id = usuario_id;
        this.solicitud_fecha = solicitud_fecha;
        this.solicitud_dias_cobrados = solicitud_dias_cobrados;
    }
    
    public int getSolicitud_id() {
        return solicitud_id;
    }

    public void setSolicitud_id(int solicitud_id) {
        this.solicitud_id = solicitud_id;
    }

    public int getUsuario_id() {
        return usuario_id;
    }

    public void setUsuario_id(int usuario_id) {
        this.usuario_id = usuario_id;
    }

    public Date getSolicitud_fecha() {
        return solicitud_fecha;
    }

    public void setSolicitud_fecha(Date solicitud_fecha) {
        this.solicitud_fecha = solicitud_fecha;
    }

    public int getSolicitud_dias_cobrados() {
        return solicitud_dias_cobrados;
    }

    public void setSolicitud_dias_cobrados(int solicitud_dias_cobrados) {
        this.solicitud_dias_cobrados = solicitud_dias_cobrados;
    }
    
    
    
}
