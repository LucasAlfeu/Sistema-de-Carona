package model;

public class Automovel {
    private String placa;
    private String modelo;
    private String cor;
    private String tipo;

    public Automovel(){

    }
    public Automovel(String modelo, String placa, String cor, String tipo) {
        this.modelo = modelo;
        this.placa = placa;
        this.cor = cor;
        this.tipo = tipo;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }
}
