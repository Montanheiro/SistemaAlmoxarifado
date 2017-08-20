package persistence;

import constructor.EmpenhoEntrada;
import constructor.Entrada;
import constructor.EntradaItem;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class EntradaDAO {
    
    private EntradaDAO() {
    }

    public static Entrada create(Entrada entrada) throws SQLException {
        Statement stm
                = Database.createConnection().
                        createStatement();
        String sql
                = "INSERT INTO entradas (`data`, `nf_numero`, `origem`,"
                + "`observacao`) VALUES ('"
                + entrada.getData() + "','"
                + entrada.getNfNumero() + "','"
                + entrada.getOrigem() + "','"
                + entrada.getObservacao() + "')";

        stm.execute(sql, Statement.RETURN_GENERATED_KEYS);
        ResultSet rs = stm.getGeneratedKeys();
        rs.next();
        int key = rs.getInt(1);
        entrada.setId(key);
        
        if(entrada.getItens() != null){           
            for (EntradaItem item : entrada.getItens()) {
                item.setEntradaId(key);
                
                if(entrada.getOrigem() == 2) item.setValor_unitario(0.00);
                
                EntradaItemDAO.create(item);
                
                ProdutoDAO.updateEstoque(item.getProduto(), item.getQtd(), (item.getValor_unitario()));
                
                if(entrada.getOrigem() == 1){
                   EmpenhoEntradaDAO.create(new EmpenhoEntrada(entrada.getEmpenhoId(), key));
                }              
            }
        }
        
        return entrada;
    }

    public static Entrada retreave(int id) throws SQLException {
        Statement stm
                = Database.createConnection().
                        createStatement();
        String sql = "SELECT * FROM entradas where id = " + id;
        ResultSet rs = stm.executeQuery(sql);
        rs.next();
        ArrayList<EntradaItem> itens = EntradaItemDAO.retreaveByEntrada(id);
        return new Entrada(id,
                rs.getTimestamp("data"),
                rs.getString("nf_numero"),
                rs.getInt("origem"),
                rs.getString("observacao"),
                itens);
    }

    public static ArrayList<Entrada> retreaveAll() throws SQLException {
        Statement stm
                = Database.createConnection().
                        createStatement();
        String sql = "SELECT * FROM entradas";
        ResultSet rs = stm.executeQuery(sql);
        ArrayList<Entrada> entrada = new ArrayList<>();
        while (rs.next()) {
            ArrayList<EntradaItem> itens = EntradaItemDAO.retreaveByEntrada(rs.getInt("id"));
            entrada.add(new Entrada(
                    rs.getInt("id"),
                    rs.getTimestamp("data"),
                    rs.getString("nf_numero"),
                    rs.getInt("origem"),
                    rs.getString("observacao"),
                    itens));
        }
        rs.next();
        return entrada;
    }

    public static void delete(Entrada entrada) throws SQLException {
        Statement stm
                = Database.createConnection().
                        createStatement();
        String sql = "DELETE FROM entradas WHERE `id`="
                + entrada.getId();
        stm.execute(sql);
    }

    public static void update(Entrada entrada) throws SQLException {
        Statement stm
                = Database.createConnection().
                        createStatement();
        String sql = "UPDATE entradas SET "
                + "`observacao` = '" + entrada.getObservacao()
                + "' WHERE `id` = " + entrada.getId();
        stm.execute(sql);
        
//        for (EntradaItem itens : entrada.getItens()) {
//            if (itens.getId() != 0) {
//                EntradaItemDAO.update(itens);
//            } else {
//                itens.setEntradaId(entrada.getId());
//                EntradaItemDAO.create(itens);
//                
//                if(entrada.getOrigem() == 1){
//                   EmpenhoEntradaDAO.create(new EmpenhoEntrada(entrada.getEmpenhoId(), entrada.getId()));
//                }
//            }
//        }
    }
}
