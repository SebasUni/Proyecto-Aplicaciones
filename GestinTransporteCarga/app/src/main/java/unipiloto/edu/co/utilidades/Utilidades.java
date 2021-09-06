package unipiloto.edu.co.utilidades;

public class Utilidades {
    //Constantes campos tabla usuario
    public static String TABLA_USUARIO="usuario";

    public static String NOMBRE="nombre";
    public static String APELLIDO="apellido";
    public static String CORREO="correo";
    public static String PASSWORD="password";
    public static String ROL="rol";

   public static final String CREAR_TABLA_USUARIO="CREATE TABLE"+TABLA_USUARIO+ " ( "+NOMBRE+" TEXT, "+APELLIDO+" TEXT, "+CORREO+" TEXT, "+PASSWORD+" TEXT, "+ROL+" TEXT) ";

}
