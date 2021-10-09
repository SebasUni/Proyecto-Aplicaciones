package unipiloto.edu.co.utilidades;

import java.util.regex.MatchResult;

public class Utilidades {
    //Constantes campos tabla usuario
    public static String TABLA_USUARIO="usuario";
    public static String CAMPO_NOMBRE="nombre";
    public static String CAMPO_APELLIDO="apellido";
    public static String CAMPO_CORREO="correo";
    public static String CAMPO_PASSWORD="password";
    public static String CAMPO_ROL="rol";
    public static String CAMPO_IDPROPIETARIO="Idpropietario";


   public static final String CREAR_TABLA_USUARIO="CREATE TABLE "+""+TABLA_USUARIO+" ("+CAMPO_NOMBRE+" TEXT, "+CAMPO_APELLIDO+" TEXT, "+CAMPO_CORREO+" TEXT, "+CAMPO_PASSWORD+" TEXT, "+CAMPO_ROL+" TEXT,"+CAMPO_IDPROPIETARIO+" TEXT)";

   //Constantes Campos tabla Solicitudes
    public static String TABLA_SOLICITUDES="solicitud";
    public static String CAMPO_DIRECCIONRECOGIDA="direccionRecogida";
    public static String CAMPO_DIRECCIONDESTINO="direccionDestino";
    public static String CAMPO_DIMENSIONALTO="dimensionAltura";
    public static String CAMPO_DIMESIONANCHO="dimensionAncho";
    public static String CAMPO_ESTADO="estado";
    public static String CAMPO_CORREOPROPIETARIO="correopropietario";


    public static final String CREAR_TABLA_SOLICITUDES="CREATE TABLE "+""+TABLA_SOLICITUDES+"("+CAMPO_DIRECCIONRECOGIDA+" TEXT, "+CAMPO_DIRECCIONDESTINO+" TEXT, "+CAMPO_DIMENSIONALTO+" TEXT,"+CAMPO_DIMESIONANCHO+" TEXT, "+CAMPO_ESTADO+" TEXT, "+CAMPO_CORREOPROPIETARIO+" TEXT)";
    // Constantes campo de carros

    public static String TABLA_CARROS="carros";
    public static String CAMPO_CORREOCARROS="correocarros";
    public static String CAMPO_PLACA="placa";
    public static String CAMPO_MARCA="marca";
    public static String CAMPO_CONDUCTOR="conductor";

    public static final String CREAR_TABLA_CARROS="CREATE TABLE "+""+TABLA_CARROS+"("+CAMPO_PLACA+" TEXT,"+CAMPO_CORREOCARROS+" TEXT,  "+ CAMPO_MARCA+" TEXT, "+CAMPO_CONDUCTOR+" TEXT)";
}
