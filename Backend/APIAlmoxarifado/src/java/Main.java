
import constructor.Aluno;
import constructor.LogErro;
import constructor.Servidor;
import constructor.Setor;
import constructor.Usuario;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.Date;
import java.sql.SQLException;
import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.core.Response;
import persistence.AlunoDAO;
import persistence.LogErroDAO;
import persistence.ServidorDAO;
import persistence.SetorDAO;
import persistence.UsuarioDAO;

public class Main {

    public static void main(String[] args) throws SQLException, NoSuchAlgorithmException, UnsupportedEncodingException{
        
             
            // TESTES ADMIN

//        Admin a = new Admin("lucas","lucas123", new Timestamp(System.currentTimeMillis()), 1, 1);
//        System.out.println(AdminDAO.create(a));
          
//        Admin a2 = AdminDAO.retreave(1);
//        System.out.println(a2);

//        ArrayList<Admin> adm = AdminDAO.retreaveAll();
//        for (Admin a : adm) {
//            System.out.println(a);
//        }        
        
//        Admin a = new Admin(2, "usuario", new Timestamp(System.currentTimeMillis()), 1, 1);
//        AdminDAO.update(a);
//        Admin a2 = AdminDAO.retreave(1);
//        System.out.println(a2);

//        AdminDAO.delete(a);

//        Admin a = new Admin(1, "usuario", "senha1234", new Timestamp(System.currentTimeMillis()), 1);
//        AdminDAO.updatePassword(a);

//        System.out.println(AdminDAO.retreave("lucas", "lucas123")); 
          
       
        // TESTES TOKEN
  
//        Client c = ClientDAO.retreave(1);
//        String token = new Token().Gerate("client", String.valueOf(c.getId()), 2);
//        System.out.println(token);
//        System.out.println(new Token().Verify(token, "client"));  
//        System.out.println("birll");



        // ----------------------------------------------------
        // ----------------------------------------------------
        // ----------------------------------------------------

        // TESTES ALMOXARIFADO
        
        // ----------------------------------------------------
        // ----------------------------------------------------
        // ----------------------------------------------------
        
//        Setor setor = new Setor("Alunos Morrinhos", "AMHOS");
//        System.out.println(SetorDAO.create(setor));
//        Setor setor2 = SetorDAO.retreave(1);
//        System.out.println(setor2);
//        
//        Servidor servidor = new Servidor(setor, "Lucas", "27425825", "Aluno");
//        System.out.println(ServidorDAO.create(servidor));
//        servidor = ServidorDAO.retreave(1);
//        System.out.println(servidor);
////        
//        Usuario usuario = new Usuario("lucas@if.br", "123", servidor, 1, 0);
//        System.out.println(UsuarioDAO.create(usuario));
//        usuario = UsuarioDAO.retreave(1);
//        System.out.println(usuario);
//        
//       Usuario usuarioLogin = UsuarioDAO.retreaveLogin("lucas@if.br", "123");
//       System.out.println(usuarioLogin);
//       
//        try {
//            throw new Exception("erro abc");
//        } catch (Exception ex) {
//            LogErro log = new LogErro(usuarioLogin, ex.getMessage());
//            LogErroDAO.create(log);
//        }
       
//        System.out.println(LogErroDAO.retreave(1));

        ArrayList<LogErro> log = LogErroDAO.retreaveAll();
        for (LogErro l : log) {
            System.out.println(l);
        }

    }
    
}
