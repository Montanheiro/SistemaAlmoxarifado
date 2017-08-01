package persistence;

import constructor.Aluno;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Barbara
 */
public class AlunoDAO {

    private AlunoDAO() {
    }

    public static Aluno create(Aluno aluno) throws SQLException {
        Statement stm
                = Database.createConnection().
                        createStatement();
        String sql
                = "INSERT INTO alunos (`nome`, `matricula`) VALUES ('"
                + aluno.getNome() + "','"
                + aluno.getMatricula() + "')";

        stm.execute(sql, Statement.RETURN_GENERATED_KEYS);
        ResultSet rs = stm.getGeneratedKeys();
        rs.next();
        int key = rs.getInt(1);
        aluno.setId(key);
        return aluno;
    }

    public static Aluno retreave(int id) throws SQLException {
        Statement stm
                = Database.createConnection().
                        createStatement();
        String sql = "SELECT * FROM alunos where id =" + id;
        ResultSet rs = stm.executeQuery(sql);
        rs.next();
        return new Aluno(id,
                rs.getString("nome"),
                rs.getString("matricula"));

    }

    public static ArrayList<Aluno> retreaveAll() throws SQLException {
        Statement stm
                = Database.createConnection().
                        createStatement();
        String sql = "SELECT * FROM alunos";
        ResultSet rs = stm.executeQuery(sql);
        ArrayList<Aluno> aluno = new ArrayList<>();
        while (rs.next()) {
            aluno.add(new Aluno(
                    rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getString("matricula")));
        }
        rs.next();
        return aluno;
    }

    public static void delete(Aluno aluno) throws SQLException {
        Statement stm
                = Database.createConnection().
                        createStatement();
        String sql = "DELETE FROM alunos WHERE `id`="
                + aluno.getId();
        stm.execute(sql);
    }

    public static void update(Aluno aluno) throws SQLException {
        Statement stm
                = Database.createConnection().
                        createStatement();
        String sql = "UPDATE alunos SET "
                + "`nome`='" + aluno.getNome()
                + "', `matricula`= '" + aluno.getMatricula()
                + "' WHERE `id`= "
                + aluno.getId();
        stm.execute(sql);
    }

}
