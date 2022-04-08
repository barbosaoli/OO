package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import controller.*;


//
//frame.setSize(width,height);
//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
//JPanel container = new JPanel();
//container.setBackground(Color.decode("#eeeeee"));
//
//JPanel header = new JPanel() {
//	 @Override
//	  public Dimension getPreferredSize() {
//	    return new Dimension(width, 60);
//	  }
//};
//header.setBackground(Color.decode("#666"));
//header.setBounds(0, 0,200,200);
//
//
//container.add(header);
//
//frame.add(container);
//
//frame.setVisible(true);
//	Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
//	int width = (int)size.getWidth();
//  int height = (int)size.getHeight();

public class MenuScreen implements ActionListener {

	
	private static JFrame janela = new JFrame("Gerenciamento da loja");
	private static JLabel titulo = new JLabel("Menu Principal");
	
	private static JButton loja = new JButton("Loja");
	private static JButton cliente = new JButton("Cliente");
	private static JButton funcionario = new JButton("Funcionario");
	private static JButton produto = new JButton("Produtos");
	private static JButton armacao = new JButton("Armacao");
	private static JButton venda = new JButton("Venda");
	
	public static DataController data = new DataController();

//	Image Icliente = new ImageIcon(this.getClass().getResource("images/cli.jpg")).getImage();
//	Image Iloja = new ImageIcon(this.getClass().getResource("images/lojan.png")).getImage();
//	Image Ifuncionario = new ImageIcon(this.getClass().getResource("images/func.png")).getImage();
//	Image Ilente = new ImageIcon(this.getClass().getResource("images/lente.jpg")).getImage();
//	Image Iarmacao = new ImageIcon(this.getClass().getResource("images/armacao.jpg")).getImage();
//	Image Ivenda = new ImageIcon(this.getClass().getResource("images/venda.png")).getImage();

	public MenuScreen() {
		titulo.setFont(new Font("Arial", Font.BOLD, 20));
		titulo.setForeground(Color.white);
		titulo.setBounds(140, 10, 150, 30);

		loja.setBounds(140, 250, 160, 30);
		loja.setBackground(Color.WHITE);
		loja.setFocusPainted(false);
		loja.setVerticalTextPosition(SwingConstants.CENTER);
		loja.setHorizontalTextPosition(SwingConstants.RIGHT);
//		loja.setIcon(new ImageIcon(Iloja));
//		loja.setIconTextGap(20);

		funcionario.setBounds(140, 100, 160, 30);
		funcionario.setBackground(Color.WHITE);
		funcionario.setFocusPainted(false);
		funcionario.setVerticalTextPosition(SwingConstants.CENTER);
		funcionario.setHorizontalTextPosition(SwingConstants.RIGHT);
//		funcionario.setIcon(new ImageIcon(Ifuncionario));
//		funcionario.setIconTextGap(5);

		produto.setBounds(140, 150, 160, 30);
		produto.setBackground(Color.WHITE);
		produto.setFocusPainted(false);
		produto.setVerticalTextPosition(SwingConstants.CENTER);
		produto.setHorizontalTextPosition(SwingConstants.RIGHT);
//		lente.setIcon(new ImageIcon(Ilente));
//		lente.setIconTextGap(5);

		cliente.setBounds(140, 50, 160, 30);
		cliente.setBackground(Color.WHITE);
		cliente.setFocusPainted(false);
		cliente.setVerticalTextPosition(SwingConstants.CENTER);
		cliente.setHorizontalTextPosition(SwingConstants.RIGHT);
//		cliente.setIcon(new ImageIcon(Icliente));
//		cliente.setIconTextGap(20);

		armacao.setBounds(140, 200, 160, 30);
		armacao.setBackground(Color.WHITE);
		armacao.setFocusPainted(false);
		armacao.setVerticalTextPosition(SwingConstants.CENTER);
		armacao.setHorizontalTextPosition(SwingConstants.RIGHT);
//		armacao.setIcon(new ImageIcon(Iarmacao));
//		armacao.setIconTextGap(20);

		venda.setBounds(140, 300, 160, 30);
		venda.setBackground(Color.WHITE);
		venda.setFocusPainted(false);
		venda.setVerticalTextPosition(SwingConstants.CENTER);
		venda.setHorizontalTextPosition(SwingConstants.RIGHT);
//		venda.setIcon(new ImageIcon(Ivenda));
//		venda.setIconTextGap(20);

		janela.setLayout(null);
		janela.getContentPane().setBackground(Color.DARK_GRAY);

		janela.add(titulo);
		janela.add(cliente);
		janela.add(funcionario);
		janela.add(produto);
		janela.add(armacao);
		janela.add(loja);
		janela.add(venda);

		janela.setSize(450, 400);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setLocationRelativeTo(null);
		janela.setResizable(false);
		janela.setVisible(true);

	}

	public static void main(String[] args) {
		MenuScreen menu = new MenuScreen();

		loja.addActionListener(menu);
		cliente.addActionListener(menu);
		funcionario.addActionListener(menu);
		produto.addActionListener(menu);
		venda.addActionListener(menu);
	}

	public void actionPerformed(ActionEvent e) { 
		Object src = e.getSource();

		if (src == cliente)
			new PersonScreen().mostrarDados(data, 1);

		if (src == funcionario)
			new PersonScreen().mostrarDados(data, 2);

		if (src == produto)
			new ProductScreen().showProductsData(data);

		if (src == loja)
			new StoreScreen().mostrarLoja(data);
		
		if (src == venda)
			new SaleScreen().mostrarDadosV(data, 1);
	}
}