/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.administracion_registro;

import java.time.*;
import java.util.concurrent.ThreadLocalRandom;
import modelo.administracion_registro.Usuario.TipoUsuario;

public class Persona {


    public static enum Sexo {
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

    public Persona(Dni dni, Usuario usuario, LocalDate fechaNacimiento, String nombre, String apellido1, String apellido2, Sexo sexo, Domicilio domicilio) {

        this.dni = dni;
        this.usuario = usuario;
        this.fechaNacimiento = fechaNacimiento;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.sexo = sexo;
        this.domicilio = domicilio;

    }

    public Persona(Dni dni, LocalDate fechaNacimiento, String nombre, String apellido1, String apellido2, Sexo sexo, Domicilio domicilio, TipoUsuario tipo) {

        this.dni = dni;
        this.fechaNacimiento = fechaNacimiento;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.sexo = sexo;
        this.domicilio = domicilio;
        usuario = generarUsuario(nombre, apellido1, apellido2, tipo);

    }

    public int calcularEdad() {

        LocalDate fechaActual = LocalDate.now();
        Period periodo = Period.between(fechaNacimiento, fechaActual);
        return periodo.getYears();
    }

    private Usuario generarUsuario(String nombre, String apellido1, String apellido2, TipoUsuario tipo) {

        Usuario newUser = null;
        String nname = "";
        String nomSinEsp = "";
        for (int i = 0; i < nombre.length(); i++) {

            if (nombre.charAt(i) != ' ') {

                nomSinEsp += nombre.charAt(i);
            }

        }

        for (int i = 0; i < nomSinEsp.length() / 2; i++) {

            nname += nomSinEsp.charAt(i);
        }
        nname += (apellido1.charAt(0));
        nname += (apellido2.charAt(0));
        nname += (LocalDate.now().getDayOfMonth());



        int lenPass;
        String pass = "";

        ThreadLocalRandom tlr = ThreadLocalRandom.current();
        lenPass = tlr.nextInt(6, 9);

        for (int i = 0; i < lenPass; i++) {

            int nascii = tlr.nextInt(48, 123);
            char caracter = (char) nascii;
            pass += caracter;

        }
        newUser = new Usuario(nname,pass,tipo);
        

        return newUser;

    }

    public Dni getDni() {
        return dni;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public Domicilio getDomicilio() {
        return domicilio;
    }

    @Override
    public String toString() {
        return "Persona{" + "dni=" + dni + ", usuario=" +usuario.toString()+ ", fechaNacimiento=" + fechaNacimiento + ", nombre=" + nombre + ", apellido1=" + apellido1 + ", apellido2=" + apellido2 + ", sexo=" + sexo + ", domicilio=" + domicilio.toString() + '}';
    }

    
}
