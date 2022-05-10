/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package modelo.administracion_registro;


public class Email {
    
    private String email;
    
    public Email(String email){
    
        this.email = email;
        
    }
    
    public static boolean validar(String email){
    
        boolean validado = false;
        int len;
        int cont = 0;
        len = email.length();
        boolean arroba = false;
        
        
        while(cont < len){
        
            if(email.charAt(cont) == '@'){
            
                arroba = true;
            }
            if(arroba && email.charAt(cont) == '.'){
            
                validado = true;
            }
        
            cont++;
        }
        
        return validado;
    }

}
