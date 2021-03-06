package br.com.ddtechrj.dsdeliver.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.ddtechrj.dsdeliver.entities.Product;
import br.com.ddtechrj.dsdeliver.entities.dto.ProductDTO;
import br.com.ddtechrj.dsdeliver.repositories.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	ProductRepository repository;

	@Transactional(readOnly = true)
	public List<ProductDTO> findAll(){ 
		List<ProductDTO> dto = repository.findAllByOrderByNameAsc()
				.stream()
				.map(x -> new ProductDTO(x))
				.collect(Collectors.toList());
		return dto; 
	}
	
	@Transactional
	public Product findById(long id) { 
		Optional<Product> product = repository.findById(id);
		return product.orElseThrow(() -> new IllegalArgumentException("Invalid id"));
	}
	
	
	
}
