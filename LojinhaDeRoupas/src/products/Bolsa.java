package products;

import model.Produto;

public class Bolsa extends Produto{
	private String modelo;
	private String tamanho;
	
	public Bolsa(int idProduto, String nome, String cor, String categoria, String marca, int preco, String modelo,
			String tamanho) {
		super(idProduto, nome, cor, categoria, marca, preco);
		this.modelo = modelo;
		this.tamanho = tamanho;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getTamanho() {
		return tamanho;
	}

	public void setTamanho(String tamanho) {
		this.tamanho = tamanho;
	}
	
	
	
}