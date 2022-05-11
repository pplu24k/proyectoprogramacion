/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao.excepciones;

/**
 *
 * @author Alumno
 */
public class SinTipoUsuario extends Exception {
    
    public String toString(){
    
        return "No se ha obtenido el atributo tipo de usuario o es nulo";
    }
    
}
