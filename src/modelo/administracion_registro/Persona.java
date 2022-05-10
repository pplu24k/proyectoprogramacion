/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package modelo.administracion_registro;

import java.time.*;



public class Persona {
    
    public static enum Sexo{
        MASCULINO, FEMENINO;
    }
    
    public Dni dni;
    private Usuario usuario;
    public LocalDate fechaNacimiento;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private Sexo sexo;
    private Domicilio domicilio;
    

    

    public Persona(Dni dni, Usuario usuario, LocalDate fechaNacimiento, String nombre, String apellido1, String apellido2,Sexo sexo, Domicilio domicilio){
        
        this.dni = dni;
        this.usuario = usuario;
        this.fechaNacimiento = fechaNacimiento;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.sexo = sexo;
        this.domicilio = domicilio;


    }
    
    public int calcularEdad(){
    
        LocalDate fechaActual = LocalDate.now();
        Period periodo = Period.between(fechaNacimiento,fechaActual);
        return periodo.getYears();
    }
    
}
