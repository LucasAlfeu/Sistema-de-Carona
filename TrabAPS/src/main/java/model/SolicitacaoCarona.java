package model;

import java.time.LocalDateTime;

public class SolicitacaoCarona {
    private int ID_Pedido;
    private String embarque;
    private String desembarque;
    private LocalDateTime data;
    private int vagasDesejadas;
    private boolean confirmado;
    private int idUsuario;
    private int idCarona;

    public SolicitacaoCarona (String embarque, String desembarque, LocalDateTime data, int vagasDesejadas, boolean confirmado, int idUsuario) {
        this.embarque = embarque;
        this.desembarque = desembarque;
        this.data = data;
        this.vagasDesejadas = vagasDesejadas;
        this.idUsuario = idUsuario;
        this.confirmado = false;
    }

    public SolicitacaoCarona(int ID_Pedido, String embarque, String desembarque, LocalDateTime data, int vagasDesejadas, boolean confirmado, int idUsuario, int idCarona) {
        this.ID_Pedido = ID_Pedido;
        this.embarque = embarque;
        this.desembarque = desembarque;
        this.data = data;
        this.vagasDesejadas = vagasDesejadas;
        this.confirmado = confirmado;
        this.idUsuario = idUsuario;
        this.idCarona = idCarona;
    }

    public int getID_Pedido() {return ID_Pedido;}
    public void setID_Pedido(int ID_Pedido) {this.ID_Pedido = ID_Pedido;}
    public String getEmbarque() {return embarque;}
    public void setEmbarque(String embarque) {this.embarque = embarque;}
    public String getDesembarque() {return desembarque;}
    public void setDesembarque(String desembarque) {this.desembarque = desembarque;}
    public LocalDateTime getData() {return data;}
    public void setData(LocalDateTime data) {this.data = data;}
    public int getVagasDesejadas() {return vagasDesejadas;}
    public void setVagasDesejadas(int vagasDesejadas) {this.vagasDesejadas = vagasDesejadas;}
    public boolean getConfirmado() {return confirmado;}
    public void setConfirmado(boolean confirmado) {this.confirmado = confirmado;}
    public int getIdUsuario() {return idUsuario;}
    public void setIdUsuario(int idUsuario) {this.idUsuario = idUsuario;}
    public int getIdCarona() {return idCarona;}
    public void setIdCarona(int idCarona) {this.idCarona = idCarona;}

}
