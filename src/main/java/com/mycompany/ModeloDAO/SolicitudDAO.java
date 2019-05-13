/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ModeloDAO;

import com.mycompany.Interfaces.SolicitudCRUD;
import com.mycompany.Modelo.Solicitud;
import com.mycompany.config.Conexion;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 56974
 */
public class SolicitudDAO implements SolicitudCRUD {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Solicitud sol = new Solicitud();

    public List listar() {

        ArrayList<Solicitud> list = new ArrayList<>();
        String sql = "SELECT * FROM solicitud";
        try {
            con = cn.getConnection();
            ps = (PreparedStatement) con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Solicitud sol = new Solicitud();
                sol.setSolicitud_id(rs.getInt("solicitud_id"));
                sol.setUsuario_id(rs.getInt("usuario_id"));
                sol.setSolicitud_fecha(rs.getDate("solicitud_fecha"));
                sol.setSolicitud_dias_pendientes(rs.getInt("solicitud_dias_pendientes"));
                sol.setSolicitud_dias_cobrados(rs.getInt("solicitud_dias_cobrados"));
                list.add(sol);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;

    }

    public Solicitud list(int id) {
        String sql = "SELECT * FROM solicitud WHERE usuario_id=" + "'" + id + "'";
        System.out.println(sql);
        try {
            con = cn.getConnection();
            ps = (PreparedStatement) con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                sol.setSolicitud_id(rs.getInt("solicitud_id"));
                sol.setUsuario_id(rs.getInt("usuario_id"));
                sol.setSolicitud_fecha(rs.getDate("solicitud_fecha"));
                sol.setSolicitud_dias_pendientes(rs.getInt("solicitud_dias_pendientes"));
                sol.setSolicitud_dias_cobrados(rs.getInt("solicitud_dias_cobrados"));
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        return sol;
    }

    public boolean add(Solicitud sol) {
        String sql = "INSERT INTO solicitud (usuario_id, solicitud_fecha, solicitud_dias_pendientes, solicitud_dias_cobrados,"
                + ") VALUES (?, ?, ?, ?)";

        System.out.println(sql);

        try {
            con = cn.getConnection();
            ps = (PreparedStatement) con.prepareStatement(sql);

            ps.setInt(1, sol.getUsuario_id());
            ps.setDate(2, new java.sql.Date(sol.getSolicitud_fecha().getTime()));
            ps.setInt(3, sol.getSolicitud_dias_pendientes());
            ps.setInt(4, sol.getSolicitud_dias_cobrados());
      
            System.out.println(ps);

            ps.executeUpdate();
        } catch (Exception e) {
        }

        return false;

    }

    public boolean edit(Solicitud per) {
        String sql = "UPDATE persona SET usuario_rut=? , usuario_nombre= ?, usuario_apellido=?,"
                + "usuario_telefono=?, usuario_correo=?, usuario_pass=?,"
                + "usuario_fecha_nacimiento=?, usuario_fecha_ingreso=? , usuario_estatus=?, usuario_rol=?"
                + "  WHERE usuario_id=" + per.getUsuario_id();
        System.out.println(sql);
        try {
            con = cn.getConnection();
            ps = (PreparedStatement) con.prepareStatement(sql);

            ps.setInt(1, sol.getUsuario_id());
            ps.setDate(2, new java.sql.Date(sol.getSolicitud_fecha().getTime()));
            ps.setInt(3, sol.getSolicitud_dias_pendientes());
            ps.setInt(4, sol.getSolicitud_dias_cobrados());

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

    /*  public Solicitud autenticar(String correo, String pass) {
      Solicitud p = new Solicitud();

        String sql = "SELECT * FROM persona WHERE usuario_correo = " + "'" + correo + "'" + " AND usuario_pass= " + "'" + pass + "'";
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
    }*/

}
