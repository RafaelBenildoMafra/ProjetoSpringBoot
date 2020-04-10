package com.mafracompany.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mafracompany.course.entities.Order;
import com.mafracompany.course.repositories.OrderRepository;


//REGISTRA COMO UM COMPONENTE DO SPRING E PODE SER IJETADO AUTOMATICAMENTE COM O AUTOWIRED
@Service
public class OrderService {
	
	@Autowired
	private OrderRepository repository;
	
	public List<Order> findAll(){
		
		return repository.findAll();//CHAMA O REPOSITORY FIND ALL
		
	}
	
	public Order findById(Long id) {
		
		Optional<Order> obj = repository.findById(id);
		return obj.get();
		
	}

}
