/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ModeloDAO;

import com.mycompany.config.Conexion;
import com.mycompany.Interfaces.CRUD;
import com.mycompany.Modelo.Persona;
import com.mysql.jdbc.PreparedStatement;
import static java.lang.System.exit;
import static java.lang.System.out;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 56974
 */
public class PersonaDAO implements CRUD {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Persona p = new Persona();

    public List listar() {

        ArrayList<Persona> list = new ArrayList<>();
        String sql = "SELECT * FROM persona";
        try {
            con = cn.getConnection();
            ps = (PreparedStatement) con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Persona per = new Persona();
                per.setUsuario_id(rs.getInt("usuario_id"));
                per.setUsuario_rut(rs.getString("usuario_rut"));
                per.setUsuario_nombre(rs.getString("usuario_nombre"));
                per.setUsuario_apellido(rs.getString("usuario_apellido"));
                per.setUsuario_telefono(rs.getString("usuario_telefono"));
                per.setUsuario_correo(rs.getString("usuario_correo"));
                per.setUsuario_pass(rs.getString("usuario_pass"));
                per.setUsuario_fecha_nacimiento(rs.getDate("usuario_fecha_nacimiento"));
                per.setUsuario_estatus(rs.getInt("usuario_estatus"));
                per.setUsuario_rol(rs.getInt("usuario_estatus"));

                list.add(per);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;

    }

    public Persona list(int id) {
        String sql = "SELECT * FROM persona WHERE usuario_id=" + "'" + id + "'";
        System.out.println(sql);
        try {
            con = cn.getConnection();
            ps = (PreparedStatement) con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                p.setUsuario_id(rs.getInt("usuario_id"));
                p.setUsuario_rut(rs.getString("usuario_rut"));
                p.setUsuario_nombre(rs.getString("usuario_nombre"));
                p.setUsuario_apellido(rs.getString("usuario_apellido"));
                p.setUsuario_telefono(rs.getString("usuario_telefono"));
                p.setUsuario_correo(rs.getString("usuario_correo"));
                p.setUsuario_pass(rs.getString("usuario_pass"));
                p.setUsuario_fecha_nacimiento(rs.getDate("usuario_fecha_nacimiento"));
                 p.setUsuario_fecha_ingreso(rs.getDate("usuario_fecha_ingreso"));
                p.setUsuario_estatus(rs.getInt("usuario_estatus"));
                p.setUsuario_rol(rs.getInt("usuario_rol"));

            }
        } catch (Exception e) {
            System.out.println(e);
        }

        return p;
    }

    public boolean add(Persona per) {
        String sql = "INSERT INTO persona (usuario_rut, usuario_nombre, usuario_apellido, usuario_telefono,"
                + "usuario_correo, usuario_pass, usuario_fecha_nacimiento"
                + ") VALUES (?, ?, ?, ?, ?, ?, ?)";
        
        System.out.println(sql);

        try {
            con = cn.getConnection();
            ps = (PreparedStatement) con.prepareStatement(sql);

            ps.setString(1, per.getUsuario_rut());
            ps.setString(2, per.getUsuario_nombre());
            ps.setString(3, per.getUsuario_apellido());
            ps.setString(4, per.getUsuario_telefono());
            ps.setString(5, per.getUsuario_correo());
            ps.setString(6, per.getUsuario_pass());
            ps.setDate(7, new java.sql.Date(per.getUsuario_fecha_nacimiento().getTime()));
            
            
            //ps.setInt(9, per.getUsuario_rol());
            
            System.out.println(ps);
          
            
            ps.executeUpdate();
        } catch (Exception e) {
        }

        return false;

    }

    public boolean edit(Persona per) {
        String sql = "UPDATE persona SET usuario_rut=? , usuario_nombre= ?, usuario_apellido=?,"
                + "usuario_telefono=?, usuario_correo=?, usuario_pass=?,"
                + "usuario_fecha_nacimiento=?, usuario_fecha_ingreso=? , usuario_estatus=?, usuario_rol=?"
                + "  WHERE usuario_id=" + per.getUsuario_id();
        System.out.println(sql);
        try {
            con = cn.getConnection();
            ps = (PreparedStatement) con.prepareStatement(sql);

            ps.setString(1, per.getUsuario_rut());
            ps.setString(2, per.getUsuario_nombre());
            ps.setString(3, per.getUsuario_apellido());
            ps.setString(4, per.getUsuario_telefono());
            ps.setString(5, per.getUsuario_correo());
            ps.setString(6, per.getUsuario_pass());
            ps.setDate(7, new java.sql.Date(per.getUsuario_fecha_nacimiento().getTime()));
            ps.setDate(8, new java.sql.Date(per.getUsuario_fecha_ingreso().getTime()));
            ps.setInt(9, per.getUsuario_estatus());
            ps.setInt(10, per.getUsuario_rol());

            ps.executeUpdate();

        } catch (Exception e) {
        }
        System.out.println(ps);
        return false;
    }

    public boolean eliminar(int id) {
        String sql = "DELETE FROM persona WHERE usuario_id=" + id;
        try {
            con = cn.getConnection();
            ps = (PreparedStatement) con.prepareStatement(sql);
            ps.executeUpdate();

        } catch (Exception e) {
        }
        System.out.println(ps);
        return true;
    }

    private void exit() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
     public Persona autenticar(String correo, String pass) {
         Persona p = new Persona();
         
        String sql = "SELECT * FROM persona WHERE usuario_correo = "+"'"+correo+"'"+" AND usuario_pass= "+"'"+pass+"'";
        System.out.println(sql);
        try {
            con = cn.getConnection();
            ps = (PreparedStatement) con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                p.setUsuario_id(rs.getInt("usuario_id"));
                p.setUsuario_rut(rs.getString("usuario_rut"));
                p.setUsuario_nombre(rs.getString("usuario_nombre"));
                p.setUsuario_apellido(rs.getString("usuario_apellido"));
                p.setUsuario_telefono(rs.getString("usuario_telefono"));
                p.setUsuario_correo(rs.getString("usuario_correo"));
                p.setUsuario_pass(rs.getString("usuario_pass"));
                p.setUsuario_fecha_nacimiento(rs.getDate("usuario_fecha_nacimiento"));
                p.setUsuario_estatus(rs.getInt("usuario_estatus"));
                p.setUsuario_rol(rs.getInt("usuario_rol"));

            }
        } catch (Exception e) {
            System.out.println(e);
        }
     
        return p;
    }
    
    
    

}
