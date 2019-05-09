/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Modelo;

import java.sql.Timestamp;
import java.util.Date;
import org.eclipse.persistence.jpa.jpql.parser.DateTime;

/**
 *
 * @author 56974
 */
public class Persona {

    int usuario_id;
    String usuario_rut;
    String usuario_nombre;
    String usuario_apellido;
    String usuario_telefono;
    String usuario_correo;
    String usuario_pass;
    Date usuario_fecha_nacimiento;
    int usuario_estatus;
    int usuario_rol;

    public Persona() {
    }

    public Persona(String usuario_rut, String usuario_nombre, String usuario_apellido, String usuario_telefono,
            String usuario_correo, String usuario_pass, Date usuario_fecha_nacimiento,
            int usuario_estatus, int usuario_rol) {
        this.usuario_rut = usuario_rut;
        this.usuario_nombre = usuario_nombre;
        this.usuario_apellido = usuario_apellido;
        this.usuario_telefono = usuario_telefono;
        this.usuario_correo = usuario_correo;
        this.usuario_pass = usuario_pass;
        this.usuario_fecha_nacimiento = usuario_fecha_nacimiento;
        this.usuario_estatus = usuario_estatus;
        this.usuario_rol = usuario_rol;

    }

    public int getUsuario_id() {
        return usuario_id;
    }

    public void setUsuario_id(int usuario_id) {
        this.usuario_id = usuario_id;
    }

    public String getUsuario_rut() {
        return usuario_rut;
    }

    public void setUsuario_rut(String usuario_rut) {
        this.usuario_rut = usuario_rut;
    }

    public String getUsuario_nombre() {
        return usuario_nombre;
    }

    public void setUsuario_nombre(String usuario_nombre) {
        this.usuario_nombre = usuario_nombre;
    }

    public String getUsuario_apellido() {
        return usuario_apellido;
    }

    public void setUsuario_apellido(String usuario_apellido) {
        this.usuario_apellido = usuario_apellido;
    }

    public String getUsuario_telefono() {
        return usuario_telefono;
    }

    public void setUsuario_telefono(String usuario_telefono) {
        this.usuario_telefono = usuario_telefono;
    }

    public String getUsuario_correo() {
        return usuario_correo;
    }

    public void setUsuario_correo(String usuario_correo) {
        this.usuario_correo = usuario_correo;
    }

    public String getUsuario_pass() {
        return usuario_pass;
    }

    public void setUsuario_pass(String usuario_pass) {
        this.usuario_pass = usuario_pass;
    }

    public Date getUsuario_fecha_nacimiento() {
        return usuario_fecha_nacimiento;
    }

    public void setUsuario_fecha_nacimiento(Date usuario_fecha_nacimiento) {
        this.usuario_fecha_nacimiento = usuario_fecha_nacimiento;
    }

    public int getUsuario_estatus() {
        return usuario_estatus;
    }

    public void setUsuario_estatus(int usuario_estatus) {
        this.usuario_estatus = usuario_estatus;
    }

    public int getUsuario_rol() {
        return usuario_rol;
    }

    public void setUsuario_rol(int usuario_rol) {
        this.usuario_rol = usuario_rol;
    }

}
