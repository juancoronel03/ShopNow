import java.util.Scanner;
import model.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        
        Client client = new Client("Juan Felipe Coronel", "juan.coronel03@uptc.edu.co");

        
        System.out.println("-- BIENVENIDO A SHOPNOW --");
        client.showInfo();
        System.out.println();

        String filePath = "src/Catalog.txt"; 
        var products = ProductLoader.loadProducts(filePath);

        // Crear pedido
        Order order = new Order(1);

        String option;
        do {
            System.out.println("""
                    
                    MENU PRINCIPAL
                    -- ---  --- --
                    1. Ver catalogo
                    2. Agregar producto al pedido
                    3. Ver pedido
                    4. Pagar total
                    0. Salir
                    ----------------------------
                    Elige una opcion:
                    """);

            option = sc.nextLine();

            switch (option) {
                case "1":
                    System.out.println("\n-- CATALOGO DE PRODUCTOS --");
                    for (Product p : products) {
                        p.showProductInfo();
                    }
                    System.out.println();
                    break;

                case "2":
                    System.out.println("Ingrese el codigo del producto que desea agregar:");
                    int id = Integer.parseInt(sc.nextLine());
                    Product found = null;
                    for (Product p : products) {
                        if (p.getIdProduct() == id) {
                            found = p;
                            break;
                        }
                    }
                    if (found != null) {
                        order.addProduct(found);
                        System.out.println("Producto agregado al pedido.\n");
                    } else {
                        System.out.println("Producto no encontrado.\n");
                    }
                    break;

                case "3":
                    if (order.total() == 0) {
                        System.out.println("El pedido esta vacio.\n");
                    } else {
                        order.showOrder();
                        System.out.println();
                    }
                    break;

                case "4":
                    if (order.total() == 0) {
                        System.out.println("El pedido esta vacio. Agregue productos antes de pagar.\n");
                        break;
                    }

                    System.out.println("""
                            Elija metodo de pago:
                            1. Tarjeta
                            2. Transferencia bancaria
                            3. Billetera digital
                            """);

                    String payOption = sc.nextLine();
                    PaymentMethod method = null;

                    switch (payOption) {
                        case "1":
                            System.out.println("Ingrese nombre del titular:");
                            String ownerC = sc.nextLine();
                            System.out.println("Ingrese numero de tarjeta:");
                            String cardNum = sc.nextLine();
                            System.out.println("Ingrese fecha de expiracion (MM/AA):");
                            String exp = sc.nextLine();
                            System.out.println("Ingrese CVV:");
                            String cvv = sc.nextLine();

                            method = new Card(ownerC, order.total(), cardNum, exp, cvv);
                            break;

                        case "2":
                            System.out.println("Ingrese nombre del titular:");
                            String ownerT = sc.nextLine();
                            System.out.println("Ingrese nombre del banco:");
                            String bank = sc.nextLine();
                            System.out.println("Ingrese numero de cuenta:");
                            String acc = sc.nextLine();

                            method = new BankTransfer(ownerT, order.total(), bank, acc);
                            break;

                        case "3":
                            System.out.println("Ingrese nombre del titular:");
                            String ownerW = sc.nextLine();
                            System.out.println("Ingrese ID de la billetera:");
                            String wid = sc.nextLine();

                            method = new DigitalWallet(ownerW, order.total(), wid);
                            break;

                        default:
                            System.out.println("Opcion de pago invalida.\n");
                            break;
                    }

                    if (method != null) {
                        order.setPaymentMethod(method);
                        order.proccesOrder();
                    }
                    break;

                case "0":
                    System.out.println("Cerrando programa...");
                    break;

                default:
                    System.out.println("Opcion invalida. Intente nuevamente.\n");
                    break;
            }

        } while (!option.equals("0"));

        sc.close();
    }
}
