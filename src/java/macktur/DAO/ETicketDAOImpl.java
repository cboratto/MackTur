/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package macktur.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import static macktur.DAO.ClienteDAOImpl.SELECT_CPF_SQL;
import macktur.modelo.Cliente;
import macktur.modelo.ETicket;
import macktur.modelo.Pessoa;
import macktur.modelo.Reserva;

public class ETicketDAOImpl implements ETicketDAO {

    protected static final String SELECT_ETICKET_COD = "select idt_eticket,"
            + "idt_reserva,"
            + "cod_eticket,"
            + "flg_reserva_confirmada from eticket where cod_eticket=?";

    protected static final String UPDATE_ETICKET = "update eticket "
            + "set flg_reserva_confirmada = ? "
            + "where idt_eticket = ?";

    @Override
    public void insert(ETicket e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(ETicket e) {        
        PreparedStatement prepStmt = null;
        try {
            Connection conn = Conexao.getInstance().getConnection();
            prepStmt = conn.prepareStatement(UPDATE_ETICKET);
            prepStmt.setString(1, e.getFlgReservaConfirmada());
            prepStmt.setInt(2, e.getId());
            prepStmt.execute();

        } catch (Exception x) {
            x.printStackTrace();
        }

    }

    @Override
    public void delete(ETicket e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ETicket> select() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public ETicket findETicket(String codEticket) {

        ETicket eticket = new ETicket();

        PreparedStatement prepStmt = null;
        ResultSet rs = null;
        try {
            Connection conn = Conexao.getInstance().getConnection();
            prepStmt = conn.prepareStatement(SELECT_ETICKET_COD);
            prepStmt.setString(1, codEticket);
            rs = prepStmt.executeQuery();
            while (rs.next()) {
                eticket.setId(rs.getInt("idt_eticket"));
                eticket.setReserva(new Reserva());
                eticket.getReserva().setId(rs.getInt("idt_reserva"));
                eticket.setCodReserva(rs.getString("cod_eticket"));
                eticket.setFlgReservaConfirmada(rs.getString("flg_reserva_confirmada"));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return eticket;
    }

}
