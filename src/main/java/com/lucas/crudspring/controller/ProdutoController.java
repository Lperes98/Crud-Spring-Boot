package com.lucas.crudspring.controller;

import com.lucas.crudspring.model.entities.Produto;
import com.lucas.crudspring.model.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;


@Controller
@RequestMapping(path="/produtos")
public class ProdutoController {

	@Autowired
	private ProdutoRepository produtoRepository;


	public ProdutoRepository getProdutoRepository() {
		return produtoRepository;
	}

	public void setProdutoRepository(ProdutoRepository produtoRepository) {
		this.produtoRepository = produtoRepository;
	}
	
	//USANDO HTML
	//LENDO PRODUTOS
	@RequestMapping(value = "/cadastrarProdutos",method = RequestMethod.GET)
	public String criarProduto() {
		return "produto/formProduto";
	}
	
	//CRIANDO PRODUTOS
	@RequestMapping(value = "/cadastrarProdutos",method = RequestMethod.POST)
	public String criarProduto(Produto produto) {
		produtoRepository.save(produto);
		return "redirect:/produtos/cadastrarProdutos";
	}
	
	//LISTA DE PRODUTOS
	@RequestMapping("/buscarProdutos")
	public ModelAndView listaProdutos() {
		ModelAndView mv = new ModelAndView("produto/cadastroprod");
		  Iterable<Produto> listaProduto =  produtoRepository.findAll();
		  mv.addObject("produtos", listaProduto);
		  return mv;
	}

	@RequestMapping("/{id}")
	public ModelAndView detalhesProduto(@PathVariable int id) {
		Produto produto = produtoRepository.findById(id);
		ModelAndView mv = new ModelAndView("produto/detalhesProduto");
		mv.addObject("produto", produto);
		return mv;
	}
	
	@RequestMapping("/deletar")
	public String deleterProduto(int id){
		Produto produto = produtoRepository.findById(id);
		produtoRepository.delete(produto);
		return "redirect:/produtos/buscarProdutos";
	}
	@RequestMapping(value = "/updateProduto/{id}", method = RequestMethod.GET)
	public ModelAndView updateProduto(@PathVariable int id){
		ModelAndView mv = new ModelAndView("produto/alterarProduto");
		Produto produto = produtoRepository.findById(id);
		mv.addObject("produto",produto);
		return mv;
	}

	@RequestMapping(value = "/updateProduto/{id}", method = RequestMethod.POST)
	public String updateProdutoPost(@PathVariable int id, @Valid Produto produto){
		produtoRepository.findById(id);
		produtoRepository.save(produto);
		return "redirect:/produtos/buscarProdutos";

	}
	
	
	

	//CADASTRAR NOVO PRODUTO PASSANDO UM CLIENTE PARA ADICIONAR O CLIENTE AO PRODUTO
	@PostMapping("/cadastrar")
	public @ResponseBody Produto cadastrarProduto(@Valid Produto produto) {
		produtoRepository.save(produto);
		return produto;
	}
	
	//ALTERAR PRODUTO
	@PutMapping("/alterar")
	public Produto alterarProduto(Produto produto) {
		produtoRepository.save(produto);
		return produto;
	}
	
	//BUSCAR PRODUTO POR ID
	@GetMapping("/buscar/{id}")
	public Produto buscarProdutoPorId(@PathVariable int id) {
		return produtoRepository.findById(id);
	}
	
	//BUSCAR PRODUTO POR NOME
	@GetMapping("/buscar/nome/{nomeProduto}")
	public Iterable<Produto> buscarPorNome(@PathVariable String nomeProduto){
		return produtoRepository.findByNomeContainingIgnoreCase(nomeProduto);
	}
	

}
