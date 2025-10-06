package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import model.Order;
import model.Product;
import model.ProductLoader;

public class ShopNowGUI extends JFrame {

    private JList<String> productList;
    private DefaultListModel<String> listModel;
    private JTextArea cartArea;
    private Order order;
    private ArrayList<Product> catalog;

    public ShopNowGUI() {
        setTitle("ShowNow - Carrito de Compras");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);// para que no se redimensione
        setLocationRelativeTo(null); // aparecer en el centro
        setLayout(new BorderLayout());

        // cargar productos:
        catalog = ProductLoader.loadProducts("src/Catalog.txt");
        Order order = new Order(1234);

        // Panel de catálogo
        listModel = new DefaultListModel<>();
        for (Product p : catalog) {
            listModel.addElement(p.getIdProduct() + " " + p.getNameProduct() + " $" + p.getCost());
        }
        productList = new JList<>(listModel);
        JScrollPane scrollCatalog = new JScrollPane(productList);

        JButton addButton = new JButton("Agregar al Carrito");
        addButton.addActionListener((ActionEvent e) -> {
            int selectProduct = productList.getSelectedIndex();
            if (selectProduct != -1) {
                Product product = catalog.get(selectProduct);
                order.addProduct(product);
                cartArea.append(product.getNameProduct() + " " + product.getIdProduct() + " " + product.getCost());
            }
        });

        JPanel leftPanel = new JPanel(new BorderLayout());
        leftPanel.add(new JLabel("Catálogo de Productos"), BorderLayout.NORTH);
        leftPanel.add(scrollCatalog, BorderLayout.CENTER);
        leftPanel.add(addButton, BorderLayout.SOUTH);

        // Panel del carrito:
        cartArea = new JTextArea();
        cartArea.setEditable(false);
        JScrollPane scrollCarrito = new JScrollPane(cartArea);

        JPanel rightPanel = new JPanel(new BorderLayout());
        rightPanel.add(new JLabel("Carrito de compras: "), BorderLayout.NORTH);

        rightPanel.add(scrollCarrito, BorderLayout.CENTER);
        JButton checkoutButton = new JButton("Finalizar compra");
        checkoutButton.addActionListener((ActionEvent e) -> {
            cartArea.append("\nCosto total: " + order.total() + "\nFecha límite:    " + order.calculateLimitDate()+"\n");
        });

        rightPanel.add(checkoutButton, BorderLayout.SOUTH);

        // Dividir pantalla en dos:

        add(leftPanel, BorderLayout.WEST);
        add(rightPanel, BorderLayout.CENTER);

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new ShopNowGUI().setVisible(true);
        });
    }

}
