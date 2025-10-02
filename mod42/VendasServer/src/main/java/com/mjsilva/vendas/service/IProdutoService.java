package com.mjsilva.vendas.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mjsilva.vendas.domain.Produto;

@FeignClient(name = "produto", url = "${application.produtoService.endpointConsultarProduto}")
public interface IProdutoService {
	
	@RequestMapping(method = RequestMethod.GET, 
			value = "/codigo/{codigo}", 
			produces = "application/json", 
			headers = "application/json")
	Produto buscarProduto(@PathVariable("codigo") String codigoProduto);
}
