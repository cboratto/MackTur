/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package macktur.modelo;

/**
 *
 * @author caioboratto
 */
public class Voo {

    String nomeVoo;
    int IdentificardorVoo;
    int numAssentosUtilizados;

    Rota rota;
    Aviao aviao;

    public Voo() {
    }

    public String getNomeVoo() {
        return nomeVoo;
    }

    public void setNomeVoo(String nomeVoo) {
        this.nomeVoo = nomeVoo;
    }

    public int getIdentificadorVoo() {
        return IdentificardorVoo;
    }

    public void setIdentificadorVoo(int idt_voo) {
        this.IdentificardorVoo = idt_voo;
    }

    public Rota getRota() {
        return rota;
    }

    public void setRota(Rota r) {
        rota = r;
    }

    public Aviao getAviao() {
        return aviao;
    }

    public void setAviao(Aviao aviao) {
        this.aviao = aviao;
    }

    public int getNumAssentosUtilizados() {
        return numAssentosUtilizados;
    }

    public void setNumAssentosUtilizados(int numAssentosUtilizados) {
        this.numAssentosUtilizados = numAssentosUtilizados;
    }

}
