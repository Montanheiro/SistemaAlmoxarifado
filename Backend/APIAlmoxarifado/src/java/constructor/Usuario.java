package constructor;

import business.Token;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Barbara
 */
public class Usuario {

    private int id;
    private String email;
    private String senha;
    private Servidor servidor;

    public Usuario(int id, String email, Servidor servidor) {
        this.id = id;
        this.email = email;
        this.servidor = servidor;
    }

    public Usuario(String email, Servidor servidor) {
        this.email = email;
        this.servidor = servidor;
    }

    public Usuario(String email, String senha, Servidor servidor) {
        this.email = email;
        try {
            this.senha = new Token().Password(senha);
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.servidor = servidor;
    } 

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Servidor getServidor() {
        return servidor;
    }

    public void setServidor(Servidor servidor) {
        this.servidor = servidor;
    }

    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", email=" + email + ", senha=" + senha + ", servidor=" + servidor + '}';
    }  
    

}
