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
                + "usuario_id) VALUES (?, ?, ?, ?, ?)";

        System.out.println(sql);

        try {
            con = cn.getConnection();
            ps = (PreparedStatement) con.prepareStatement(sql);

            ps.setString(1, vac.getVacaciones_titulo());
            ps.setString(2, vac.getVacaciones_inicio());
            ps.setString(3, vac.getVacaciones_fin());
            ps.setString(4, vac.getVacaciones_url());
            ps.setInt(5, vac.getUsuario_id());
            System.out.println(ps);

            ps.executeUpdate();
        } catch (Exception e) {
        }

        return false;

    }

    public ArrayList<Vacaciones> listar(int id) {

        ArrayList<Vacaciones> list = new ArrayList<>();
        String sql = "SELECT * FROM vacaciones WHERE usuario_id =" + "'" + id + "'";

        System.out.println("modelo vacaciones  " + sql);

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
                vac.setVacaciones_className(rs.getInt("vacaciones_className"));
                vac.setVacaciones_editable(rs.getBoolean("vacaciones_editable"));

                list.add(vac);
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        System.out.println("lista del metodo" + list.size());

        return list;

    }

    public Vacaciones list(int id) {
        String sql = "SELECT * FROM vacaciones WHERE vacaciones_id=" + "'" + id + "'";
        System.out.println(sql);
        try {
            con = cn.getConnection();
            ps = (PreparedStatement) con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {

                p.setVacaciones_titulo(rs.getString("vacaciones_titulo"));
                p.setVacaciones_inicio(rs.getString("vacaciones_inicio"));
                p.setVacaciones_fin(rs.getString("vacaciones_fin"));
                p.setVacaciones_url(rs.getString("vacaciones_url"));
                p.setVacaciones_className(rs.getInt("vacaciones_className"));

            }
        } catch (Exception e) {
            System.out.println(e);
        }

        return p;
    }

    public boolean edit(Vacaciones per) {

        String sql = "UPDATE vacaciones SET vacaciones_titulo=? , vacaciones_inicio= ?, vacaciones_fin=?,"
                + "vacaciones_url=?, usuario_id=?, vacaciones_className=? WHERE vacaciones_id=" + per.getVacaciones_id();

        System.out.println(sql);
        try {
            con = cn.getConnection();
            ps = (PreparedStatement) con.prepareStatement(sql);

            ps.setString(1, per.getVacaciones_titulo());
            ps.setString(2, per.getVacaciones_inicio());
            ps.setString(3, per.getVacaciones_fin());
            ps.setString(4, per.getVacaciones_url());
            ps.setInt(5, per.getUsuario_id());
            ps.setInt(6, per.getVacaciones_className());

            ps.executeUpdate();

        } catch (Exception e) {
        }
        System.out.println(ps);
        return false;
    }
  public int cobrados(){
    int cobrados = 1; 
        
        return cobrados;
    }
  
    public boolean eliminar(int id, int idVac) {
        String sql = "DELETE FROM vacaciones WHERE usuario_id=" + id + " AND vacaciones_id=" + idVac;
        System.out.println(sql);
        try {
            con = cn.getConnection();
            ps = (PreparedStatement) con.prepareStatement(sql);
            ps.executeUpdate();

        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println(ps);

        return true;
    }
    
  

}
