/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import dao.excepciones.SinTipoUsuario;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alumno
 */
public class Dao {
    
    static Dao instancia = null;
    
    
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
            Logger.getLogger(Dao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return existe;
    }
    
    public String getTipoUsuario(String nick){
        
        String tipoUsuario = null;
        ResultSet rs;
        try {
            rs = ConexionBD.instancia().getStatement().executeQuery("SELECT `tipousuario` FROM `usuario` WHERE `nusuario` = '"+nick+"'");
            if(rs.next()){
            
                
                
                    if(rs.getString(1) != null){
                        
                        tipoUsuario = rs.getString(1);
                        
                    }
                    
                    
                
            }
            if(tipoUsuario == null){
            
                throw new SinTipoUsuario();
            }
            
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Dao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getMessage());
        }
        catch(SinTipoUsuario e){
        
            System.out.println(e.toString());
        }
        
        return tipoUsuario;
        
    }
    


    
    
    public static Dao instancia(){
    
        if(instancia==null){
            instancia = new Dao();
        }
        return instancia;
    }
}
