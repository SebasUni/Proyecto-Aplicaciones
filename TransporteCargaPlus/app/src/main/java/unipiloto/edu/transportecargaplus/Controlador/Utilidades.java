package unipiloto.edu.transportecargaplus.Controlador;

import java.security.PublicKey;
import java.security.SecureRandom;

public class Utilidades {

        //Constantes campos tabla usuario
        public static String TABLA_USUARIO="usuario";
        public static String CAMPO_IDUSUARIO="idusuario";
        public static String CAMPO_NOMBRE="nombre";
        public static String CAMPO_APELLIDO="apellido";
        public static String CAMPO_CORREO="correo";
        public static String CAMPO_PASSWORD="password";
        public static String CAMPO_ROL="rol";
        public static String CAMPO_IDPROPIETARIO="idpropietario";

        public static final String CREAR_TABLA_USUARIO="CREATE TABLE "+""+TABLA_USUARIO+"("+CAMPO_IDUSUARIO+" TEXT, "+CAMPO_NOMBRE+" TEXT,"+CAMPO_APELLIDO+" TEXT, "+CAMPO_CORREO+" TEXT,  "+CAMPO_PASSWORD+" TEXT, "+CAMPO_ROL+" TEXT,"+CAMPO_IDPROPIETARIO+" TEXT )";

        //Constantes de cmapos de tambla vehiculos
        public static String TABLA_VEHICULO="vehiculos";
        public static String CAMPO_IDVEHICULO="idvehiculo";
        public static String CAMPO_PLACA="placa";
        public static String CAMPO_MARCA="marca";
        public static String CAMPO_IDCONDUCTOR="idconductor";

        public static final String CREAR_TABLA_VEHICULO="CREATE TABLE "+""+TABLA_VEHICULO+"("+CAMPO_IDVEHICULO+" TEXT, "+CAMPO_PLACA+" TEXT,"+CAMPO_MARCA+" TEXT,"+CAMPO_IDPROPIETARIO+" TEXT,"+CAMPO_IDCONDUCTOR+" TEXT )";

        //solicitudes
        public  static String TABLA_SOLICITUD="solicitud";
        public  static String CAMPO_IDSOLICITUD="idsolicitud";
        public  static String CAMPO_DIRECCIONORIGEN="origen";
        public  static String CAMPO_DIRECCIONDESTINO="destino";
        public  static String CAMPO_TAMANOALTO="alto";
        public  static String CAMPO_TAMANOANCHO="ancho";
        public static String CAMPO_ESTADO="estado";
        //id vehiculo

        public static final String CREAR_TABLA_SOLICITUD="CREATE TABLE "+""+TABLA_SOLICITUD+"("+CAMPO_IDSOLICITUD+" TEXT, "+CAMPO_IDUSUARIO+" TEXT, "+CAMPO_DIRECCIONORIGEN+" TEXT, "+CAMPO_DIRECCIONDESTINO+" TEXT, "+CAMPO_TAMANOALTO+" TEXT, "+CAMPO_TAMANOANCHO+" TEXT, "+CAMPO_ESTADO+" TEXT, "+CAMPO_IDVEHICULO+" TEXT )";

}
