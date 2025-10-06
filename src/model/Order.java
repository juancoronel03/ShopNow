package model;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Locale;


public class Order {
    private ArrayList<Product> products = new ArrayList<>(); 
    private int idOrder;
    private LocalDateTime orderDate; 
    private PaymentMethod paymentMethod;
    private static DateTimeFormatter format = DateTimeFormatter.ofPattern("EEEE d MMMM, HH:mm", new Locale("es", "ES"));

    public void proccesOrder(){
        System.out.println("Procesando pago...");
        if (paymentMethod == null) {
            System.out.println("No se ha seleccionado un método de pago.");
            return;
        }
        paymentMethod.PaymentProcess();
    }


    public Order(int idOrder, PaymentMethod paymentMethod) {
        this.idOrder = idOrder;
        this.paymentMethod = paymentMethod;
        this.orderDate = LocalDateTime.now();   
    } 

    // constructor when payment is selected later
    public Order(int idOrder) {
        this.idOrder = idOrder;
        this.orderDate = LocalDateTime.now();
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String calculateLimitDate(){
        return this.orderDate.plusHours(24).format(format); 
    }
    
    public void addProduct(Product newProduct){
        products.add(newProduct); 
    }
    
    public void showProducts(){
        for (Product p : products) {
            p.showProductInfo();
        }
    }

    public void showOrder(){
        System.out.println("--INFORMACIÓN DEL PEDIDO--\nNo de pedido: "+idOrder+"\nFecha: "+orderDate.format(format));
        showProducts();
        showTotal();
        System.out.println("Fecha límite de pago: "+calculateLimitDate());
    }
    
    public void showTotal(){
        System.out.println("Costo total: $"+total());
    }


    public double total(){
        double total= 0; 
        for (Product product : products) {
            total +=  product.getCost(); 
        }
        return total; 
    }
}
