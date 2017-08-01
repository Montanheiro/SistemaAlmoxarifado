package persistence;

import constructor.Servidor;
import constructor.Setor;
import constructor.Usuario;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

/**
 *
 * @author lucas
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UsuarioDAOTest {
    
    public UsuarioDAOTest() {
    }
    
    @Test
    public void testCreate() throws Exception {
        System.out.println("create");
        Setor setor = SetorDAO.create(new Setor("Direção de Ensino", "DIREN"));
        Servidor servidor = ServidorDAO.create(new Servidor(setor, "Jucelino", "2858935", "Presidente"));
        
        Usuario obj = new Usuario("teste1@unitario.com", "senhaSegura", servidor, 1, 1);
        Usuario expResult = obj;
        Usuario result = UsuarioDAO.create(obj);
        assertEquals(expResult, result);
    }

    @Test
    public void testRetreave() throws Exception {
        System.out.println("retreave");
        UsuarioDAO.retreave(1);
    }

    @Test
    public void testRetreaveAll() throws Exception {
        System.out.println("retreaveAll");
        UsuarioDAO.retreaveAll();
    }

    @Test
    public void testUpdate() throws Exception {
        System.out.println("update");
        Setor setor = SetorDAO.create(new Setor("Direção de Ensino", "DIREN"));
        Servidor servidor = ServidorDAO.create(new Servidor(setor, "Jucelino", "2858935", "Presidente"));
        
        Usuario obj1 = new Usuario("teste2@unitario.com", "539825983", servidor, 0, 1);
        UsuarioDAO.update(obj1);
        Usuario obj2 = new Usuario("teste3@unitario.com", "#%#&$&4&$#5&", servidor, 1, 0);
        UsuarioDAO.update(obj2);
        UsuarioDAO.retreave(1);        
    }
    
    @Test
    public void testDelete() throws Exception {
        System.out.println("delete");  
        Setor setor = SetorDAO.create(new Setor("Direção de Ensino", "DIREN"));
        Servidor servidor = ServidorDAO.create(new Servidor(setor, "Jucelino", "2858935", "Presidente"));
        
        Usuario obj = new Usuario("teste4@unitario.com", "doagsisi@%#2", servidor, 0, 0);
        UsuarioDAO.create(obj);
        UsuarioDAO.delete(obj);
    }
    
    @Test
    public void testRetreaveLogin() throws Exception {
        System.out.println("retreaveLogin");
        String email = "teste1@unitario.com";
        String senha = "senhaSegura";
        UsuarioDAO.retreaveLogin(email, senha);
    }

    @Test
    public void testUpdatePassword() throws Exception {
        System.out.println("updatePassword");
        Setor setor = SetorDAO.create(new Setor("Direção de Ensino", "DIREN"));
        Servidor servidor = ServidorDAO.create(new Servidor(setor, "Jucelino", "2858935", "Presidente"));
        
        Usuario u = UsuarioDAO.create(new Usuario("teste1@unitario.com", "senhaSegura", servidor, 1, 1));
        u.setSenha("senha2#%#dsf");
        UsuarioDAO.updatePassword(u);
    }
}
