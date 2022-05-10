/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alumno
 */
public class AccionesBD {
    
    static AccionesBD instancia = null;
    
    
    public boolean comprobarUsuario(String nom, String con){
    
        boolean existe = false;
        ResultSet rs;
         
        try {
            rs = ConexionBD.instancia().getStatement().executeQuery("select count(*) from usuario where nusuario = '"+nom+"' and contraseña = '"+con+"'");
            if(rs.next()){
            
                if(rs.getInt(1) == 1){
                
                     existe = true;
                }
            }
            
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(AccionesBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return existe;
    }
    


    
    
    public static AccionesBD instancia(){
    
        if(instancia==null){
            instancia = new AccionesBD();
        }
        return instancia;
    }
}
