package modelo.administracion_registro;


public class Domicilio {
    public final String DIRECCION;
    public final String CODIGO_POSTAL;
    public final String MUNICIPIO;
    public final String PROVINCIA;
    public Domicilio(String aDireccion, String aCodigopostal, String aMunicipio, String aProvincia) {
       DIRECCION=aDireccion;
       CODIGO_POSTAL=aCodigopostal;
       MUNICIPIO=aMunicipio;
       PROVINCIA=aProvincia;
    }

    
    public boolean equals(Domicilio d) {
        return this.DIRECCION.equals(d.DIRECCION) && this.CODIGO_POSTAL.equals(d.CODIGO_POSTAL) && this.PROVINCIA.equals(d.PROVINCIA);
        
    }

    public String getDIRECCION() {
        return DIRECCION;
    }

    public String getCODIGO_POSTAL() {
        return CODIGO_POSTAL;
    }

    public String getMUNICIPIO() {
        return MUNICIPIO;
    }

    public String getPROVINCIA() {
        return PROVINCIA;
    }
    public String setDIRECCION() {
        return DIRECCION;
    }

    public String setCODIGO_POSTAL() {
        return CODIGO_POSTAL;
    }

    public String setMUNICIPIO() {
        return MUNICIPIO;
    }

    public String setPROVINCIA() {
        return PROVINCIA;
    }
    
}
