/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package macktur.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import macktur.modelo.Aviao;
import macktur.modelo.AviaoTipo;
import macktur.modelo.Rota;
import macktur.modelo.Voo;

/**
 *
 * @author caioboratto
 */
public class VooBD {

    public VooBD() {
    }

    public List<Voo> buscaVoos(String origem, String destino, String datainicio) throws SQLException {
        List<Voo> voos = new ArrayList<Voo>();
        try {
            //carrega o driver para acessar a base de dadods
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            String dbUrl = "jdbc:derby://localhost:1527/mack01";
            Connection connection = DriverManager.getConnection(dbUrl, "macktur", "macktur");

            String query = "select v.idt_voo, \n"
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
                    + " where '" + datainicio + "' between vr.DAT_PARTIDA and vr.NAM_DESTINO \n "
                    + " and  vr.nam_origem= ? \n "
                    + " and  vr.nam_destino= ? \n "
                    + " and  avt.NUM_ASSENTO-v.NUM_ASSENTOS_UTILIZADOS > 0";

            PreparedStatement select = connection.prepareStatement(query);

            select.setString(1, origem);
            select.setString(2, destino);

            ResultSet rs = select.executeQuery();

            while (rs.next()) {
                Voo v = new Voo();
                Rota r = new Rota();

                //Cria o TIPO AVIAO
                AviaoTipo aviaoTipo = new AviaoTipo(1, rs.getString("nome_tipo"), rs.getInt("num_assento"));
                //Cria o AVIAO
                Aviao aviao = new Aviao(0,null,rs.getString("nome_aviao"));
                //Associa
                aviao.setAviaoTipo(aviaoTipo);
                
                v.setNomeVoo(rs.getString("nam_voo"));
                v.setIdentificadorVoo(rs.getInt("idt_voo"));
                v.setNumAssentosUtilizados(rs.getInt("num_assentos_utilizados"));

                r.setOrigem(rs.getString("nam_origem"));
                r.setDestino(rs.getString("nam_destino"));
                r.setDataPartida(rs.getString("dat_partida"));
                r.setDateChegada(rs.getString("dat_chegada"));
                
                
                v.setRota(r);
                v.setAviao(aviao);
                //coloca na lista
                voos.add(v);

            }
        } catch (ClassNotFoundException e) {
            System.err.println("erro carregando driver: " + e);
        } 
        return voos;
    }

    public List<Voo> buscaVoos(String idt) {
        List<Voo> voos = new ArrayList<Voo>();
        try {
            //carrega o driver para acessar a base de dadods
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            String dbUrl = "jdbc:derby://localhost:1527/mack01";
            Connection connection = DriverManager.getConnection(dbUrl, "macktur", "macktur");

            String query = "select v.idt_voo,\n "
                    + "       v.NAM_VOO, \n"
                    + "       vr.NAM_ORIGEM, \n"
                    + "       vr.NAM_DESTINO, \n"
                    + "       vr.DAT_PARTIDA, \n"
                    + "       vr.DAT_CHEGADA \n"
                    + "from macktur.VOO v \n"
                    + "join macktur.VOO_ROTA vr \n"
                    + "on v.IDT_VOO=vr.IDT_VOO\n"
                    + "where vr.idt_voo =?";

            PreparedStatement select = connection.prepareStatement(query);

            select.setString(1, idt);

            ResultSet rs = select.executeQuery();

            while (rs.next()) {
                Voo v = new Voo();
                Rota r = new Rota();

                v.setNomeVoo(rs.getString("nam_voo"));
                v.setIdentificadorVoo(rs.getInt("idt_voo"));

                r.setOrigem(rs.getString("nam_origem"));
                r.setDestino(rs.getString("nam_destino"));
                r.setDataPartida(rs.getString("dat_partida"));
                r.setDateChegada(rs.getString("dat_chegada"));

                v.setRota(r);

                voos.add(v);

            }
        } catch (ClassNotFoundException e) {
            System.err.println("erro carregando driver: " + e);
        } catch (SQLException e) {
            System.err.println("erro SQL: " + e);
        }
        return voos;
    }
}
