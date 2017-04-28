
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException, Exception {
        
            // TESTES PRODUTO
        
//        Product p = ProductDAO.retreaveByBarcode("2368694135945");
//        System.out.println(p.toString());
        
//        ArrayList<Product> p2 = ProductDAO.retreaveByDescription("usa");       
//        for (Product p : p2) {
//            System.out.println(p);
//        }
      
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
          
            // TESTES CLIENTES
    
//        Client c = new Client("Usuário Anonimo", "", "", "", "", "ANON",
//                "", "", "", "", "", "", "","ANONPASS",
//                new Timestamp(System.currentTimeMillis()), 1);
//        ClientDAO.create(c);

//        System.out.println(ClientDAO.retreave(1));

//        ArrayList<Client> cli = ClientDAO.retreaveAll();
//        for (Client c1 : cli) {
//            System.out.println(c1);
//        }

//        Client c1 = new Client(1, "Lucas", "telefone", "celular", "email", "rg",
//                "cpf", "cidade", "pais", "estado", "rua", "numero", "cidade", 
//                "26d7e2e2-f79a-11e6-85ce-e0db55a5104f", "123", 
//                new Timestamp(System.currentTimeMillis()), 1);
//        ClientDAO.update(c1);
//        System.out.println(ClientDAO.retreave(1));

//        Client c = new Client("Lucas Montanheiro", "3495-3516", "98442-9787", "email", "rg", "044.399.891-44",
//                "cidade", "pais", "estado", "rua", "numero", "cidade", "",
//                "senha", new Timestamp(System.currentTimeMillis()), 0);
//        System.out.println(ClientDAO.create(c));
//        System.out.println(ClientDAO.retreave("044.399.891-44", "senha"));

        // TESTES HISTORY

//        Client c = ClientDAO.retreave(1);
//        History h = new History(c, "eancode", new Timestamp(System.currentTimeMillis()));
//        System.out.println(HistoryDAO.create(h));

//        System.out.println(HistoryDAO.retreave(1));

//        ArrayList<History> hist = HistoryDAO.retreaveAll();
//        for (History h : hist) {
//            System.out.println(h);
//        }
        
        // TESTES POINT

//        Client c = ClientDAO.retreave(1);
//        Point p = new Point(c, -2, new Timestamp(System.currentTimeMillis()), "descrição");
//        System.out.println(PointDAO.create(p));
        
//        System.out.println(PointDAO.retreave(1));
        
//        ArrayList<Point> point = PointDAO.retreaveAll();
//        for (Point p : point) {
//            System.out.println(p);
//        }

        // TESTES EXCHANGE

//        Client c = ClientDAO.retreave(1);
//        Point p = new Point(1, c, -2, new Timestamp(System.currentTimeMillis()), "descrição");
//        Admin a = new Admin(1, "usuario", new Timestamp(System.currentTimeMillis()), 1);
//        Exchange e = new Exchange(100.00, 299.00, p, a);
//        System.out.println(ExchangeDAO.create(e));
        
//        System.out.println(ExchangeDAO.retreave(4));

//        ArrayList<Exchange> exc = ExchangeDAO.retreaveAll();
//        for (Exchange e : exc) {
//            System.out.println(e);
//        }

        // TESTES ADD CREDIT

//        Client c = ClientDAO.retreave(1);
//        Credit cr = new Credit(c, 10.00, "credito pelo sistema de pontos");
//        System.out.println(CreditDAO.create(cr));
        
        // TESTES TOKEN
  
//        Client c = ClientDAO.retreave(1);
//        String token = new Token().Gerate("client", String.valueOf(c.getId()), 2);
//        System.out.println(token);
//        System.out.println(new Token().Verify(token, "client"));        
        

        // TESTES SALE
        
//        ArrayList<Sale> sal = SaleDAO.retreaveAll();
//        for (Sale s : sal) {
//            System.out.println(s);
//        } 
        
    }
    
}
