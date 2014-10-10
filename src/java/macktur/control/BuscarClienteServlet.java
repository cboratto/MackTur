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
@WebServlet(name = "BuscarClienteServlet", urlPatterns = {"/BuscarClienteServlet"})
public class BuscarClienteServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        RequestDispatcher rd;
        String cpf = request.getParameter("cpf");
        String radio = request.getParameter("voo");
        
        ClienteBD clientebd = new ClienteBD();

        Cliente cliente = clientebd.buscaCliente(cpf);
        
        if (cliente != null) {
            //cliente existe na base
            request.setAttribute("cliente", cliente);
            request.setAttribute("voo", radio);
        }
        rd = request.getRequestDispatcher("/CadastrarClienteMain.jsp");
        
        rd.forward(request, response);
    }

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
