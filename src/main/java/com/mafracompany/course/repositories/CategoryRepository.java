package com.mafracompany.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.mafracompany.course.entities.Category;


public interface CategoryRepository extends JpaRepository<Category, Long>{
	
}
