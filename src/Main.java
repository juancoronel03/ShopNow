import model.Client;
import model.Order;
import model.Product;

public class Main {
    public static void main(String[] args)  {
        Client client = new Client("Juan José Argüello Alvarado", "juan.arguello03@uptc.edu.co"); 
        client.showInfo();
        Product product1 = new Product("Apple", 3000, 1234); 
        Product product2 = new Product("Soap", 2000, 2345); 
        Product product3 = new Product("Rice", 2500, 1345); 
        Product product4 = new Product("Jamon", 3500, 4321); 
        Product product5 = new Product("Queso", 6000, 6543); 
        product1.showProductInfo();
        Order order = new Order(1234); 
        order.addProduct(product1);  
        order.addProduct(product2);
        order.addProduct(product3);  
        order.addProduct(product4);  
        order.addProduct(product5);
        System.out.println(" ");
        order.showProducts();
        System.out.println("Total Cost: "+order.total());
        
    }
}
