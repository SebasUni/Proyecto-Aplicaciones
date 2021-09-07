package unipiloto.edu.co.entidades;

public class Solicitud {
    private String direccionRecogida;
    private String direccionDestino;
    private String dimensionAltura;
    private String dimensionAncho;
    private String estado;
    private String correopropietario;
    public Solicitud(String direccionRecogida, String direccionDestino, String dimensionAltura, String dimensionAncho, String estado,String correopropietario) {
        this.direccionRecogida = direccionRecogida;
        this.direccionDestino = direccionDestino;
        this.dimensionAltura = dimensionAltura;
        this.dimensionAncho = dimensionAncho;
        this.estado=estado;
        this.correopropietario=correopropietario;
    }
    public Solicitud() {

    }

    public String getCorreopropietario() {
        return correopropietario;
    }

    public void setCorreopropietario(String correopropietario) {
        this.correopropietario = correopropietario;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
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
