package br.com.ddtechrj.dsdeliver.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.ddtechrj.dsdeliver.entities.Order;
import br.com.ddtechrj.dsdeliver.repositories.OrderRepository;

@Service
public class OrderService {
	
	@Autowired
	OrderRepository repository;

	@Transactional(readOnly = true)
	public List<Order> findAll(){ 
		return repository.findAll();
	}
	
	@Transactional
	public Order findById(long id) { 
		Optional<Order> product = repository.findById(id);
		return product.orElseThrow(() -> new IllegalArgumentException("Invalid id"));
	}
	
	
	
}
