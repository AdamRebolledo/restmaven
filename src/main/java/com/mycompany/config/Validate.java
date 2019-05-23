/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.config;

import com.mycompany.Controlador.Insertar;
import com.mycompany.Modelo.Persona;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author 56974
 */
public class Validate {

    public boolean validateRut(String rut) {

        boolean validacion = false;
        try {
            rut = rut.toUpperCase();
            rut = rut.replace(".", "");
            rut = rut.replace("-", "");
            int rutAux = Integer.parseInt(rut.substring(0, rut.length() - 1));

            char dv = rut.charAt(rut.length() - 1);

            int m = 0, s = 1;
            for (; rutAux != 0; rutAux /= 10) {
                s = (s + rutAux % 10 * (9 - m++ % 6)) % 11;
            }
            if (dv == (char) (s != 0 ? s + 47 : 75)) {
                validacion = true;
            }

        } catch (java.lang.NumberFormatException e) {
        } catch (Exception e) {
        }

        return validacion;
    }

    public boolean validateNum(String text) {
        int control;
        try {
            control = Integer.parseInt(text);
            return true;
        } catch (Exception e) {
            System.out.println("error en la validacion de campo num");
            return false;
        }
    }

    public boolean validateText(String text) {
        int control;
        try {
            control = Integer.parseInt(text);
            return false;
        } catch (Exception e) {
            System.out.println("error en la validacion de campo num");

        }
        return true;
    }

    public boolean validateNumPhone(String text) {
        int control;
        try {
            if (text.length() < 10) {
                control = Integer.parseInt(text);
                return true;
            }
        } catch (Exception e) {
            System.out.println("error en la validacion de campo num");
        }
        return false;
    }

    public boolean validateEmail(String texto) {
        // Patrón para validar el email
        Pattern pattern = Pattern
                .compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        Matcher mather = pattern.matcher(texto);
        if (mather.find() == true) {
            return true;
        } else {
            return false;
        }
    }
    
    

    public boolean validateBirthdate(String text) {
//fecha recibica
        System.out.println(":::::::::::::::::::::::::::"+text);
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date ts = null;
        try {
            
            ts = df.parse(text);
        } catch (ParseException ex) {
           System.out.println("error en la validacion de campo num");
           return false;
        }
        
//fecha actual
        Date fechaFinal = new Date();
        SimpleDateFormat formateador = new SimpleDateFormat("yyyy-MM-dd");
        formateador.format(fechaFinal);
//diferencia
        int dias = (int) ((fechaFinal.getTime() - ts.getTime()) / 86400000);
        if (dias > 0) {
            return true;
        } else {
            return false;
        }
    }
    
    public boolean validateCurrentDate(String text){
    DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date ts = null;
        try {
            
            ts = df.parse(text);
        } catch (ParseException ex) {
           System.out.println("error en la validacion de campo num");
           return false;
        }
        
        //fecha actual
        Date fechaFinal = new Date();
        SimpleDateFormat formateador = new SimpleDateFormat("yyyy-MM-dd");
        formateador.format(fechaFinal);
        
        //diferencia
        int dias = (int) ((fechaFinal.getTime() - ts.getTime()) / 86400000);
        if (dias > 0) {
            return true;
        } else {
            return false;
        }
    }
    
    public boolean compareDates(String start, String end){
    //fecha inicial
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date tsStart = null;
        try {
            
            tsStart = df.parse(start);
        } catch (ParseException ex) {
           System.out.println("error en la validacion de campo num");
           return false;
        }
        
        //fecha final
        Date tsEnd = null;
        try {
            tsEnd = df.parse(end);
        } catch (ParseException ex) {
           System.out.println("error en la validacion de campo num");
           return false;
        }
         //diferencia
        int dias = (int) ((tsEnd.getTime() - tsStart.getTime()) / 86400000);
        if (dias > 0) {
            return true;
        } else {
            return false;
        }
    }

}
