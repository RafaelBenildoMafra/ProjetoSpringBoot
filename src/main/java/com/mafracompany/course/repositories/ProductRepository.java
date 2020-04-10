package com.mafracompany.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.mafracompany.course.entities.Product;


public interface ProductRepository extends JpaRepository<Product, Long>{
	
}
