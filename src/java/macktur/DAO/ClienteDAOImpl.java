/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package macktur.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import macktur.modelo.Cliente;


public class ClienteDAOImpl implements ClienteDAO {

  protected static final String CAMPOS = "id, nome, logradouro, numero";
    protected static String INSERIR_SQL = "insert into app.cliente (" + CAMPOS + ") values (?, ?, ?)";
    protected static String SELECT_ALL_SQL = "select " + CAMPOS + " from app.cliente";
    protected static String UPDATE_SQL = "update app.cliente set nome= ?, logradouro=?, numero=? where id=?";
    protected static String DELETE_SQL = "delete from app.cliente where id=? ";

    public ClienteDAOImpl() {
    }

    @Override
    public void insert(Cliente cliente) {
        Connection conn = null;
        PreparedStatement prepStmt = null;
        try {
            conn = Conexao.getInstance().getConnection();
            prepStmt = conn.prepareStatement(INSERIR_SQL);
            prepStmt.setString(1, cliente.getNome());
            prepStmt.setString(2, cliente.getLogradouro());
            prepStmt.setInt(3, cliente.getNumero());
            prepStmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Cliente cliente
    ) {
        Connection conn = null;
        PreparedStatement prepStmt = null;
        try {
            conn = Conexao.getInstance().getConnection();
            prepStmt = conn.prepareStatement(UPDATE_SQL);
            prepStmt.setString(1, cliente.getNome());
            prepStmt.setString(2, cliente.getLogradouro());
            prepStmt.setInt(3, cliente.getNumero());
            prepStmt.setLong(4, cliente.getId());
            prepStmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Cliente cliente
    ) {
        Connection conn = null;
        PreparedStatement prepStmt = null;
        try {
            conn = Conexao.getInstance().getConnection();
            prepStmt = conn.prepareStatement(DELETE_SQL);
            prepStmt.setLong(1, cliente.getId());
            prepStmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Cliente> select() {
        List<Cliente> clientes = new ArrayList<Cliente>();

        Cliente cliente = null;
        PreparedStatement prepStmt = null;
        ResultSet rs = null;
        try {
            Connection conn = Conexao.getInstance().getConnection();
            prepStmt = conn.prepareStatement(SELECT_ALL_SQL);
            rs = prepStmt.executeQuery();
            while (rs.next()) {
                cliente = new Cliente();

                cliente.setId(rs.getLong("id"));
                cliente.setNome(rs.getString("nome"));
                cliente.setLogradouro(rs.getString("logradouro"));
                cliente.setNumero(rs.getInt("numero"));

                clientes.add(cliente);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return clientes;
    }
    
}
