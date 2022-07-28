package com.lucas.crudspring.model.repositories;

import com.lucas.crudspring.model.entities.Cliente;
import org.springframework.data.repository.PagingAndSortingRepository;


import com.lucas.crudspring.model.entities.Produto;

public interface ProdutoRepository extends PagingAndSortingRepository<Produto, Integer>{

	public Iterable<Produto> findByNomeContainingIgnoreCase(String parteNome);

	public Produto findById(int id);

	public Iterable<Produto> findByCliente(Cliente cliente);
	
}
