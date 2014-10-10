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
public class AviaoTipo {
    int idtAviaoTipo;
    String nomeTipo;
    int numAssentos;

    public AviaoTipo(int idtAviaoTipo, String nomeTipo, int numAssentos) {
        this.idtAviaoTipo = idtAviaoTipo;
        this.nomeTipo = nomeTipo;
        this.numAssentos = numAssentos;
    }

    public int getIdtAviaoTipo() {
        return idtAviaoTipo;
    }

    public void setIdtAviaoTipo(int idtAviaoTipo) {
        this.idtAviaoTipo = idtAviaoTipo;
    }

    public String getNomeTipo() {
        return nomeTipo;
    }

    public void setNomeTipo(String nomeTipo) {
        this.nomeTipo = nomeTipo;
    }

    public int getNumAssentos() {
        return numAssentos;
    }

    public void setNumAssentos(int numAssentos) {
        this.numAssentos = numAssentos;
    }
    
}
