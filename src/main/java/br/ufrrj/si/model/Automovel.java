package br.ufrrj.si.model;

public class Automovel {
	private int idAutomovel;
    private String placa;
    private String modelo;
    private String cor;
    private String tipo;
    private int idUsuario;

    public int getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	public Automovel(){

    }
    public Automovel(String placa, String modelo, String cor, String tipo) {
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
	public int getIdAutomovel() {
		return idAutomovel;
	}
	public void setIdAutomovel(int idAutomovel) {
		this.idAutomovel = idAutomovel;
	}
    
}
