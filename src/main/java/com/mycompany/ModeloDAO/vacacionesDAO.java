/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ModeloDAO;

import com.mycompany.config.Conexion;
import com.mycompany.Interfaces.VacacionesCRUD;
import com.mycompany.Modelo.Vacaciones;

import com.mysql.jdbc.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 56974
 */
public class vacacionesDAO implements VacacionesCRUD {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Vacaciones p = new Vacaciones();
    
    
    public boolean add(Vacaciones vac) {
        String sql = "INSERT INTO vacaciones (vacaciones_titulo, vacaciones_inicio, vacaciones_fin, vacaciones_url,"
                + "usuario_id, vacaciones_className, vacaciones_editable) VALUES (?, ?, ?, ?, ?, ?, ?)";

        System.out.println(sql);

        try {
            con = cn.getConnection();
            ps = (PreparedStatement) con.prepareStatement(sql);

            ps.setString(1, vac.getVacaciones_titulo());
            ps.setString(2, vac.getVacaciones_inicio());
            ps.setString(3, vac.getVacaciones_fin());
            ps.setString(4, vac.getVacaciones_url());
            ps.setInt(5, vac.getUsuario_id());
            ps.setString(6, vac.getVacaciones_className());
            ps.setBoolean(7, vac.isVacaciones_editable());
         

            System.out.println(ps);

            ps.executeUpdate();
        } catch (Exception e) {
        }

        return false;

    }
    public ArrayList<Vacaciones> listar(int id) {

        ArrayList<Vacaciones> list = new ArrayList<>();
        String sql = "SELECT * FROM vacaciones WHERE usuario_id =" + "'" + id + "'";
        
        System.out.println("modelo vacaciones  "+sql);
        
        try {
            con = cn.getConnection();
            ps = (PreparedStatement) con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Vacaciones vac = new Vacaciones();
                vac.setVacaciones_id(rs.getInt("vacaciones_id"));
                vac.setVacaciones_titulo(rs.getString("vacaciones_titulo"));
                vac.setVacaciones_inicio(rs.getString("vacaciones_inicio"));
                vac.setVacaciones_fin(rs.getString("vacaciones_fin"));
                vac.setVacaciones_url(rs.getString("vacaciones_url"));
                vac.setUsuario_id(rs.getInt("usuario_id"));
                vac.setVacaciones_className(rs.getString("vacaciones_className"));
                vac.setVacaciones_editable(rs.getBoolean("vacaciones_editable"));

                list.add(vac);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        
        System.out.println("lista del metodo"+list.size());
        
        return list;

    }

    public Vacaciones list(int id) {
        String sql = "SELECT * FROM persona WHERE usuario_id=" + "'" + id + "'";
        System.out.println(sql);
        /*  try {
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
         */
        return p;
    }



    public boolean edit(Vacaciones per) {
        /*
         String sql = "UPDATE persona SET usuario_rut=? , usuario_nombre= ?, usuario_apellido=?,"
         + "usuario_telefono=?, usuario_correo=?, usuario_pass=?,"
         + "usuario_fecha_nacimiento=?, usuario_estatus=?, usuario_rol=?"
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
         ps.setInt(8, per.getUsuario_estatus());
         ps.setInt(9, per.getUsuario_rol());

         ps.executeUpdate();

         } catch (Exception e) {
         }
         System.out.println(ps);*/
        return false;
    }

    public boolean eliminar(int id) {/*
         String sql = "DELETE FROM persona WHERE usuario_id=" + id;
         try {
         con = cn.getConnection();
         ps = (PreparedStatement) con.prepareStatement(sql);
         ps.executeUpdate();

         } catch (Exception e) {
         }
         System.out.println(ps);
         */

        return true;
    }

    @Override
    public List listar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
