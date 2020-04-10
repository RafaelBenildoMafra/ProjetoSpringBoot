package com.mafracompany.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.mafracompany.course.entities.Payment;

//herda do jpa repository
public interface PaymentRepository extends JpaRepository<Payment, Long>{
	
}
