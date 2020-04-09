package com.mafracompany.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.mafracompany.course.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
}
