package unipiloto.edu.transportecargaplus.Entidades;

public class Vehiculo {
    private String idvehiculo;
    private String placa;
    private String marca;
    private String idpropietario;
    private String idconductor;

    public Vehiculo(String idvehiculo, String placa, String marca, String idpropietario, String idconductor) {
        this.idvehiculo = idvehiculo;
        this.placa = placa;
        this.marca = marca;
        this.idpropietario = idpropietario;
        this.idconductor = idconductor;
    }
    public Vehiculo() {

    }
    public String getIdvehiculo() {
        return idvehiculo;
    }

    public void setIdvehiculo(String idvehiculo) {
        this.idvehiculo = idvehiculo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getIdpropietario() {
        return idpropietario;
    }

    public void setIdpropietario(String idpropietario) {
        this.idpropietario = idpropietario;
    }

    public String getIdconductor() {
        return idconductor;
    }

    public void setIdconductor(String idconductor) {
        this.idconductor = idconductor;
    }
}