package model;
import java.util.ArrayList;

public class Order {
    private ArrayList<Product> products = new ArrayList<>(); 
    private int idProduct;

    public Order(int idProduct) {
        this.idProduct = idProduct;
    } 

    public void addProduct(Product newProduct){
        products.add(newProduct); 
    }
    
    public void showProducts(){
        for (Product product : products) {
            product.showProductInfo();
        }
    }

    public double total(){
        double total= 0; 
        for (Product product : products) {
            total +=  product.getCost(); 
        }
        return total; 
    }
}
