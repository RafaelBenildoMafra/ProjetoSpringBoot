package com.mafracompany.course.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mafracompany.course.entities.Product;
import com.mafracompany.course.repositories.ProductRepository;


//REGISTRA COMO UM COMPONENTE DO SPRING E PODE SER IJETADO AUTOMATICAMENTE COM O AUTOWIRED
@Service
public class ProductService {
	
	@Autowired
	private ProductRepository repository;
	
	public List<Product> findAll(){
		
		return repository.findAll();//CHAMA O REPOSITORY FIND ALL
		
	}
	
	public Product findById(Long id) {
		
		Optional<Product> obj = repository.findById(id);
		return obj.get();
		
	}

}
