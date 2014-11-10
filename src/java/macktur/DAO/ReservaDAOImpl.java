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
import java.util.List;
import static macktur.DAO.ClienteDAOImpl.INSERIR_PESSOA_SQL;
import macktur.modelo.ETicket;
import macktur.modelo.Reserva;

public class ReservaDAOImpl implements ReservaDAO {

    protected static String INSERT_RESERVA_SQL = "insert into reserva (idt_voo, idt_cliente) values (?, ?)";
    protected static String INSERT_ETICKET_SQL = "insert into eticket (idt_reserva, cod_eticket, flg_reserva_confirmada) values ( ? ,?, ? )";

    public ETicket insertEticket(Reserva r) {
        Connection conn = null;
        PreparedStatement prepStmt = null;
        ETicket eticket = new ETicket();
        try {
            conn = Conexao.getInstance().getConnection();
            //Inserir a pessoa primeiramente

            prepStmt = conn.prepareStatement(INSERT_RESERVA_SQL, Statement.RETURN_GENERATED_KEYS);
            prepStmt.setInt(1, r.getVoo().getId());
            prepStmt.setInt(2, r.getCliente().getId());

            prepStmt.executeUpdate();
            Integer i = null;
            ResultSet rs = prepStmt.getGeneratedKeys();
            if (rs != null) {
                rs.next();
                i = rs.getInt(1);

                //Inserir cliente - repete o mesmo prepStmt
                prepStmt = conn.prepareStatement(INSERT_ETICKET_SQL, Statement.RETURN_GENERATED_KEYS);
                prepStmt.setInt(1, i);
                prepStmt.setString(2, "MT0000" + i);
                prepStmt.setString(3, "N");
                
                prepStmt.executeUpdate();

                eticket.setCodReserva("MT0000" + i);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return eticket;
    }

    @Override
    public void update(Reserva r) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Reserva r) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Reserva> select() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void insert(Reserva e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
