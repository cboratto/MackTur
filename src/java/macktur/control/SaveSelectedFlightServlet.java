/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package macktur.control;

import control.base.AbstractApplicationController;

public class SaveSelectedFlightServlet extends AbstractApplicationController {

    @Override
    public void execute() {

        String radio = getRequest().getParameter("voo");
        getRequest().getSession().setAttribute("vooSelecionado", radio);

        this.setReturnPage("/CadastrarCliente.jsp");

    }
}
