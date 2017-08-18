/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import constructor.PatrimonioAtual;
import constructor.Produto;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author lucas
 */
public class PatrimonioAtualDAO {
    
    public static PatrimonioAtual create(PatrimonioAtual estoqueBruto) throws SQLException {
        Statement stm
                = Database.createConnection().
                        createStatement();
        String sql
                = "INSERT INTO patrimonio_atual (`produto`, `quantidade`, "
                + "`valortotal`) VALUES ('"
                + estoqueBruto.getProduto().getId() + "','"
                + estoqueBruto.getQtd() + "','"
                + estoqueBruto.getValorTotal() + "')";

        stm.execute(sql, Statement.RETURN_GENERATED_KEYS);
        ResultSet rs = stm.getGeneratedKeys();
        rs.next();
        estoqueBruto.setId(rs.getInt(1));
        return estoqueBruto;
    }
    
    public static PatrimonioAtual retreave(int id) throws SQLException {
        Statement stm
                = Database.createConnection().
                        createStatement();
        String sql = "SELECT * FROM patrimonio_atual where id = " + id;
        ResultSet rs = stm.executeQuery(sql);
        rs.next();
        Produto p = ProdutoDAO.retreave(rs.getInt("produto"));
        return new PatrimonioAtual(
                id,
                p,
                rs.getDouble("quantidade"),
                rs.getDouble("valortotal"));
    }
    
    public static ArrayList<PatrimonioAtual> retreaveAll() throws SQLException {
        Statement stm
                = Database.createConnection().
                        createStatement();
        String sql = "SELECT * FROM patrimonio_atual";
        ResultSet rs = stm.executeQuery(sql);
        ArrayList<PatrimonioAtual> estoque = new ArrayList<>();
        while (rs.next()) {
            Produto p = ProdutoDAO.retreave(rs.getInt("produto"));
            estoque.add(new PatrimonioAtual(
                    rs.getInt("id"),
                    p,
                    rs.getDouble("quantidade"),
                    rs.getDouble("valortotal")));
        }
        rs.next();
        return estoque;
    }
    
    public static void update(PatrimonioAtual estoque) throws SQLException {
        Statement stm
                = Database.createConnection().
                        createStatement();
        String sql = "UPDATE patrimonio_atual SET "
                + "`produto`='" + estoque.getProduto().getId()
                + "', `quantidade`= '" + estoque.getQtd()
                + "', `valortotal`= '" + estoque.getValorTotal()
                + "' WHERE `id`= "
                + estoque.getId();
        stm.execute(sql);
    }
}
