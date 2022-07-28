package com.lucas.crudspring.model.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;


import com.lucas.crudspring.model.entities.Cliente;

public interface ClienteRepository extends PagingAndSortingRepository<Cliente, Integer>{

	public Iterable<Cliente> findByNomeContainingIgnoreCase(String parteNome);
	
	public Cliente findById(int id);
	
}
