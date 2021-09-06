package unipiloto.edu.co.utilidades;

public class Utilidades {
    //Constantes campos tabla usuario
    public static String TABLA_USUARIO="usuario";
    public static String CAMPO_NOMBRE="nombre";
    public static String CAMPO_APELLIDO="apellido";
    public static String CAMPO_CORREO="correo";
    public static String CAMPO_PASSWORD="password";
    public static String CAMPO_ROL="rol";

   public static final String CREAR_TABLA_USUARIO="CREATE TABLE "+""+TABLA_USUARIO+" ("+CAMPO_NOMBRE+" TEXT, "+CAMPO_APELLIDO+" TEXT, "+CAMPO_CORREO+" TEXT, "+CAMPO_PASSWORD+" TEXT, "+CAMPO_ROL+" TEXT)";

}
