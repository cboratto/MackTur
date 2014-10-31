/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package macktur.control;

import control.base.AbstractApplicationController;
import macktur.DAO.ClienteDAO;
import macktur.DAO.ClienteDAOImpl;
import macktur.modelo.Cliente;
import macktur.persistencia.ClienteBD;

/**
 *
 * @author caioboratto
 */
public class BuscarClienteServlet extends AbstractApplicationController {

    @Override
    public void execute() {

        String cpf = getRequest().getParameter("cpf");
        ClienteDAOImpl clientebd = new ClienteDAOImpl();

        Cliente cliente = clientebd.findCPF(cpf);

        //cliente existe na base
        getRequest().setAttribute("cliente", cliente);

        this.setReturnPage("/CadastrarClienteMain.jsp");

    }

}
