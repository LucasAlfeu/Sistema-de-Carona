package br.ufrrj.si.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Carona {
	private int idCarona;
	private String saida;
	private String chegada;
	private String dataCarona;
	private String horario;
	private float valor;
	private int vagas;
	private String carro;
	private int idUsuario;
	
	public Carona(){
		
	}
	
	public Carona(String s, String c, String h, float val, int vag,String car, String d){
		this.saida = s;
		this.chegada = c;
		this.horario = h;
		this.valor = val;
		this.vagas = vag;
		this.carro = car;
		this.dataCarona = d;
	}

	public int getIdCarona() {
		return idCarona;
	}

	public void setIdCarona(int idCarona) {
		this.idCarona = idCarona;
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

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	public int getVagas() {
		return vagas;
	}

	public void setVagas(int vagas) {
		this.vagas = vagas;
	}

	public String getCarro() {
		return carro;
	}

	public void setCarro(String carro) {
		this.carro = carro;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getDataCarona() {
		return dataCarona;
	}

	public void setDataCarona(String dataCarona) {
		this.dataCarona = dataCarona;
	}
	
    public String formatarData(String dateStr) {
        try {
            SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd");
            
            SimpleDateFormat outputFormat = new SimpleDateFormat("dd/MM/yyyy");
            
            Date date = inputFormat.parse(dateStr);

            return outputFormat.format(date);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
	
}
