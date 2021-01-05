package br.com.ddtechrj.dsdeliver.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ddtechrj.dsdeliver.entities.Order;
import br.com.ddtechrj.dsdeliver.entities.dto.OrderDTO;
import br.com.ddtechrj.dsdeliver.services.OrderService;

@RestController
@RequestMapping("/orders")
public class OrderResource {
	
	@Autowired
	OrderService service;

	@GetMapping
	public ResponseEntity<List<OrderDTO>> findAll(){ 
		List<OrderDTO> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Order> findById(@PathVariable Long id){ 
		Order order = service.findById(id);
		return ResponseEntity.ok().body(order);
	}
}
