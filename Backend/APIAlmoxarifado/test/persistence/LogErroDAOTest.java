/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import constructor.LogErro;
import constructor.Servidor;
import constructor.Setor;
import constructor.Usuario;
import java.sql.Timestamp;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

/**
 *
 * @author lucas
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LogErroDAOTest {
    
    public LogErroDAOTest() {
    }
    
    @Test
    public void testCreate() throws Exception {       
        System.out.println("create");
        
        Setor setor = SetorDAO.create(new Setor("Direção de Ensino", "DIREN"));
        Servidor servidor = ServidorDAO.create(new Servidor(setor, "Jucelino", "2858935", "Presidente"));
        
        Usuario user = UsuarioDAO.create(new Usuario("teste1@unitario.com", "senhaSegura", servidor, 1, 1));
        
        LogErro log = new LogErro(user, new Timestamp(System.currentTimeMillis()), "buguei");
        LogErro expResult = log;
        LogErro result = LogErroDAO.create(log);
        assertEquals(expResult, result);
    }

    @Test
    public void testRetreave() throws Exception {
        System.out.println("retreave");
        LogErroDAO.retreave(1);
    }

    @Test
    public void testRetreaveAll() throws Exception {
        System.out.println("retreaveAll");
        LogErroDAO.retreaveAll();
    }

}
