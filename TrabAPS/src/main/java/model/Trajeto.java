package model;

public class Trajeto {
    private String partida;
    private String destino;

    public Trajeto(String partida, String destino) {
        this.partida = partida;
        this.destino = destino;
    }

    public String getPartida() {
        return partida;
    }

    public String getDestino() {
        return destino;
    }

    public void setPartida(String partida) {
        this.partida = partida;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }
}
