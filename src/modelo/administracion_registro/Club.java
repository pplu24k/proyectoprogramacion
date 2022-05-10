package modelo.administracion_registro;

public class Usuario {

    public static enum TipoUsuario {
        ADMINISTRADOR, GESTOR_COMPETICIONES, JUDOKA
    }

    public String nombre_usuario;
    private String contraseña;
    private TipoUsuario tipoUsuario;

    public Usuario(String nombre_usuario, String contraseña, TipoUsuario tipoUsuario) {
        this.nombre_usuario = nombre_usuario;
        this.contraseña = contraseña;
        this.tipoUsuario = tipoUsuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

}
