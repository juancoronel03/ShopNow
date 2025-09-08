import java.util.Scanner;

import model.Client;
import model.Order;
import model.Product;
import presenter.Store;

public class Main { // MÉTODO PRINCIPAL

    private static Store st = new Store();

    public static void main(String[] args) {
        // Crear cliente:
        Client client = new Client("Juan José Argüello Alvarado", "juan.arguello03@uptc.edu.co");
        menu();
        // Crear pedido:
        // System.out.println("Total Cost: " + "$" + order.total());
        // System.out.println("Limit order date: " + order.calculateLimitDate());
    }

    public static void menu() {
        Scanner sc = new Scanner(System.in);
        Order order = new Order(01);
        System.out.println("--BIENVENIDO A SHOPNOW--");
        String op = "0";
        do {
            System.out.println("""
                    Eliga una opción:
                    1. Agregar un producto
                    2. Ver pedido
                    3. Pagar total
                    0. Cerrar
                    """);
            op = sc.nextLine();
            switch (op) {
                case "1":
                    String op1 = "0";
                    System.out.println("Ingrese el código del producto que desea agregar");
                    st.showProducts();
                    int id = Integer.parseInt(sc.nextLine());
                    addProduct(order, id);
                    order.showProducts();
                    do {
                        System.out.println("""
                                Eliga una opción:
                                1. Agregar otro producto
                                0. Salir
                                """);
                        op1 = sc.nextLine();
                        switch (op1) {
                            case "1":
                                System.out.println("Ingrese el código del producto que desea agregar");
                                st.showProducts();
                                id = Integer.parseInt(sc.nextLine());
                                addProduct(order, id);
                                order.showProducts();
                                break;
                            case "0":
                                System.out.println("Saliendo...");

                                break;
                            default:
                                System.out.println("Opción inválida");
                                break;
                        }

                    } while (op1.equals("0"));
                    break;
                case "0":
                    System.out.println("Cerrando programa...");
                    break;

                default:
                    System.out.println("Opción inválida");
                    break;
            }
        } while (!op.equals("0"));
    }

    public static void addProduct(Order order, int id) {

        if (st.searchProductById(id) == null) {
            System.out.println("No se ha encontrado el producto en la lista");
        } else {
            order.addProduct(st.searchProductById(id));
            System.out.println("Producto agregado");
        }
    }
}
