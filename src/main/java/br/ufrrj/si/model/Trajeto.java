package br.ufrrj.si.model;

public class Trajeto {
	private int idTrajeto;
	private String saida;
	private String chegada;
	
	public Trajeto() {
		
	}
	
	public Trajeto(String saida, String chegada) {
		this.saida = saida;
		this.chegada = chegada;
	}

	public int getIdTrajeto() {
		return idTrajeto;
	}

	public void setIdTrajeto(int idTrajeto) {
		this.idTrajeto = idTrajeto;
	}

	public String getSaida() {
		return saida;
	}

	public void setSaida(String saida) {
		this.saida = saida;
	}

	public String getChegada() {
		return chegada;
	}

	public void setChegada(String chegada) {
		this.chegada = chegada;
	}
	
	
}
