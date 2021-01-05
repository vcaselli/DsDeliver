package br.com.ddtechrj.dsdeliver.services;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.ddtechrj.dsdeliver.OrderStatus;
import br.com.ddtechrj.dsdeliver.entities.Order;
import br.com.ddtechrj.dsdeliver.entities.Product;
import br.com.ddtechrj.dsdeliver.entities.dto.OrderDTO;
import br.com.ddtechrj.dsdeliver.entities.dto.ProductDTO;
import br.com.ddtechrj.dsdeliver.repositories.OrderRepository;
import br.com.ddtechrj.dsdeliver.repositories.ProductRepository;

@Service
public class OrderService {
	
	@Autowired
	OrderRepository repository;
	@Autowired
	ProductRepository productRepository;

	@Transactional(readOnly = true)
	public List<OrderDTO> findAll(){ 
		return repository.findOrderswithProducts().stream().map(x -> new OrderDTO(x)).collect(Collectors.toList());
	}
	
//	@Transactional
//	public Order findById(long id) { 
//		Optional<Order> product = repository.findById(id);
//		return product.orElseThrow(() -> new IllegalArgumentException("Invalid id"));
//	}
	
	@Transactional
	public OrderDTO insert(OrderDTO dto) { 
		Order order = new Order(dto.getAddress(), dto.getLatitude(), dto.getLongitude(), Instant.now(), OrderStatus.PANDING);
		
		for(ProductDTO p : dto.getProducts()) {
			Product product = productRepository.getOne(p.getId());
			order.getProducts().add(product);
			
		}
		
		order = repository.save(order);
		
		return new OrderDTO(order);
		
	}
	
	
	
}
