package presenter;

import java.util.ArrayList;

import model.Product;
import model.ProductLoader;

public class Store {
    private ArrayList<Product> products = new ArrayList<>(); 
    
    public Store(){
        products = ProductLoader.loadProducts("src/Catalog.txt");
    }

    public void showProducts(){
        for (Product product : products) {
            product.showProductInfo();
        }
    }

    public Product searchProductById(int id){
        for (Product product : products) {
            if (product.getIdProduct()==id) {
                return product; 
            }
        }
        return null; 
    }
}
