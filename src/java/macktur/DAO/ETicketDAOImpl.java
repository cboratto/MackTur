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
import macktur.modelo.Aviao;
import macktur.modelo.Cliente;
import macktur.modelo.ETicket;
import macktur.modelo.Pessoa;
import macktur.modelo.Reserva;
import macktur.modelo.Rota;
import macktur.modelo.Voo;

public class ETicketDAOImpl implements ETicketDAO {

    protected static final String SELECT_ETICKET_COD = "select idt_eticket,"
            + "idt_reserva,"
            + "cod_eticket,"
            + "flg_reserva_confirmada from eticket where cod_eticket=?";

    protected static final String SELECT_ETICKET_COD_FULL = ""
                                + "select e.idt_eticket,\n" +
                                        "e.idt_reserva,\n" +
                                        "e.cod_eticket,\n" +
                                        "e.flg_reserva_confirmada,\n" +
                                        "v.nam_voo, vr.NAM_ORIGEM,\n" +
                                        "vr.NAM_DESTINO,\n" +
                                        "vr.DAT_PARTIDA,\n" +
                                        "vr.DAT_CHEGADA,\n" +
                                        "a.NOME_AVIAO,"
                                        + "p.NAM_PESSOA,\n" +
                                        "p.CPF\n" +
                                    "from eticket e \n" +
                                    "join reserva r \n" +
                                    "on e.IDT_RESERVA = r.IDT_RESERVA\n" +
                                    "join voo v\n" +
                                    "on v.IDT_VOO = r.idt_voo\n" +
                                    "join aviao a \n" +
                                    "on a.IDT_AVIAO = v.IDT_AVIAO\n" +
                                    "join voo_rota vr\n" +
                                    "on vr.IDT_VOO = v.IDT_VOO\n"+ 
                                    " join cliente c " +
                                    " on c.idt_cliente = r.idt_cliente "
                                    + " join pessoa p "
                                    + " on p.idt_pessoa= c.idt_cliente " +
                                    " where e.cod_eticket= ?";

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
            prepStmt = conn.prepareStatement(SELECT_ETICKET_COD_FULL);
            prepStmt.setString(1, codEticket);
            rs = prepStmt.executeQuery();
            while (rs.next()) {
                Reserva reserva = new Reserva();
                Voo voo = new Voo();
                Rota vooRota = new Rota();
                Aviao aviao = new Aviao();
                Cliente cliente = new Cliente();
                Pessoa pessoa = new Pessoa();
                
                eticket.setReserva(reserva);
                //voo
                eticket.getReserva().setVoo(voo);
                eticket.getReserva().getVoo().setAviao(aviao);
                eticket.getReserva().getVoo().setRota(vooRota);
                eticket.getReserva().setId(rs.getInt("idt_reserva"));
                //pessoa
                eticket.getReserva().setCliente(cliente);
                eticket.getReserva().getCliente().setPessoa(pessoa);
                
                eticket.setId(rs.getInt("idt_eticket"));                                
                eticket.setCodReserva(rs.getString("cod_eticket"));
                eticket.setFlgReservaConfirmada(rs.getString("flg_reserva_confirmada"));
                
                voo.setNomeVoo(rs.getString("nam_voo"));
                vooRota.setDataPartida(rs.getString("dat_partida"));
                vooRota.setDateChegada(rs.getString("dat_chegada"));
                vooRota.setOrigem(rs.getString("nam_origem"));
                vooRota.setDestino(rs.getString("nam_destino"));
                
                pessoa.setCpf(rs.getString("cpf"));
                pessoa.setNome(rs.getString("nam_pessoa"));
                
                aviao.setNomeAviao(rs.getString("nome_aviao"));
                

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return eticket;
    }

}
