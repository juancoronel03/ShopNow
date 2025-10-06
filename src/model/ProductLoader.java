package model;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class ProductLoader {
    public static ArrayList<Product> loadProducts(String pathFile){
        ArrayList<Product> products = new ArrayList<>(); 
        
        try (BufferedReader br = new BufferedReader(new FileReader(pathFile))) {
            String line; 
            while ((line = br.readLine())!= null) {
                String[] values = line.split(","); 
                int id = Integer.parseInt(values[0]) ; 
                String name = values[1]; 
                double cost = Double.parseDouble(values[2]); 
                products.add(new Product(id, name, cost)); 
            }
            
        } catch (Exception e) {
            System.out.println("Error leyendo el archivo: "+e.getMessage());
        }
        return products; 
    }
}
