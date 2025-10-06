package model;

public class Product {
    private String nameProduct; 
    private double cost;
    private int idProduct; 

    public Product(int idProduct, String nameProduct, double cost) {
        this.nameProduct = nameProduct;
        this.cost = cost;
        this.idProduct = idProduct; 
    } 

    public void showProductInfo(){
        System.out.println("| Código: "+idProduct+"| Producto: "+nameProduct+"| costo: "+ cost);
    }

    public double getCost() {
        return cost;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    

    
    
}
