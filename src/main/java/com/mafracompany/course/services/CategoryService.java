package com.mafracompany.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mafracompany.course.entities.Category;
import com.mafracompany.course.repositories.CategoryRepository;


//REGISTRA COMO UM COMPONENTE DO SPRING E PODE SER IJETADO AUTOMATICAMENTE COM O AUTOWIRED
@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository repository;
	
	public List<Category> findAll(){
		
		return repository.findAll();//CHAMA O REPOSITORY FIND ALL
		
	}
	
	public Category findById(Long id) {
		
		Optional<Category> obj = repository.findById(id);
		return obj.get();
		
	}

}
