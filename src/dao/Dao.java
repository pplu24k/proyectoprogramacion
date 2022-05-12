/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import dao.excepciones.SinTipoUsuario;
import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.administracion_registro.Dni;
import modelo.administracion_registro.Domicilio;
import modelo.administracion_registro.Persona;
import modelo.administracion_registro.Persona.Sexo;
import modelo.administracion_registro.Usuario;

/**
 *
 * @author Alumno
 */
public class Dao {

    static Dao instancia = null;
    private static DateTimeFormatter formatoEuropeo = DateTimeFormatter.ofPattern("dd/LL/yyyy");
    
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
    
    public Persona cargarPersona(Usuario sesion){
    
        ResultSet rs;
        
        Domicilio dom = null;
        Persona nPersona = null;
        try {
            dom = cargarDomicilio(sesion.getNickName());
            rs = ConexionBD.instancia().getStatement().executeQuery("SELECT `Dni`, `nombre`, `ape1`, `ape2`, `fecha_nac`, `sexo` FROM `persona` WHERE nick = '"+sesion.getNickName()+"'");
            rs.next();
            nPersona = new Persona(new Dni(Integer.parseInt(rs.getString("dni"))),LocalDate.parse(rs.getString("fecha_nac"), formatoEuropeo),rs.getString("nombre"),rs.getString("ape1"),rs.getString("ape2"),Sexo.valueOf(rs.getString("sexo")),dom);
            

            
        } catch (SQLException ex) {
            Logger.getLogger(Dao.class.getName()).log(Level.SEVERE, null, ex);
        }
        

        return nPersona;
    }
    private Domicilio cargarDomicilio(String dueño){
    
        Domicilio dom = null;
    
            try{
            ResultSet rs = ConexionBD.instancia().getStatement().executeQuery("SELECT `direccion`, `cod_postal`, `municipio`, `provincia` FROM `domicilio` WHERE dueño = '"+dueño+"'");
            rs.next();
            System.out.println(rs.getString("direccion"));
            dom = new Domicilio(rs.getString("direccion"),rs.getString("cod_postal"),rs.getString("municipio"),rs.getString("provincia"));
            ConexionBD.instancia().desconectar();
            }catch(Exception e){
                System.out.println(e.getMessage());
            }
        return dom;
    }

    public static Dao instancia() {

        if (instancia == null) {
            instancia = new Dao();
        }
        return instancia;
    }
}
