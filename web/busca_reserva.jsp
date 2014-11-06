<%-- 
    Document   : procurar_reserva.jsp
    Created on : Nov 5, 2014, 10:01:25 PM
    Author     : caioboratto
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Busca de Reservas</title>
    </head>
    <body>
        <h1>Busca de Reservas</h1>
        <form method="POST" action="/MackTur/FrontControllerServlet?control=BuscaServlet&origem=eticket">
            <p>Código ETicket <input type="text" name="eticket"></p>
            
            <p><input type="submit"></p>
        </form>
    </body>
</html>
