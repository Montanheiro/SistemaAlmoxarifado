
import constructor.Servidor;
import constructor.Setor;
import constructor.Usuario;
import java.sql.SQLException;
import persistence.ServidorDAO;
import persistence.SetorDAO;
import persistence.UsuarioDAO;

public class Main {

    public static void main(String[] args) throws SQLException, Exception {
        
      
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
//        Setor setor = SetorDAO.retreave(1);
//        System.out.println(setor);
//        
//        Servidor servidor = new Servidor(setor, "Lucas", "27425825", "Aluno");
//        System.out.println(ServidorDAO.create(servidor));
//        Servidor servidor = ServidorDAO.retreave(1);
//        System.out.println(servidor);
//        
//        Usuario usuario = new Usuario("lucas@if.br", "123", servidor, 1, 0);
//        System.out.println(UsuarioDAO.create(usuario));
//        usuario = UsuarioDAO.retreave(1);
//        System.out.println(usuario);
        
        Usuario usuario = UsuarioDAO.retreaveLogin("lucas@if.br", "123");
        System.out.println(usuario);
    }
    
}
