<%-- 
    Document   : CadastrarClienteMain
    Created on : Oct 7, 2014, 11:57:00 PM
    Author     : caioboratto
--%>

<%@page import="java.util.Calendar"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
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
            String dataNascimento="";
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date dat = new Date();            
            String dataCadastro = dateFormat.format(dat);
            
            if (cliente.getPessoa() != null) {
                request.getSession().setAttribute("cliente_existe", "1");
                readonly = "true";
                //Pessoa
                nome = cliente.getPessoa().getNome();
                CPF = cliente.getPessoa().getCpf();
                dataNascimento = cliente.getPessoa().getDataNascimento();
                //Cliente
                email = cliente.getEmail();
                dataCadastro = cliente.getDataCadastro();
            } else {
                request.getSession().setAttribute("cliente_existe", "0");
                readonly = "false";
            }

        %>
        <h3><%if(cliente.getPessoa()!=null){ %>Cliente já cadastrado <% } %></h3>
        <form method="POST" action="/MackTur/FrontControllerServlet?control=CadastrarClienteServlet">
            <h3>Informações de Pessoa</h3>
            
            <p>Nome Cliente <input name="nome" type="text" value=<%=nome%> <%if (readonly.equals("true")) { %> readonly=<%}%>> </p>
            <p>CPF <input name="cpf" type="text" value=<%=CPF%> <%if (readonly.equals("true")) { %> readonly=<%}%>></p>
            <p>Data Nascimento <input name="dat_nasc" type="text" value=<%=dataNascimento%> <%if (readonly.equals("true")) { %> readonly=<%}%>></p>
            <h3>Informações de Cliente</h3>
            <p>Email <input name="email" type="text" value=<%=email%> <%if (readonly.equals("true")) { %> readonly=<%}%>></p>
            <p>Data de Cadastro <input name="dat_cadastro" type="text" value=<%=dataCadastro%> readonly></p>
            <p><input type="submit"></p>
        </form>

    </body>
</html>
