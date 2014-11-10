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
public class Aviao {

    int idtAviao;
    AviaoTipo aviaoTipo;
    String nomeAviao;

    public Aviao() {
    }

    ;
    
    public Aviao(int idtAviao, AviaoTipo aviaoTipo, String nomeAviao) {
        this.idtAviao = idtAviao;
        this.aviaoTipo = aviaoTipo;
        this.nomeAviao = nomeAviao;
    }

    public int getIdtAviao() {
        return idtAviao;
    }

    public void setIdtAviao(int idtAviao) {
        this.idtAviao = idtAviao;
    }

    public AviaoTipo getAviaoTipo() {
        return aviaoTipo;
    }

    public void setAviaoTipo(AviaoTipo aviaoTipo) {
        this.aviaoTipo = aviaoTipo;
    }

    public String getNomeAviao() {
        return nomeAviao;
    }

    public void setNomeAviao(String nomeAviao) {
        this.nomeAviao = nomeAviao;
    }

}
