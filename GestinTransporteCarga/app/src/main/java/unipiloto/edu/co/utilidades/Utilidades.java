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

   //Constantes Campos tabla Solicitudes
    public static String TABLA_SOLICITUDES="solicitud";
    public static String CAMPO_DIRECCIONRECOGIDA="direccionRecogida";
    public static String CAMPO_DIRECCIONDESTINO="direccionDestino";
    public static String CAMPO_DIMENSIONALTO="dimensionAltura";
    public static String CAMPO_DIMESIONANCHO="dimensionAncho";
    public static String CAMPO_CORREOU="correo";

    public static final String CREAR_TABLA_SOLICITUDES="CREATE TABLE "+""+TABLA_SOLICITUDES+"("+CAMPO_DIRECCIONRECOGIDA+" TEXT, "+CAMPO_DIRECCIONDESTINO+" TEXT, "+CAMPO_DIMENSIONALTO+" TEXT,"+CAMPO_DIMESIONANCHO+" TEXT, "+CAMPO_CORREOU+" TEXT)";

}
