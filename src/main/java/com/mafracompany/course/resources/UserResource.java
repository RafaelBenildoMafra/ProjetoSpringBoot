package com.mafracompany.course.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import com.mafracompany.course.entities.User;
import com.mafracompany.course.services.UserService;



@RestController
@RequestMapping(value = "/users")
public class UserResource {
	
	@Autowired
	private UserService service;
	
	@GetMapping
	public ResponseEntity<List<User>> findAll(){
		
		List<User> list = service.findAll();
		
		return ResponseEntity.ok().body(list);
		
	}
	
	//REQUISIÇÃO VAI ACEITAR UM ID DENTRO DA URL
	@GetMapping(value = "/{id}") 
	public ResponseEntity<User> findById(@PathVariable Long id){
		
		User obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
		
	}
	
	@PostMapping(value = "/{id}") 
	public ResponseEntity<User> insert(@RequestBody User obj){
		
		obj = service.Incert(obj);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(obj.getId()).toUri();
		
		return ResponseEntity.created(uri).body(obj);//ENDEREÇO DO RECURSO QUE EU INSERI
		
	}
	
	@DeleteMapping(value = "/{id}") 
	public ResponseEntity<Void> delete(@PathVariable Long id){
		
			service.delete(id);
			return ResponseEntity.noContent().build(); //RESPOSTA SEM CORPO - VAZIA - 204
		}
	
	@PutMapping(value = "/{id}") 
	public ResponseEntity<User> update(@PathVariable Long id, @RequestBody User obj){
		
		obj = service.update(id, obj);
		return ResponseEntity.ok().body(obj);
		
	}
}

