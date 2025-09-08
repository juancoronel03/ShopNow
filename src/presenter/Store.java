package presenter;

import java.util.ArrayList;

import model.Product;

public class Store {
    private ArrayList<Product> products = new ArrayList<>(); 
    
    public Store(){
        createProducts();
    }

    private void createProducts(){
        products.add(new Product("Manzana", 3000, 1));
        products.add(new Product("Jabón", 2000, 2)); 
        products.add(new Product("Arroz", 2500, 3)); 
        products.add(new Product("Jamon", 3500, 4)); 
        products.add(new Product("Queso", 6000, 5)); 
        products.add(new Product("Manzana", 3000, 6));
        products.add(new Product("Jabón", 2000, 7)); 
        products.add(new Product("Arroz", 2500, 8)); 
        products.add(new Product("Jamon", 3500, 9)); 
        products.add(new Product("Queso", 6000, 10)); 
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
