package model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Locale;

public class Order {

    // Lista de productos en el pedido
    private ArrayList<Product> products = new ArrayList<>(); 

    // Identificador único del pedido
    private int idOrder;

    // Fecha y hora de creación del pedido
    private LocalDateTime orderDate; 

    // Método de pago usado en el pedido
    private PaymentMethod paymentMethod;

    // Formato de fecha personalizado en español
    private static DateTimeFormatter format = 
        DateTimeFormatter.ofPattern("EEEE d 'de' MMMM, HH:mm", new Locale("es", "ES"));

    // --- CONSTRUCTORES ---
    public Order(int idOrder, PaymentMethod paymentMethod) {
        this.idOrder = idOrder;
        this.paymentMethod = paymentMethod;
        this.orderDate = LocalDateTime.now();   
    } 

    // Constructor cuando el método de pago se selecciona después
    public Order(int idOrder) {
        this.idOrder = idOrder;
        this.orderDate = LocalDateTime.now();
    }

    // --- MÉTODOS PRINCIPALES ---

    /**
     * Procesa el pedido con el método de pago seleccionado.
     * Si no hay método de pago, muestra un mensaje de error.
     */
    public void proccesOrder() {
        System.out.println("\nProcesando pago...");
        if (paymentMethod == null) {
            System.out.println(" No se ha seleccionado un método de pago.");
            return;
        }

        paymentMethod.PaymentProcess();
        System.out.println(" Pedido #" + idOrder + " completado correctamente el " 
                           + orderDate.format(format));
        System.out.println("Monto total: $" + total());
    }

    // --- SETTERS ---
    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    // --- FUNCIONES DE PEDIDO ---

    /**
     * Calcula la fecha límite de pago (24 horas después del pedido).
     */
    public String calculateLimitDate() {
        return this.orderDate.plusHours(24).format(format); 
    }
    
    /**
     * Agrega un producto al pedido.
     */
    public void addProduct(Product newProduct) {
        products.add(newProduct); 
    }

    /**
     * Muestra todos los productos agregados al pedido.
     */
    public void showProducts() {
        if (products.isEmpty()) {
            System.out.println("No hay productos en el pedido.");
            return;
        }

        System.out.println("-- PRODUCTOS EN EL PEDIDO --");
        for (Product p : products) {
            p.showProductInfo();
        }
    }

    /**
     * Muestra toda la información del pedido (fecha, productos, total, etc.).
     */
    public void showOrder() {
        System.out.println("\n-- INFORMACIÓN DEL PEDIDO --");
        System.out.println("Número de pedido: " + idOrder);
        System.out.println("Fecha: " + orderDate.format(format));
        showProducts();
        showTotal();
        System.out.println("Fecha límite de pago: " + calculateLimitDate());
    }

    /**
     * Muestra el costo total del pedido.
     */
    public void showTotal() {
        System.out.println("Costo total: $" + total());
    }

    /**
     * Calcula el total de todos los productos agregados.
     */
    public double total() {
        double total = 0; 
        for (Product product : products) {
            total += product.getCost(); 
        }
        return total; 
    }
}

