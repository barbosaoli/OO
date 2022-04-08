package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
//import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
 
import controller.*;

public class ProductInformationScreen implements ActionListener {
    private JFrame janela;
    
    private JLabel labelId = new JLabel("id: ");
    private JTextField idValue;
    private JLabel labelName = new JLabel("Nome: ");
    private JTextField nameValue;
    private JLabel labelPrice = new JLabel("Valor: ");
    private JTextField priceValue;
    private JLabel labelBrand = new JLabel("Marca: ");
    private JTextField brandValue;
    private JLabel labelSize = new JLabel("Tamanho: ");
    private JTextField sizeValue;
    private JLabel labelColor = new JLabel("Cor:  ");
    private JTextField colorValue;
    private JLabel labelCategory = new JLabel("Categoria:  ");
    private JTextField categoryValue;
    private JLabel labelMaterial = new JLabel("Material: ");
    private JTextField materialValue;
    
    private JButton botaoExcluir = new JButton("Excluir");
    private JButton botaoSalvar = new JButton("Salvar");
    
    private String[] novoDado = new String[15];
    private static DataController dados;
    private int posicao;
    private int opcao;
    private String s;

    public void inserirEditar(int op, DataController d, ProductScreen t, int pos) {

        opcao = op;
        posicao = pos;
        dados = d;

        if (op == 1)
            s = "Cadastro de Produto";
        if (op == 2)
            s = "Detalhes do Produto";

        janela = new JFrame(s);

        // Preenche dados com dados da armacao clicada
        if (op == 2) {
            idValue = new JTextField(String.valueOf(dados.getPurse()[pos].getIdProduto()), 200);
            nameValue = new JTextField(String.valueOf(dados.getPurse()[pos].getNome()), 200);
            colorValue = new JTextField(String.valueOf(dados.getPurse()[pos].getCor()), 200);
            brandValue = new JTextField(String.valueOf(dados.getPurse()[pos].getMarca()), 200);
            priceValue = new JTextField(String.valueOf(dados.getPurse()[pos].getPreco()), 200);
            sizeValue = new JTextField(String.valueOf(dados.getPurse()[pos].getTamanho()), 200);
            materialValue = new JTextField(String.valueOf(dados.getPurse()[pos].getMaterial()), 200);
            categoryValue = new JTextField(String.valueOf(dados.getPurse()[pos].getCategoria()), 200);
            

        } else { // N�o preenche com dados
            idValue = new JTextField();
            nameValue = new JTextField();
            colorValue = new JTextField();
            brandValue = new JTextField();
            priceValue = new JTextField();
            sizeValue = new JTextField();
            materialValue = new JTextField();
            categoryValue = new JTextField();
            
            botaoSalvar.setBounds(245, 370, 115, 30);
        }

        labelId.setBounds(30, 20, 180, 25);
        labelId.setForeground(Color.WHITE);
        idValue.setBounds(180, 20, 180, 25);

        labelPrice.setBounds(30, 50, 150, 25);
        labelPrice.setForeground(Color.WHITE);
        priceValue.setBounds(180, 50, 180, 25);

        labelSize.setBounds(30, 80, 180, 25);
        labelSize.setForeground(Color.WHITE);
        sizeValue.setBounds(180, 80, 180, 25);
        
        labelCategory.setBounds(30, 110, 180, 25);
        labelCategory.setForeground(Color.WHITE);
        categoryValue.setBounds(180, 110, 180, 25);

        labelBrand.setBounds(30, 140, 150, 25);
        labelBrand.setForeground(Color.WHITE);
        brandValue.setBounds(180, 140, 180, 25);

        labelMaterial.setBounds(30, 170, 150, 25);
        labelMaterial.setForeground(Color.WHITE);
        materialValue.setBounds(180, 170, 180, 25);

        labelColor.setBounds(30, 200, 150, 25);
        labelColor.setForeground(Color.WHITE);
        colorValue.setBounds(180, 200, 180, 25);

        labelName.setBounds(30, 290, 150, 25);
        labelName.setForeground(Color.WHITE);
        nameValue.setBounds(180, 290, 180, 25);

        // Coloca botoes de excluir e salvar
        if (op == 2) {
            botaoSalvar.setBounds(120, 370, 115, 30);
            botaoExcluir.setBounds(245, 370, 115, 30);
            this.janela.add(botaoExcluir);
        }


        this.janela.add(labelColor);
        this.janela.add(colorValue);
        this.janela.add(labelId);
        this.janela.add(idValue);
        this.janela.add(labelPrice);
        this.janela.add(priceValue);
        this.janela.add(labelSize);
        this.janela.add(sizeValue);
        this.janela.add(labelBrand);
        this.janela.add(brandValue);
        this.janela.add(labelMaterial);
        this.janela.add(materialValue);
        this.janela.add(labelColor);
        this.janela.add(colorValue);
        this.janela.add(labelName);
        this.janela.add(nameValue);
        this.janela.add(botaoSalvar);
        this.janela.add(labelCategory);
        this.janela.add(categoryValue);

        this.janela.setLayout(null);
        janela.getContentPane().setBackground(Color.DARK_GRAY);

        this.janela.setSize(500, 450);
        this.janela.setVisible(true);
        janela.setLocationRelativeTo(null);
        janela.setResizable(false);

        botaoSalvar.addActionListener(this);
        botaoExcluir.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();
        
        if (src == botaoSalvar) {
            try {
                boolean res;
                if (opcao == 1) // cadastro de nova armacao
                    novoDado[0] = Integer.toString(dados.getAmountOfPurses());
                else { // edicao de dado existente
                    novoDado[0] = Integer.toString(posicao);
                }
                
                novoDado[1] = idValue.getText();
                novoDado[2] = nameValue.getText();
                novoDado[3] = colorValue.getText();
                novoDado[4] = categoryValue.getText();
                novoDado[5] = brandValue.getText();
                novoDado[6] = sizeValue.getText();
                novoDado[7] = priceValue.getText();
                novoDado[8] = materialValue.getText();
                

                if (opcao == 1) {
                    res = dados.insertPurse(novoDado);
                } else {
                    res = dados.insertPurse(novoDado);
                }
                
                
                
                if (res) {
                    mensagemSucessoCadastro();
                } else
                    mensagemErroCadastro();

            } catch (NullPointerException exc1) {
                mensagemErroCadastro();
            } catch (NumberFormatException exc2) {
                mensagemErroCadastro();
            }
        }

        if (src == botaoExcluir) {
            boolean res = false;

//            res = dados.removerLente(posicao);
            if (res)
                mensagemSucessoExclusao();
            else
                mensagemErroExclusaoArmacao();

        }

    }

    public void mensagemSucessoExclusao() {
        JOptionPane.showMessageDialog(null, "Os dados foram excluidos com sucesso!", null,
                JOptionPane.INFORMATION_MESSAGE);
        janela.dispose();
    }

    public void mensagemSucessoCadastro() {
        JOptionPane.showMessageDialog(null, "Os dados foram salvos com sucesso!", null,
                JOptionPane.INFORMATION_MESSAGE);
        janela.dispose();
    }

    public void mensagemErroCadastro() {
        JOptionPane.showMessageDialog(null,
                "ERRO AO SALVAR OS DADOS!\n " + "Pode ter ocorrido o seguinte:  \n"
                        + "1. Nem todos os campos foram preenchidos \n"
                        + "2. id da lente, id da armacao, valor da lente e/ou grau da lente nao contem apenas numeros",
                null, JOptionPane.ERROR_MESSAGE);
    }

    public void mensagemErroExclusaoArmacao() {
        JOptionPane.showMessageDialog(null, "Ocorreu um erro ao excluir o dado.\n "
                + "Verifique se a lente esta cadastrada\n" + " e tente novamente.", null, JOptionPane.ERROR_MESSAGE);
    }
}