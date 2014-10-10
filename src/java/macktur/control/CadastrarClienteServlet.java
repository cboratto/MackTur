/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package macktur.control;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import macktur.modelo.Cliente;
import macktur.persistencia.ClienteBD;

/**
 *
 * @author caioboratto
 */
@WebServlet(name = "CadastrarClienteServlet", urlPatterns = {"/CadastrarClienteServlet"})
public class CadastrarClienteServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        RequestDispatcher rd;
        
        //Parametro que identifica se o usuário já existe na base
        String usuarioExiste = request.getParameter("cliente_existe");
        //Dados de cadastro do usuario
        String nomeUsuario = request.getParameter("nome");
        String cpfUsuario = request.getParameter("cpf");
        String emailUsuario = request.getParameter("email");
        //Voo escolhido
        String vooEscolhido = request.getParameter("voo");
        
        Cliente cliente=null;
        ClienteBD clientebd = new ClienteBD();
        
        if (usuarioExiste.equals("1")){
            
        }
      

        rd = request.getRequestDispatcher("/CadastrarCliente.jsp");

        rd.forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
