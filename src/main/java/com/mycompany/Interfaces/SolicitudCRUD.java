/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.Interfaces;

import com.mycompany.Modelo.Solicitud;
import java.util.List;

/**
 *
 * @author 56974
 */
public interface SolicitudCRUD {
    
    public List listar();
    public Solicitud list(int id);
    public boolean add(Solicitud sol);
    public boolean edit(Solicitud sol);
    public boolean eliminar(int id );
    public int cobrados();
}
