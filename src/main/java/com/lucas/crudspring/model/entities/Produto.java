package com.lucas.crudspring.model.entities;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity(name = "produtos")
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotNull(message ="Campo não estar vazio")
	@Size(min=2, max=100, message="Tem de ter pelo menos 2 letras")
	@Column(nullable = false, length = 40, name = "Nome_Produto")
	private String nome;
	
	@Min(0)
	@Column(nullable = false ,name = "Preco_Produto")
	private double preco;
	 
	@Min(0)
	@Max(1)
	@Column(nullable = false, name = "Desconto_Produto")
	private double desconto;
	@ManyToOne
	private Cliente cliente;
	
	public Produto() {
		
	}

	public Produto(String nome, double preco, double desconto, Cliente cliente) {
		super();
		this.nome = nome;
		this.preco = preco;
		this.desconto = desconto;
		this.cliente = cliente;

	
	}


	
	
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public double getDesconto() {
		return desconto;
	}

	public void setDesconto(double desconto) {
		this.desconto = desconto;
	}

	
	
	
	
	
}
