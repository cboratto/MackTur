/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package macktur.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import macktur.DAO.VooDAOImpl;
import macktur.modelo.Voo;
import macktur.modelo.Pessoa;
import macktur.modelo.Voo;

/**
 *
 * @author caioboratto
 */
public class VooDAOImpl implements VooDAO {

    protected static String SELECT_VOO_SQL = "select v.idt_voo, \n"
            + "                            v.NAM_VOO,\n"
            + "                            v.NUM_ASSENTOS_UTILIZADOS,\n"
            + "                            vr.NAM_ORIGEM, \n"
            + "                            vr.NAM_DESTINO, \n"
            + "                            vr.DAT_PARTIDA, \n"
            + "                            vr.DAT_CHEGADA,\n"
            + "                            av.NOME_AVIAO,\n"
            + "                            avt.NOME_TIPO,\n"
            + "                            avt.NUM_ASSENTO\n"
            + " from macktur.VOO v \n "
            + " join macktur.VOO_ROTA vr \n "
            + " on v.IDT_VOO=vr.IDT_VOO\n "
            + " join macktur.AVIAO av \n "
            + " on av.IDT_AVIAO = v.IDT_AVIAO\n "
            + " join macktur.AVIAO_TIPO avt \n "
            + " on avt.IDT_AVIAO_TIPO = av.IDT_AVIAO_TIPO\n "
            + " where v.idt_voo = ?\n ";

    @Override
    public void insert(Voo e) {

    }

    @Override
    public void update(Voo e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Voo e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Voo> select() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Voo findVoo(int idt_voo) throws SQLException, ClassNotFoundException {
        Voo voo = new Voo();

        PreparedStatement prepStmt = null;
        ResultSet rs = null;
        //try {
        Connection conn = Conexao.getInstance().getConnection();
        prepStmt = conn.prepareStatement(SELECT_VOO_SQL);
        prepStmt.setInt(1, idt_voo);
        rs = prepStmt.executeQuery();
        while (rs.next()) {

        }
        //} catch (Exception e) {
        //    e.printStackTrace();
        // }
        return voo;
    }

}
