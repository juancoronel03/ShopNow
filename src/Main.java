import java.util.Scanner;

import model.Client;
import model.Order;
import model.Product;
import presenter.Store;
import view.ShopNowGUI;

public class Main { // MÉTODO PRINCIPAL

    private static Store st = new Store();
    

    public static void main(String[] args) {
        // Crear cliente:
        Client client = new Client("Juan felipe coronel", "juan.coronel03@uptc.edu.co");
        ShopNowGUI gui = new ShopNowGUI();
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

                    } while (!op1.equals("0"));
                    break;
                case "2": 
                    System.out.println();
                    order.showOrder();
                    System.out.println();
                    
                    break; 
                case "3":
                    if (order.total() <= 0) {
                        System.out.println("El pedido está vacío. Agregue productos antes de pagar.");
                        break;
                    }
                    System.out.println("Elija método de pago:\n1. Tarjeta\n2. Transferencia bancaria\n3. Billetera digital");
                    String payOp = sc.nextLine();
                    switch (payOp) {
                        case "1":
                            System.out.println("Ingrese nombre del titular:");
                            String owner = sc.nextLine();
                            System.out.println("Ingrese número de tarjeta:");
                            String cardNum = sc.nextLine();
                            System.out.println("Ingrese fecha de expiración (MM/AA):");
                            String exp = sc.nextLine();
                            System.out.println("Ingrese CVV:");
                            String cvv = sc.nextLine();
                            model.Card card = new model.Card(owner, order.total(), cardNum, exp, cvv);
                            order.setPaymentMethod(card);
                            order.proccesOrder();
                            break;
                        case "2":
                            System.out.println("Ingrese nombre del titular:");
                            String ownerT = sc.nextLine();
                            System.out.println("Ingrese nombre del banco:");
                            String bank = sc.nextLine();
                            System.out.println("Ingrese número de cuenta:");
                            String acc = sc.nextLine();
                            model.BankTransfer bt = new model.BankTransfer(ownerT, order.total(), bank, acc);
                            order.setPaymentMethod(bt);
                            order.proccesOrder();
                            break;
                        case "3":
                            System.out.println("Ingrese nombre del titular:");
                            String ownerW = sc.nextLine();
                            System.out.println("Ingrese ID de la billetera:");
                            String wid = sc.nextLine();
                            model.DigitalWallet dw = new model.DigitalWallet(ownerW, order.total(), wid);
                            order.setPaymentMethod(dw);
                            order.proccesOrder();
                            break;
                        default:
                            System.out.println("Opción de pago inválida");
                    }
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
