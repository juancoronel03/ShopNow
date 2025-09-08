package model;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Locale;


public class Order {
    private ArrayList<Product> products = new ArrayList<>(); 
    private int idOrder;
    private LocalDateTime orderDate; 
    private static DateTimeFormatter format = DateTimeFormatter.ofPattern("EEEE d MMMM, HH:mm", new Locale("es", "ES"));


    public Order(int idOrder) {
        this.idOrder = idOrder;
        this.orderDate = LocalDateTime.now();   
    } 

    public String calculateLimitDate(){
        return this.orderDate.plusHours(24).format(format); 
    }
    
    public void addProduct(Product newProduct){
        products.add(newProduct); 
    }
    
    public void showProducts(){
        showOrder();
        for (Product p : products) {
            p.showProductInfo();
        }
    }

    public void showOrder(){
        System.out.println("--INFORMACIÓN DEL PEDIDO--\nNo de pedido: "+idOrder+"\nFecha: "+orderDate.format(format));
    }

    public double total(){
        double total= 0; 
        for (Product product : products) {
            total +=  product.getCost(); 
        }
        return total; 
    }
}
