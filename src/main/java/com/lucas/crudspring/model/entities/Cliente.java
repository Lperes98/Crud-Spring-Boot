package com.lucas.crudspring.model.entities;

import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "clientes")
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@NotBlank
	@Pattern(regexp = "^[A-Z]+(.)*", message = "A Primeira Letra precisa ser MAIUSCULA")
	@Column(nullable = false, name = "Nome_Cliente")
	private String nome;
	@CPF
	@Column(nullable = false, name = "CPF_Cliente")
	private String cpf;
	@Email
	@Column(nullable = false, name = "Email_Cliente")
	private String email;
	@Column(nullable = false, name = "DataNas_Cliente")
	private String dataNascimento;
	
	
	@OneToMany
	private List<Produto> produtos = new ArrayList<Produto>();
	
	public Cliente() {
		
	}

	public Cliente(String nome, String cpf, String email, String dataNascimento) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.dataNascimento = dataNascimento;
	}


	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	
	
	
}
