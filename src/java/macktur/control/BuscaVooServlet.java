/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package macktur.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import macktur.modelo.Voo;
import macktur.persistencia.VooBD;

/**
 *
 * @author caioboratto
 */
@WebServlet(name = "BuscaVooServlet", urlPatterns = {"/BuscaVooServlet"})
public class BuscaVooServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ParseException {
        response.setContentType("text/html;charset=UTF-8");
        RequestDispatcher rd;
        //Date dataPartida = null;
        //Date dataRetorno = null;
        try {
            String dPartida = request.getParameter("datapartida");
            String dRetorno = request.getParameter("dataretorno");
            String origem = request.getParameter("origem");
            String destino = request.getParameter("destino");

            List<Voo> voos = new ArrayList<Voo>();
            VooBD voobd = new VooBD();

            voos = voobd.buscaVoos(origem,destino, dPartida);

            if (voos.isEmpty()) {
                rd = request.getRequestDispatcher("/VoosNaoEncontrado.jsp");
            } else {
                rd = request.getRequestDispatcher("/ListarVoos.jsp");
            }
            request.setAttribute("voos", voos);

        } catch (Exception e) {
            rd = request.getRequestDispatcher("/ListarVoosErro.jsp");
        }
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
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(BuscaVooServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(BuscaVooServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
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
