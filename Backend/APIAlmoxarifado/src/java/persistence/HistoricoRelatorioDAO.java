/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import constructor.HistoricoRelatorio;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author lucas
 */
public class HistoricoRelatorioDAO {
    
    public static HistoricoRelatorio create(HistoricoRelatorio historico) throws SQLException {
        Statement stm
                = Database.createConnection().
                        createStatement();
        String sql
                = "INSERT INTO historico_relatorio (`produto`, `mes`, "
                + "`quantidade`, `valototal`) VALUES ('"
                + historico.getProduto().getId() + "','"
                + historico.getMes() + "','"
                + historico.getQtd() + "','"
                + historico.getValorTotal() + "')";

        stm.execute(sql, Statement.RETURN_GENERATED_KEYS);
        ResultSet rs = stm.getGeneratedKeys();
        rs.next();
        historico.setId(rs.getInt(1));
        return historico;
    }
    
    public static HistoricoRelatorio retreave(int id) throws SQLException {
        Statement stm
                = Database.createConnection().
                        createStatement();
        String sql = "SELECT * FROM historico_relatorio where id = " + id;
        ResultSet rs = stm.executeQuery(sql);
        rs.next();
        return new HistoricoRelatorio(
                id,
                ProdutoDAO.retreave(rs.getInt("produto")),
                rs.getTimestamp("mes"),
                rs.getDouble("quantidade"),
                rs.getDouble("valortotal"));
    }
    
    public static ArrayList<HistoricoRelatorio> retreaveAll() throws SQLException {
        Statement stm
                = Database.createConnection().
                        createStatement();
        String sql = "SELECT * FROM historico_relatorio";
        ResultSet rs = stm.executeQuery(sql);
        ArrayList<HistoricoRelatorio> historico = new ArrayList<>();
        while (rs.next()) {
            historico.add(new HistoricoRelatorio(
                    rs.getInt("id"),
                    ProdutoDAO.retreave(rs.getInt("produto")),
                    rs.getTimestamp("mes"),
                    rs.getDouble("quantidade"),
                    rs.getDouble("valortotal")));
        }
        rs.next();
        return historico;
    }
    
    public static void update(HistoricoRelatorio estoque) throws SQLException {
        Statement stm
                = Database.createConnection().
                        createStatement();
        String sql = "UPDATE historico_relatorio SET "
                + "`produto`='" + estoque.getProduto().getId()
                + "', `mes`= '" + estoque.getMes()
                + "', `quantidade`= '" + estoque.getQtd()
                + "', `valortotal`= '" + estoque.getValorTotal()
                + "' WHERE `id`= "
                + estoque.getId();
        stm.execute(sql);
    }

}
