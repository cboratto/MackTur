<%-- 
    Document   : lista_eticket_sucesso
    Created on : Nov 10, 2014, 7:03:56 PM
    Author     : caioboratto
--%>

<%@page import="macktur.modelo.ETicket"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>E-Ticket</title>
    </head>
    <body>
        <h1>Reserva confirmada com sucesso</h1>
        <%
            ETicket eticket = (ETicket) request.getAttribute("eticket");

        %>
        <p>E-Ticket <%=eticket.getCodReserva()%> confirmado com sucesso</p>
        <p>Nome do Passageiro: <%=eticket.getReserva().getCliente().getPessoa().getNome()%></p>
        <p>CPF do Passageiro: <%=eticket.getReserva().getCliente().getPessoa().getCpf()%></p>
        <p>Nome do Voo:  <%=eticket.getReserva().getVoo().getNomeVoo()%></p>
        <p>Origem:  <%=eticket.getReserva().getVoo().getRota().getOrigem()%></p>
        <p>Destino:  <%=eticket.getReserva().getVoo().getRota().getDestino()%></p>
    </p>
</body>
</html>
