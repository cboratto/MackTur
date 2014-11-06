/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package macktur.control;

import control.base.AbstractApplicationController;
import macktur.DAO.ClienteDAO;
import macktur.DAO.ClienteDAOImpl;
import macktur.DAO.ReservaDAO;
import macktur.DAO.ReservaDAOImpl;
import macktur.modelo.Cliente;
import macktur.modelo.ETicket;
import macktur.modelo.Pessoa;
import macktur.modelo.Reserva;
import macktur.modelo.Voo;
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
        pessoa.setDataNascimento(getRequest().getParameter("dat_nasc"));
        cliente.setEmail(getRequest().getParameter("email"));
        cliente.setDataCadastro((String)getRequest().getSession().getAttribute("dat_cadastro"));
        cliente.setPessoa(pessoa);
        
        //Voo escolhido
        Voo voo = new Voo();
        voo.setId(Integer.parseInt((String) getRequest().getSession().getAttribute("vooSelecionado")));
        
        ClienteDAOImpl clientebd = new ClienteDAOImpl();
        //retorna o id do usuario
        if (usuarioExiste.equals("0")) {
            clientebd.insert(cliente);
            cliente = clientebd.findCPF(cliente.getPessoa().getCpf()); 
        }
        else {
            String cpf = cliente.getPessoa().getCpf();
            cliente = clientebd.findCPF(cpf); 
        }
        //temos o id do voo escolhido
        //instanciamos a reserva
        Reserva reserva = new Reserva();
        ReservaDAOImpl reservabd = new ReservaDAOImpl();
        
        reserva.setCliente(cliente);
        reserva.setVoo(voo);
        
        ETicket eticket = reservabd.insertEticket(reserva);
        
        this.getRequest().setAttribute("eticket", eticket);
        this.setReturnPage("/Efetua_Reserva.jsp");

    }

}
