package com.mafracompany.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mafracompany.course.entities.User;
import com.mafracompany.course.repositories.UserRepository;


//REGISTRA COMO UM COMPONENTE DO SPRING E PODE SER IJETADO AUTOMATICAMENTE COM O AUTOWIRED
@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	public List<User> findAll(){
		
		return repository.findAll();//CHAMA O REPOSITORY FIND ALL
		
	}
	
	public User findById(Long id) {
		
		Optional<User> obj = repository.findById(id);
		return obj.get();
		
	}

}
