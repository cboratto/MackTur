/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package macktur.control;

import control.base.AbstractApplicationController;
import macktur.modelo.Cliente;
import macktur.persistencia.ClienteBD;

public class CadastrarClienteServlet extends AbstractApplicationController {

    @Override
    public void execute() {

        //Parametro que identifica se o usuário já existe na base
        String usuarioExiste = getRequest().getParameter("cliente_existe");
        //Dados de cadastro do usuario
        String nomeUsuario = getRequest().getParameter("nome");
        String cpfUsuario = getRequest().getParameter("cpf");
        String emailUsuario = getRequest().getParameter("email");
        //Voo escolhido
        String vooEscolhido = getRequest().getParameter("voo");

        Cliente cliente = null;
        ClienteBD clientebd = new ClienteBD();

        if (usuarioExiste.equals("0")) {
            
        }
        this.setReturnPage("/CadastrarCliente.jsp");

    }

}
