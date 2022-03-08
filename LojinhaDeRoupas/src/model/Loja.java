package model;

import java.util.ArrayList;

public class Loja {
	private String nomeLoja;
	private String endereco;
	private String cnpj;
	private ArrayList<Cliente> listaClientes= new ArrayList<Cliente>();
	private ArrayList<Funcionario> listaFuncionarios= new ArrayList<Funcionario>();
	
	public Loja() {
		
	}

	public Loja(String nomeLoja, String endereco, String cnpj) {
		
		this.nomeLoja = nomeLoja;
		this.endereco = endereco;
		this.cnpj = cnpj;
	}
	
	
	
	public String getNomeLoja() {
		return nomeLoja;
	}


	public String getEndereco() {
		return endereco;
	}


	public String getCnpj() {
		return cnpj;
	}

	public void adicionaProduto(Cliente cliente) {
		listaClientes.add(cliente);
	}
	
	public void adicionaFuncionario(Funcionario funcionario) {
		listaFuncionarios.add(funcionario);
	}
	
	
}