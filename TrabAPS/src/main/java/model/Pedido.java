package model;

public class Pedido {
    private int idPedido;
    private String pontoDeEncontro;
    private Usuario passageiro;
    private String data;
    private String desembarque;
    private int vagasDesejadas;

    public Pedido(int idPedido, String pontoDeEncontro, Usuario passageiro, String data, String desembarque, int vagasDesejadas) {
        this.idPedido = idPedido;
        this.pontoDeEncontro = pontoDeEncontro;
        this.passageiro = passageiro;
        this.data = data;
        this.desembarque = desembarque;
        this.vagasDesejadas = vagasDesejadas;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public String getPontoDeEncontro() {
        return pontoDeEncontro;
    }

    public Usuario getPassageiro() {
        return passageiro;
    }

    public String getData() {
        return data;
    }

    public String getDesembarque() {
        return desembarque;
    }

    public int getVagasDesejadas() {
        return vagasDesejadas;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public void setPontoDeEncontro(String pontoDeEncontro) {
        this.pontoDeEncontro = pontoDeEncontro;
    }

    public void setPassageiro(Usuario passageiro) {
        this.passageiro = passageiro;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setDesembarque(String desembarque) {
        this.desembarque = desembarque;
    }

    public void setVagasDesejadas(int vagasDesejadas) {
        this.vagasDesejadas = vagasDesejadas;
    }
}
