<%-- 
    Document   : Efetua_Reserva
    Created on : Nov 3, 2014, 6:59:40 PM
    Author     : caioboratto
--%>

<%@page import="macktur.modelo.ETicket"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Reserva de Voo</title>
    </head>
    <body>
        <h1>Reserva de Voo efetuada com sucesso</h1>

        <h3>e-Ticket gerado com sucesso</h3>
        <% ETicket eticket = (ETicket) request.getAttribute("eticket");
            if (eticket.getCodReserva() != null) {
        %> 
        <p><%=eticket.getCodReserva()%></p>
        <%
        } else {
        %> 
        <p>ERRO</p>
        <%
            }

        %>
    </body>
</html>
