/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import dao.*;
import modelo.administracion_registro.*;
import modelo.administracion_registro.Usuario.TipoUsuario;

/**
 *
 * @author Alumno
 */
public class SistemaFederacionJudo {
    
    
    
    public void cerrar(){
        ConexionBD.desconectar();
    }
    public boolean comprobarUsuario(String nom, String con){
    
        return Dao.instancia().comprobarUsuario(nom, con);
    }
    public String getTipoUsuario(String nom){
    
        return Dao.instancia().getTipoUsuario(nom);
    }
    
    
    
}
