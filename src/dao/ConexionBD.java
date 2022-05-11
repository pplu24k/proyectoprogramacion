/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.*;
/**
 *
 * @author Alumno
 */
public class ConexionBD {
    
    static ConexionBD instancia;
    
    private Connection con;
    private Statement sta;
    
    public ConexionBD(){   
    
        try{
            Class.forName("com.mysql.jdbc.Driver");
        }catch(Exception e){
            System.out.println("No se encontro el driver");
        }
        
        try{
            //Ingresar ruta para conexion de BBDD
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/judo","root","");
            sta = con.createStatement();
            
        }catch(Exception e){
            System.out.println("No se puede conectar a la BBDD!!");
            System.out.println(e.getMessage());
        }
        
    }
    public Connection getConnection() {
        return con;
    }
    
    public Statement getStatement() {
        return sta;
    }
    
    public static void crearConexion() {
        if (instancia == null) {
            instancia = new ConexionBD();
        }
    }
    
    public static ConexionBD instancia() {
        if(instancia==null){
            instancia = new ConexionBD();
        }
        return instancia;
    }
    
    public static void desconectar() {
        if (instancia != null) {
            try {
                //instancia.stmt.execute("shutdown");
                instancia.sta.close();
                instancia.con.close();
                instancia = null;
            }
            catch(SQLException e) {
            }
        }
    }
    
    
    
    
    
    
}
