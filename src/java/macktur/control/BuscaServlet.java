/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package macktur.control;

import control.base.AbstractApplicationController;
import java.util.ArrayList;
import java.util.List;
import macktur.DAO.ETicketDAOImpl;
import macktur.modelo.ETicket;

/**
 *
 * @author caioboratto
 */
public class BuscaServlet extends AbstractApplicationController {

    @Override
    public void execute() {
        String origem = getRequest().getParameter("origem");

        if (origem.equals("eticket")) {
            ETicket eticket = new ETicket();
            String codEticket = getRequest().getParameter("eticket");
            
            ETicketDAOImpl eticketbd = new ETicketDAOImpl();
            
            eticket = eticketbd.findETicket(codEticket);
            
            if (eticket.getFlgReservaConfirmada()==null){
                //envia para pagina dizendo que não existe reserva com este código
                this.setReturnPage("/lista_eticket_notfound.jsp");
                
            }else if (eticket.getFlgReservaConfirmada().equals("N")){
                eticket.setFlgReservaConfirmada("S");
                eticketbd.update(eticket);
                
                getRequest().setAttribute("eticket", eticket);
                
                this.setReturnPage("/lista_eticket_sucesso.jsp");
            }else if (eticket.getFlgReservaConfirmada().equals("S")){
                this.setReturnPage("/lista_eticket_sucesso.jsp");
                getRequest().setAttribute("eticket", eticket);
            }
            
            this.getRequest().setAttribute("eticket", eticket);
            

        } else if (origem.equals("hotel")) {

            this.setReturnPage("/lista_hoteis.jsp");
            this.getRequest().setAttribute("lista_hoteis", null);
        } else if (origem.equals("quarto")) {

            this.setReturnPage("/lista_quartos.jsp");
            this.getRequest().setAttribute("lista_quartos", null);
        }
    }

}
