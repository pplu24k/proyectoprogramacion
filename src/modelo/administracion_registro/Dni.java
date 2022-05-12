/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package modelo.administracion_registro;


public class Dni {
    
    private String[] letras = new String[23];
    private int numero;
    private char letra;



public Dni(int numero){

    this.numero = numero;
    

}


    @Override
    public String toString(){
        
        String num = "" + numero;
        return ( num + letra);
}
    public static boolean comporbarDni(String dni){
    
        boolean valido=false;
        
        if(dni.length()==8){
        try{
            Integer.parseInt(dni);
            valido = true;
        }catch(Exception e){
            
        }
        }
        
        return valido;
        
    }
    
}