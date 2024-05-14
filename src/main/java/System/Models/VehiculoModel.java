package System.Models;

public class VehiculoModel {
    private String marca;
    private String modelo;
    private String color;
    public VehiculoModel(String marca, String modelo, String colo){
        this.marca = marca;
        this.modelo = modelo;
        this.color = colo;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getMarca() {
        return marca;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getModelo() {
        return modelo;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }
}
