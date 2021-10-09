package unipiloto.edu.transportecargaplus.Entidades;

public class SolicitudVehicular {
    private String idSolitud;
    private String direccionOrigen;
    private String direccionDestino;
    private String tamanoAlto;
    private String tamanoAncho;
    private String idvehiculo;
    private String idusuario;
    private String estado;

    public SolicitudVehicular(String idSolitud, String direccionOrigen, String direccionDestino, String tamanoAlto, String tamanoAncho,String idvehiculo,String estado,String idusuario) {
        this.idSolitud = idSolitud;
        this.direccionOrigen = direccionOrigen;
        this.direccionDestino = direccionDestino;
        this.tamanoAlto = tamanoAlto;
        this.tamanoAncho = tamanoAncho;
        this.idvehiculo =idvehiculo;
        this.estado=estado;
        this.idusuario=idusuario;
    }
    public SolicitudVehicular() {

    }

    public String getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(String idusuario) {
        this.idusuario = idusuario;
    }

    public String getIdvehiculo() {
        return idvehiculo;
    }

    public void setIdvehiculo(String idvehiculo) {
        this.idvehiculo = idvehiculo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getIdSolitud() {
        return idSolitud;
    }

    public void setIdSolitud(String idSolitud) {
        this.idSolitud = idSolitud;
    }

    public String getDireccionOrigen() {
        return direccionOrigen;
    }

    public void setDireccionOrigen(String direccionOrigen) {
        this.direccionOrigen = direccionOrigen;
    }

    public String getDireccionDestino() {
        return direccionDestino;
    }

    public void setDireccionDestino(String direccionDestino) {
        this.direccionDestino = direccionDestino;
    }

    public String getTamanoAlto() {
        return tamanoAlto;
    }

    public void setTamanoAlto(String tamanoAlto) {
        this.tamanoAlto = tamanoAlto;
    }

    public String getTamanoAncho() {
        return tamanoAncho;
    }

    public void setTamanoAncho(String tamanoAncho) {
        this.tamanoAncho = tamanoAncho;
    }
}
