/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package modelo.administracion_registro;

import java.time.*;

public class EtapaPersonaEnClub {
    
    public LocalDate FECHA_ENTRADA_AL_CLUB;
    private LocalDate fechaSalidaDeClub = null;

    public EtapaPersonaEnClub(LocalDate FECHA_ENTRADA_AL_CLUB, LocalDate fechaSalidaDeClub) {
        this.FECHA_ENTRADA_AL_CLUB = FECHA_ENTRADA_AL_CLUB;
        this.fechaSalidaDeClub = fechaSalidaDeClub;
    }
    public Period tiempoEnClub(){
        
        Period periodo = null;
        if(fechaSalidaDeClub == null){
            periodo = Period.between(FECHA_ENTRADA_AL_CLUB, LocalDate.now());
        }
        else{
            periodo = Period.between(FECHA_ENTRADA_AL_CLUB, fechaSalidaDeClub);
        }
        
        return periodo;
    }

    public LocalDate getFechaSalidaDeClub() {
        return fechaSalidaDeClub;
    }

    public void setFechaSalidaDeClub(LocalDate fechaSalidaDeClub) {
        this.fechaSalidaDeClub = fechaSalidaDeClub;
    }

    

}
