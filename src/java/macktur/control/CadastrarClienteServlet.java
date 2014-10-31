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
import macktur.modelo.Pessoa;
import macktur.persistencia.ClienteBD;

public class CadastrarClienteServlet extends AbstractApplicationController {

    @Override
    public void execute() {

        //Parametro que identifica se o usuário já existe na base
        String usuarioExiste = (String) getRequest().getSession().getAttribute("cliente_existe");
        //Dados de cadastro do usuario
        Cliente cliente = new Cliente();
        Pessoa  pessoa  = new Pessoa();
        pessoa.setNome(getRequest().getParameter("nome"));
        pessoa.setCpf(getRequest().getParameter("cpf"));
        cliente.setEmail(getRequest().getParameter("email"));
        //Voo escolhido
        String vooEscolhido = (String) getRequest().getSession().getAttribute("vooSelecionado");

        
        
        ClienteDAO clientebd = new ClienteDAOImpl();

        if (usuarioExiste.equals("0")) {
            clientebd.insert(cliente);
        } 
        this.setReturnPage("/CadastrarCliente.jsp");

    }

}
