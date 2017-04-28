package persistence;

//TUTORIAL: http://www.devmedia.com.br/criando-uma-conexao-java-mysql-server/16753

import java.sql.Connection; 
import java.sql.DriverManager; 
import java.sql.SQLException;
import business.Parameters;
 
//Início da classe de conexão//
public class Database { 
    
    public static String status = "Não conectou...";
 
    //Método Construtor da Classe//
        public Database() {
    }
 
    //Método de Conexão//
    public static java.sql.Connection createConnection() {
        Connection connection;          //atributo do tipo Connection
        try {
            // Carregando o JDBC Driver padrão                        
            Class.forName(Parameters.DRIVER1);

            connection = DriverManager.getConnection(Parameters.URL1, Parameters.USR1, Parameters.PWD1);

            //Testa sua conexão//  
            if (connection != null) {
                status = ("STATUS--->Conectado com sucesso!");
            } 
            else {
                status = ("STATUS--->Não foi possivel realizar conexão");
            }return connection;

        } catch (ClassNotFoundException e) {  //Driver não encontrado
            System.out.println("O driver expecificado nao foi encontrado.");
            return null;
        } catch (SQLException e) {
            //Não conseguindo se conectar ao banco
            System.out.println("Nao foi possivel conectar ao Banco de Dados.");
            return null;
        }
    }
 
    //Método que retorna o status da sua conexão//
    public static String statusConection() {
        return status;
    }

   //Método que fecha sua conexão//
    public static boolean FecharConexao() {
 
        try {
            Database.createConnection().close(); 
            return true;
 
        } catch (SQLException e) {
            return false;
        }
    }
  
    //Método que reinicia sua conexão//
    public static java.sql.Connection ReiniciarConexao() {
        FecharConexao();
        return Database.createConnection();
    }
}