/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package macktur.control;

import control.base.AbstractApplicationController;
import java.util.ArrayList;
import java.util.List;
import macktur.modelo.Voo;
import macktur.persistencia.VooBD;

/**
 *
 * @author caioboratto
 */
public class BuscaVooServlet extends AbstractApplicationController {

    @Override
    public void execute() {

        try {
            String dPartida = getRequest().getParameter("datapartida");
            String dRetorno = getRequest().getParameter("dataretorno");
            String origem = getRequest().getParameter("origem");
            String destino = getRequest().getParameter("destino");

            List<Voo> voos = new ArrayList<Voo>();
            VooBD voobd = new VooBD();

            voos = voobd.buscaVoos(origem, destino, dPartida);

            if (voos.isEmpty()) {
                this.setReturnPage("/VoosNaoEncontrado.jsp");
            } else {
                this.setReturnPage("/ListarVoos.jsp");
                getRequest().setAttribute("voos", voos);
            }

        } catch (Exception e) {
            this.setReturnPage("/ListarVoosErro.jsp");
        }
    }
}
