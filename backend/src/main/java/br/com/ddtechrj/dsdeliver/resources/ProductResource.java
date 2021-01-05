package br.com.ddtechrj.dsdeliver.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ddtechrj.dsdeliver.entities.Product;
import br.com.ddtechrj.dsdeliver.entities.dto.ProductDTO;
import br.com.ddtechrj.dsdeliver.services.ProductService;

@RestController
@RequestMapping("/products")
public class ProductResource {
	
	@Autowired
	ProductService service;

	@GetMapping
	public ResponseEntity<List<ProductDTO>> findAll(){ 
		List<ProductDTO> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Product> findById(@PathVariable Long id){ 
		Product product = service.findById(id);
		return ResponseEntity.ok().body(product);
	}
}
