package unipiloto.edu.co.entidades;

public class Usuario {

    private String nombre;
    private String apellido;
    private String correo;
    private String password;
    private String rol;
    private String Idpropietario;

    public Usuario( String nombre, String apellido, String correo, String password, String rol, String Idpropietario) {

        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.password = password;
        this.rol = rol;
        this.Idpropietario=Idpropietario;
    }
    public Usuario( ) {


    }
    public String getIdpropietario() {
        return Idpropietario;
    }

    public void setIdpropietario(String idpropietario) {
        Idpropietario = idpropietario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
}
