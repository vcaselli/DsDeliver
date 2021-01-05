package br.com.ddtechrj.dsdeliver.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ddtechrj.dsdeliver.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

	
	List<Product> findAllByOrderByNameAsc();
}
