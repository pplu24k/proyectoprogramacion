/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package modelo.administracion_registro;


public class Usuario {
    
    
    public String nombre_usuario;
    private String contraseña;
    private TipoUsuario tipoUsuario;

    public Usuario(String nombre_usuario, String contraseña, TipoUsuario tipoUsuario) {
        this.nombre_usuario = nombre_usuario;
        this.contraseña = contraseña;
        this.tipoUsuario = tipoUsuario;
    }

    public String getNickName(){
    
        return nombre_usuario;
    }
    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
    
    public TipoUsuario getTipoUsuario(){
    
        return tipoUsuario;
    }
    
    public static enum TipoUsuario{
        ADMINISTRADOR, GESTOR_COMPETICIONES, NORMAL
    }

    @Override
    public String toString() {
        return "Usuario{" + "nombre_usuario=" + nombre_usuario + ", contrase\u00f1a=" + contraseña + ", tipoUsuario=" + tipoUsuario.toString() + '}';
    }

    
}
