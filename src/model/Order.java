package model;
import java.util.ArrayList;

public class Order {
    private ArrayList<Product> products = new ArrayList<>(); 
    private int idOrder;

    public Order(int idOrder) {
        this.idOrder = idOrder;
    } 

    public void addProduct(Product newProduct){
        products.add(newProduct); 
    }
    
    public void showProducts(){
        showOrder();
        for (Product product : products) {
            product.showProductInfo();
        }
    }

    public void showOrder(){
        System.out.println("Id Order: "+idOrder);
    }

    public double total(){
        double total= 0; 
        for (Product product : products) {
            total +=  product.getCost(); 
        }
        return total; 
    }
}
