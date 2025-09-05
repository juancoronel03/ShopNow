package model;

public class Product {
    private String nameProduct; 
    private double cost;
    private int idProduct; 

    public Product(String nameProduct, double cost, int idProduct) {
        this.nameProduct = nameProduct;
        this.cost = cost;
        this.idProduct = idProduct; 
    } 

    public void showProductInfo(){
        System.out.println("| Product name: "+nameProduct+"| Cost: "+ cost+"| ID product: "+idProduct+" |");
    }

    public double getCost() {
        return cost;
    }

    
}
