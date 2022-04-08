package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

import controller.*;

public class ProductScreen implements ActionListener, ListSelectionListener {

    private JFrame window;
    private JLabel title;
    private JButton registerProduct;
    private JButton refreshProduct;
    private static DataController data;
    private JList<String> registeredProductsList;
    private String[] productsList = new String[50];

    public void showProductsData(DataController d) {
        data = d;

        // Mostrar dados de lentes cadastrados (JList)
        productsList = new PurseController(data).getName();
        registeredProductsList = new JList<String>(productsList);
        
        window = new JFrame("Produtos");
        title = new JLabel("Produtos Cadastrados");
        
        registerProduct = new JButton("Cadastrar");
        refreshProduct = new JButton("Refresh");

        title.setFont(new Font("Arial", Font.BOLD, 20));
        title.setForeground(Color.WHITE);
        title.setBounds(90, 10, 250, 30);
        registeredProductsList.setBounds(20, 50, 350, 250);
        registeredProductsList.setBackground(Color.WHITE);
        registeredProductsList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        registeredProductsList.setVisibleRowCount(10);

        registerProduct.setBounds(70, 320, 100, 30);
        refreshProduct.setBounds(200, 320, 100, 30);

        window.setLayout(null);
        window.getContentPane().setBackground(Color.DARK_GRAY);

        window.add(title);
        window.add(registeredProductsList);
        window.add(registerProduct);
        window.add(refreshProduct);

        window.setSize(400, 420);
        window.setVisible(true);
        window.setLocationRelativeTo(null);
        window.setResizable(false);

        registerProduct.addActionListener(this);
        refreshProduct.addActionListener(this);
        registeredProductsList.addListSelectionListener(this);

    }

    // Captura eventos relacionados aos botoes da interface

    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();

        // Atualiza a lista de nomes das lentes mostrada no JList
        if (src == refreshProduct) {
            registeredProductsList.setListData(new PurseController(data).getName());
            registeredProductsList.updateUI();
        }
        if (src == registerProduct) {
            new ProductInformationScreen().inserirEditar(1, data, this, 0);
        }

    }

    // Captura eventos relacionados ao JList
    public void valueChanged(ListSelectionEvent e) {
        Object src = e.getSource();

        if (e.getValueIsAdjusting() && src == registeredProductsList) {
            new ProductInformationScreen().inserirEditar(2, data, this, registeredProductsList.getSelectedIndex());
        }
    }

}