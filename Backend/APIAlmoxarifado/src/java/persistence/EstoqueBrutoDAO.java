/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import constructor.EstoqueBruto;
import constructor.Produto;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author lucas
 */
public class EstoqueBrutoDAO {
    
    public static EstoqueBruto create(EstoqueBruto estoqueBruto) throws SQLException {
        Statement stm
                = Database.createConnection().
                        createStatement();
        String sql
                = "INSERT INTO estoque_bruto (`produto`, `quantidade`, "
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
    
    public static EstoqueBruto retreave(int id) throws SQLException {
        Statement stm
                = Database.createConnection().
                        createStatement();
        String sql = "SELECT * FROM estoque_bruto where id = " + id;
        ResultSet rs = stm.executeQuery(sql);
        rs.next();
        Produto p = ProdutoDAO.retreave(rs.getInt("produto"));
        return new EstoqueBruto(
                id,
                p,
                rs.getDouble("quantidade"),
                rs.getDouble("valortotal"));
    }
    
    public static ArrayList<EstoqueBruto> retreaveAll() throws SQLException {
        Statement stm
                = Database.createConnection().
                        createStatement();
        String sql = "SELECT * FROM estoque_bruto";
        ResultSet rs = stm.executeQuery(sql);
        ArrayList<EstoqueBruto> estoque = new ArrayList<>();
        while (rs.next()) {
            Produto p = ProdutoDAO.retreave(rs.getInt("produto"));
            estoque.add(new EstoqueBruto(
                    rs.getInt("id"),
                    p,
                    rs.getDouble("quantidade"),
                    rs.getDouble("valortotal")));
        }
        rs.next();
        return estoque;
    }
    
    public static void update(EstoqueBruto estoque) throws SQLException {
        Statement stm
                = Database.createConnection().
                        createStatement();
        String sql = "UPDATE estoque_bruto SET "
                + "`produto`='" + estoque.getProduto().getId()
                + "', `quantidade`= '" + estoque.getQtd()
                + "', `valortotal`= '" + estoque.getValorTotal()
                + "' WHERE `id`= "
                + estoque.getId();
        stm.execute(sql);
    }
}
