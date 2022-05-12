/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import dao.excepciones.SinTipoUsuario;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.administracion_registro.Persona;
import modelo.administracion_registro.Usuario;

/**
 *
 * @author Alumno
 */
public class Dao {

    static Dao instancia = null;

    public boolean comprobarUsuario(String nom, String con) {

        boolean existe = false;
        ResultSet rs;

        try {
            rs = ConexionBD.instancia().getStatement().executeQuery("select count(*) from usuario where nusuario = '" + nom + "' and contraseña = '" + con + "'");
            if (rs.next()) {

                if (rs.getInt(1) == 1) {

                    existe = true;
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(Dao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return existe;
    }

    public String getTipoUsuario(String nick) {

        String tipoUsuario = null;
        ResultSet rs;
        try {
            rs = ConexionBD.instancia().getStatement().executeQuery("SELECT `tipousuario` FROM `usuario` WHERE `nusuario` = '" + nick + "'");
            if (rs.next()) {

                if (rs.getString(1) != null) {

                    tipoUsuario = rs.getString(1);

                }

            }
            if (tipoUsuario == null) {

                throw new SinTipoUsuario();
            }

        } catch (SQLException ex) {
            Logger.getLogger(Dao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getMessage());
        } catch (SinTipoUsuario e) {

            System.out.println(e.toString());
        }

        return tipoUsuario;

    }

    public void guardarPersona(Persona p) {

        Usuario u = p.getUsuario();
        try {
            ConexionBD.instancia().getStatement().execute("insert into usuario values ('" + u.getNickName() + "','" + u.getContraseña() + "','" + u.getTipoUsuario().toString() + "')");
            ConexionBD.instancia().desconectar();
            ConexionBD.instancia().getStatement().execute("INSERT INTO `persona`(`Dni`, `nick`, `nombre`, `ape1`, `ape2`, `fecha_nac`, `sexo`) VALUES ('" + p.getDni().toString() + "','" + u.getNickName() + "','" + p.getNombre() + "','" + p.getApellido1() + "','" + p.getApellido2() + "','" + p.getFechaNacimiento().toString() + "','" + p.getSexo().toString() + "')");
            ConexionBD.instancia().desconectar();
        } catch (SQLException ex) {
            Logger.getLogger(Dao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean comprobarUsuarioRepetido(Usuario u) {

        boolean repetido = false;
        ResultSet rs;
        try {
            rs = ConexionBD.instancia().getStatement().executeQuery("select count(*) from usuario where nusuario = '" + u.getNickName() + "'");
            rs.next();
            if (rs.getInt(1) != 0) {

                repetido = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Dao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return repetido;
    }
    public boolean comprobarDniRepetido(String dni){
    
        boolean repetido = false;
        ResultSet rs;
        try {
            rs = ConexionBD.instancia().getStatement().executeQuery("SELECT count(*) FROM `persona` WHERE dni = " + dni);
            rs.next();
 
            if(rs.getInt(1) != 0){

                repetido = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Dao.class.getName()).log(Level.SEVERE, null, ex);
        }
    
        return repetido;
    }

    public static Dao instancia() {

        if (instancia == null) {
            instancia = new Dao();
        }
        return instancia;
    }
}
