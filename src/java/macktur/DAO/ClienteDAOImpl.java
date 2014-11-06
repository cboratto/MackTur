/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package macktur.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import macktur.modelo.Cliente;
import macktur.modelo.Pessoa;

public class ClienteDAOImpl implements ClienteDAO {

    protected static final String CAMPOS_CLIENTE = "id_cliente, dat_cadastro, email";
    protected static String INSERIR_CLIENTE_SQL = "insert into cliente (idt_cliente, dat_cadastro, email) values (?, ?, ?)";
    protected static String SELECT_ALL_SQL = "select c.idt_cliente, "
            + "c.dat_cadastro, "
            + "c.email,"
            + "p.nam_pessoa,"
            + "p.cpf,"
            + "p.dat_nascimento"
            + " from cliente c "
            + "join pessoa p "
            + "on c.idt_cliente=p.idt_pessoa ";

    protected static String SELECT_CPF_SQL = "select c.idt_cliente, "
            + "c.dat_cadastro, "
            + "c.email,"
            + "p.nam_pessoa,"
            + "p.cpf,"
            + "p.dat_nascimento"
            + " from macktur.cliente c "
            + "join macktur.pessoa p "
            + "on c.idt_cliente=p.idt_pessoa "
            + "where  p.cpf = ?";
    protected static String UPDATE_PESSOA_SQL = "update app.pessoa set nam_pessoa= ?, dat_nascimento=?, cpf=? where idt_pessoa=?";
    protected static String UPDATE_CLIENTE_SQL = "update app.pessoa set nam_pessoa= ?, dat_nascimento=?, cpf=? where idt_pessoa=?";
    protected static String DELETE_SQL = "delete from app.cliente where id=? ";

    protected static final String CAMPOS_PESSOA = "nam_pessoa, dat_nascimento, cpf";
    protected static String INSERIR_PESSOA_SQL = "insert into pessoa (" + CAMPOS_PESSOA + ") values (?, ?, ?)";

    public ClienteDAOImpl() {
    }

    @Override
    public void insert(Cliente cliente) {
        Connection conn = null;
        PreparedStatement prepStmt = null;
        try {
            conn = Conexao.getInstance().getConnection();
            //Inserir a pessoa primeiramente
            prepStmt = conn.prepareStatement(INSERIR_PESSOA_SQL, Statement.RETURN_GENERATED_KEYS);
            prepStmt.setString(1, cliente.getPessoa().getNome());
            prepStmt.setString(2, cliente.getPessoa().getDataNascimento());
            prepStmt.setString(3, cliente.getPessoa().getCpf());
            prepStmt.executeUpdate();
            Integer i = null;
            ResultSet rs = prepStmt.getGeneratedKeys();
            rs.next();
            i = rs.getInt(1);

            //Inserir cliente - repete o mesmo prepStmt
            prepStmt = conn.prepareStatement(INSERIR_CLIENTE_SQL);
            prepStmt.setInt(1, i);
            prepStmt.setString(2, cliente.getDataCadastro());
            prepStmt.setString(3, cliente.getEmail());

            prepStmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Cliente cliente
    ) {

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

        Cliente cliente = new Cliente();

        PreparedStatement prepStmt = null;
        ResultSet rs = null;
        try {
            Connection conn = Conexao.getInstance().getConnection();
            prepStmt = conn.prepareStatement(SELECT_ALL_SQL);

            rs = prepStmt.executeQuery();
            while (rs.next()) {

                Pessoa pessoa = new Pessoa();

                pessoa.setNome(rs.getString(("nam_pessoa")));
                pessoa.setCpf(rs.getString("cpf"));

                cliente.setEmail(rs.getString("email"));
                cliente.setId(rs.getInt("idt_cliente"));

                cliente.setPessoa(pessoa);

                clientes.add(cliente);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return clientes;
    }

    public Cliente findCPF(String cpf) {
        Cliente cliente = new Cliente();

        PreparedStatement prepStmt = null;
        ResultSet rs = null;
        try {
            Connection conn = Conexao.getInstance().getConnection();
            prepStmt = conn.prepareStatement(SELECT_CPF_SQL);
            prepStmt.setString(1, cpf);
            rs = prepStmt.executeQuery();
            while (rs.next()) {
                Pessoa pessoa = new Pessoa();

                pessoa.setNome(rs.getString(("nam_pessoa")));
                pessoa.setCpf(rs.getString("cpf"));
                pessoa.setDataNascimento(rs.getString("dat_nascimento"));

                cliente.setEmail(rs.getString("email"));
                cliente.setDataCadastro(rs.getString("dat_cadastro"));
                cliente.setId(rs.getInt("idt_cliente"));

                cliente.setPessoa(pessoa);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cliente;
    }

}
