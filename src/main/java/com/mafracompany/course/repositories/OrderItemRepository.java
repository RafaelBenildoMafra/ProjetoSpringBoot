package com.mafracompany.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mafracompany.course.entities.OrderItem;

//herda do jpa repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Long>{
	
}
