package unipiloto.edu.co.entidades;

public class Carros {
    private String placa;
    private String correocarros;
    private String marca;
    private String conductor;

    public Carros(String placa, String correocarros, String marca,String conductor) {
        this.placa = placa;
        this.correocarros = correocarros;
        this.marca = marca;
        this.conductor=conductor;
    }
    public Carros() {

    }
    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getCorreocarros() {
        return correocarros;
    }

    public void setCorreocarros(String correocarros) {
        this.correocarros = correocarros;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getConductor() {
        return conductor;
    }

    public void setConductor(String conductor) {
        this.conductor = conductor;
    }
}
