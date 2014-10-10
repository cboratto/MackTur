<%-- 
    Document   : CadastrarCliente
    Created on : Oct 6, 2014, 11:15:31 PM
    Author     : caioboratto
--%>

<%@page import="macktur.modelo.Cliente"%>
<%@page import="macktur.persistencia.ClienteBD"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastrar Cliente</title>
    </head>
    <body>
        <h1>Cadastrar Cliente</h1>
        <form method="POST" action="/MackTur/CadastrarClienteServlet">
            <p>CPF <input type="text" name="cpf"></p>
            <p><input type="submit"></p>
        </form>
        
    </body>
</html>
