package unipiloto.edu.co.entidades;

public class Solicitud {
    private String direccionRecogida;
    private String direccionDestino;
    private String dimensionAltura;
    private String dimensionAncho;
    private String correo;
    public Solicitud(String direccionRecogida, String direccionDestino, String dimensionAltura, String dimensionAncho, String correo) {
        this.direccionRecogida = direccionRecogida;
        this.direccionDestino = direccionDestino;
        this.dimensionAltura = dimensionAltura;
        this.dimensionAncho = dimensionAncho;
        this.correo=correo;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDireccionRecogida() {
        return direccionRecogida;
    }

    public void setDireccionRecogida(String direccionRecogida) {
        this.direccionRecogida = direccionRecogida;
    }

    public String getDireccionDestino() {
        return direccionDestino;
    }

    public void setDireccionDestino(String direccionDestino) {
        this.direccionDestino = direccionDestino;
    }

    public String getDimensionAltura() {
        return dimensionAltura;
    }

    public void setDimensionAltura(String dimensionAltura) {
        this.dimensionAltura = dimensionAltura;
    }

    public String getDimensionAncho() {
        return dimensionAncho;
    }

    public void setDimensionAncho(String dimensionAncho) {
        this.dimensionAncho = dimensionAncho;
    }
}
