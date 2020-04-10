package com.mafracompany.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.mafracompany.course.entities.Order;

//herda do jpa repository
public interface OrderRepository extends JpaRepository<Order, Long>{
	
}
