package modelo.administracion_registro;

import java.util.SortedSet;

/**
 *
 * @author Usuario01
 */
public class Club {
    private String cif;
    private String nombre;
    private String domicilioDelClub;
    private String telefonoPrincipal;
    private String telefonoSecundario;
    private String correoPersona;
    SortedSet<Persona> persona;

  
    public Club(String cif, String nombre, String domicilioDelClub, String telefonoPrincipal, String telefonoSecundario, String correoPersona, SortedSet<Persona> persona) {
        this.cif = cif;
        this.nombre = nombre;
        this.domicilioDelClub = domicilioDelClub;
        this.telefonoPrincipal = telefonoPrincipal;
        this.telefonoSecundario = telefonoSecundario;
        this.correoPersona = correoPersona;
        this.persona = persona;
    }
    
}
