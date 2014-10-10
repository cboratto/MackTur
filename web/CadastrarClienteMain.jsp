<%-- 
    Document   : CadastrarClienteMain
    Created on : Oct 7, 2014, 11:57:00 PM
    Author     : caioboratto
--%>

<%@page import="macktur.modelo.Cliente"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Formulário de Cadastro</title>
    </head>
    <body>
        <h1>Formulário de Cadastro do Cliente</h1>
        <%
            Cliente cliente = (Cliente) request.getAttribute("cliente");
            String vooSelecionado = (String) request.getAttribute("voo");
            
            String readonly;
            String nome = "";
            String CPF = "";
            String email = "";
            if (cliente != null) {
                request.setAttribute("cliente_existe", "1");
                readonly = "true";
                nome = cliente.getPessoa().getNome();
                CPF = cliente.getPessoa().getCpf();
                email = cliente.getEmail();
                
            } else {
                request.setAttribute("cliente_existe", "0");
                readonly = "false";
            }

        %>
        <h3><%if(cliente!=null){ %>Cliente já cadastrado <% } %></h3>
        <form method="POST" >
            <p>Nome Cliente <input name="nome" type="text" value=<%=nome%> <%if (readonly.equals("true")) { %> readonly=<%}%>> </p>
            <p>CPF <input name="cpf" type="text" value=<%=CPF%> <%if (readonly.equals("true")) { %> readonly=<%}%>></p>
            <p>Email <input name="email" type="text" value=<%=email%> <%if (readonly.equals("true")) { %> readonly=<%}%>></p>
            <p><input type="submit"></p>
        </form>

    </body>
</html>
