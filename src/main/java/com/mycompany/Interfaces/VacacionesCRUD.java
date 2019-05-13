/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.Interfaces;

import com.mycompany.Modelo.Vacaciones;
import java.util.List;

/**
 *
 * @author 56974
 */
public interface VacacionesCRUD {
    
     public List listar(int id);
    public Vacaciones list(int id);
    public boolean add(Vacaciones per);
    public boolean edit(Vacaciones per);
    public boolean eliminar(int id, int idVac );
    
}
