package macktur.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import macktur.modelo.Cliente;
import macktur.modelo.Pessoa;
import macktur.modelo.Rota;
import macktur.modelo.Voo;

public class ClienteBD {

    public ClienteBD() {
    }

    public Cliente buscaCliente(String cpf) {
        Cliente c = null;
        try {
            //carrega o driver para acessar a base de dadods
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            String dbUrl = "jdbc:derby://localhost:1527/mack01";
            Connection connection = DriverManager.getConnection(dbUrl, "macktur", "macktur");

            String query = "select c.IDT_CLIENTE,"
                    + "p.NAM_PESSOA, "
                    + "p.CPF, "
                    + "c.email "
                    + "from pessoa p "
                    + "join cliente c "
                    + "on p.IDT_PESSOA=c.idt_cliente where p.cpf = ?";

            PreparedStatement select = connection.prepareStatement(query);

            select.setString(1, cpf);

            ResultSet rs = select.executeQuery();

            while (rs.next()) {

                Pessoa p = new Pessoa(rs.getString("nam_pessoa"), rs.getInt("idt_cliente"), rs.getString("cpf"));
                c = new Cliente(p, rs.getString("email"));

            }
        } catch (ClassNotFoundException e) {
            System.err.println("erro carregando driver: " + e);
        } catch (SQLException e) {
            System.err.println("erro SQL: " + e);
        }
        return c;
    }
}
