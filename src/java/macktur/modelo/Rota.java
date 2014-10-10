/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package macktur.modelo;

import java.util.Date;

/**
 *
 * @author caioboratto
 */
public class Rota {

    String dataPartida;
    String DateChegada;
    String origem;
    String destino;

    public Rota() {
    }

    public String getDataPartida() {
        return dataPartida;
    }

    public void setDataPartida(String dataPartida) {
        this.dataPartida = dataPartida;
    }

    public void setDateChegada(String DateChegada) {
        this.DateChegada = DateChegada;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getDateChegada() {
        return DateChegada;
    }

    public String getOrigem() {
        return origem;
    }

    public String getDestino() {
        return destino;
    }

}
