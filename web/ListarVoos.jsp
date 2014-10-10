<%-- 
    Document   : ListarVoos
    Created on : Oct 6, 2014, 9:16:32 PM
    Author     : caioboratto
--%>

<%@page import="java.util.List"%>
<%@page import="macktur.modelo.Voo"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ListarVoos</title>
    </head>
    <body>
        <h1>Lista de Voos</h1>
        <form method="POST" action="/MackTur/SaveSelectedFlightServlet">
            <table border="1">
                <tr><th>Nome Voo</th><th>Origem</th><th>Destino</th><th>Data Partida</th><th>Data Chegada</th>
                    <th>Nome Aviao</th><th>Assentos Disponiveis</th></tr>
                </tr>
                        <%
                            List<Voo> voos = (List<Voo>) request.getAttribute("voos");
                            for (Voo v : voos) {
                                String origem = v.getRota().getOrigem();
                                String destino = v.getRota().getDestino();
                                String dataOrigem = v.getRota().getDataPartida();
                                String dataChegada = v.getRota().getDateChegada();
                                int idt = v.getIdentificadorVoo();
                                
                               
                        %>
                <tr>
                    <td><%=v.getNomeVoo()%></td>
                    <td><%=origem%></td>
                    <td><%=destino%></td>
                    <td><%=dataOrigem%></td>
                    <td><%=dataChegada%></td>
                    <td><%=v.getAviao().getNomeAviao()%></td>
                    <td><%=v.getAviao().getAviaoTipo().getNumAssentos()-v.getNumAssentosUtilizados()%></td>
                    <td><input type="radio" name="voo" value=<%=idt%>></td>
                    </tr>
                <%
                    }
                %>
            </table>

            <p><input type="submit" name="Enviar"></p>
        </form>
        <p><a href="/MackTur"> Voltar a pagina anterior </a></p>
    </body>
</html>
