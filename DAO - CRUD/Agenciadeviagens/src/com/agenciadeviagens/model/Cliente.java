package com.agenciadeviagens.model;

public class Cliente {
	
	private int IDCliente;
	private String nome;
	private String sobrenome;
	private String endereco;
	private String email;
	private String telefone;
	

	
	
	public Cliente() {
		super();
		
	}



	public Cliente(String nome, String sobrenome, String endereco, String email, String telefone) {
		super();
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.endereco = endereco;
		this.email = email;
		this.telefone = telefone;
	}
	
	


	public int getIDCliente() {
		return IDCliente;
	}
	


	public void setIDCliente(int iDCliente) {
		IDCliente = iDCliente;
	}




	public String getNome() {
		return nome;
	}



	public void setNome(String nome) {
		this.nome = nome;
	}





	public String getSobrenome() {
		return sobrenome;
	}





	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}





	public String getEndereco() {
		return endereco;
	}





	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}





	public String getEmail() {
		return email;
	}





	public void setEmail(String email) {
		this.email = email;
	}





	public String getTelefone() {
		return telefone;
	}





	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}



	@Override
	public String toString() {
		return "Cliente [nome=" + nome + ", sobrenome=" + sobrenome + ", endereco=" + endereco + ", email=" + email
				+ ", telefone=" + telefone + "]";
	}



	public int getID() {
		return 0;
	}





	
	
	
	


}

