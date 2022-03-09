package products;

import model.Produto;

public class Carteira extends Produto{
	private String tamanho;

	public Carteira(int idProduto, String nome, String cor, String categoria, String marca, int preco, String tamanho) {
		super(idProduto, nome, cor, categoria, marca, preco);
		
		this.tamanho = tamanho;
	}

	public String getTamanho() {
		return tamanho;
	}

	public void setTamanho(String tamanho) {
		this.tamanho = tamanho;
	}

	
	
	

}