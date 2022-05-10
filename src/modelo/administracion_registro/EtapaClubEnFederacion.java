/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package modelo.administracion_registro;

import java.time.*;


public class EtapaClubEnFederacion {


    public final LocalDate FECHA_CREACION_CLUB;
    private LocalDate fechaCierreClub = null;

    public EtapaClubEnFederacion(LocalDate FECHA_CREACION_CLUB) {
        this.FECHA_CREACION_CLUB = FECHA_CREACION_CLUB;
    }
    public Period tiempoAbierto(){
        Period abierto;
        if(fechaCierreClub == null){
            abierto = Period.between(FECHA_CREACION_CLUB, LocalDate.now());
        }
        else{
            abierto = Period.between(FECHA_CREACION_CLUB, fechaCierreClub);
        }
        return abierto;
    }

    public LocalDate getFechaCierreClub() {
        return fechaCierreClub;
    }

    public void setFechaCierreClub(LocalDate fechaCierreClub) {
        this.fechaCierreClub = fechaCierreClub;
    }
    
    
    
    
    
    
    

}
