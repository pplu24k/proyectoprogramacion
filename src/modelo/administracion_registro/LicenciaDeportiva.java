/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.administracion_registro;

import java.time.*;

public class LicenciaDeportiva {

    public static enum Kyu {
        KYU_6º, BLANCO_AMARILLO, KYU_5º, AMARILLO_NARANJA, KYU_4º, NARANJA_VERDE, KYU_3, VERDE_AZUL, KYU_2,
        AZUL_MARRON, KYU_1º, DAN_1º, DAN_2º, DAN_3º, DAN_4º, DAN_5º, DAN_6º, DAN_7º, DAN_8º, DAN_9º, DAN_10º
    }

    public Period validez = Period.ofYears(1);
    public String numero_licencia;
    private LocalDate inicioTemporada;
    private Kyu kyu;

    public LicenciaDeportiva(String numero_licencia, LocalDate inicioTemporada, Kyu kyu) {
        this.numero_licencia = numero_licencia;
        this.inicioTemporada = inicioTemporada;
        this.kyu = kyu;
    }

    @Override
    public String toString() {
        return "Licenciadeportiva{" + "validez=" + validez + ", numero_licencia=" + numero_licencia + ", inicioTemporada=" + inicioTemporada + ", kyu=" + kyu + '}';
    }

}
