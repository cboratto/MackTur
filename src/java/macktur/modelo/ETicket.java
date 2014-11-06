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
public class ETicket {

    private int id;
    private Reserva reserva;
    private String codReserva;
    private String flgReservaConfirmada;

    public ETicket() {
    }

    public String getFlgReservaConfirmada() {
        return flgReservaConfirmada;
    }

    public void setFlgReservaConfirmada(String flgReservaConfirmada) {
        this.flgReservaConfirmada = flgReservaConfirmada;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }

    public String getCodReserva() {
        return codReserva;
    }

    public void setCodReserva(String codReserva) {
        this.codReserva = codReserva;
    }

}
