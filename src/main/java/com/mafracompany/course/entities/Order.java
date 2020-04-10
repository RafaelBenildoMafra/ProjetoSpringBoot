package com.mafracompany.course.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mafracompany.course.entities.enums.OrderStatus;

@Entity
@Table(name = "tb_order")//MUDA O NOME DA TABLELA PARA NAO BATER COM OD DADOS DO DB
public class Order implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id //CRIA A TABELA
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd:ss'Z'", timezone = "GMT") 
	private Instant moment;
	
	private Integer orderStatus;
	
	@ManyToOne //POR SER UMA RELAÇÃO DE MUITOS PARA UM (LISTA)
	@JoinColumn(name = "client_id")
	private User client;
	
	//ORDER_ITEM TEM O ID E O ID TEM O PEDIDO
	@OneToMany(mappedBy = "id.order")
	private Set<OrderItem> items = new HashSet<>();
	
	public Order() {
		
	}

	public Order(Long id, Instant moment,OrderStatus orderStatus, User client) {
		
		this.id = id;
		this.moment = moment;
		this.client = client;
		setOrderStatus(orderStatus);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Instant getMoment() {
		return moment;
	}

	public void setMoment(Instant moment) {
		this.moment = moment;
	}

	public OrderStatus getOrderStatus() {
		return OrderStatus.valueOf(orderStatus);
	}

	public void setOrderStatus(OrderStatus orderStatus) {
		if(orderStatus != null) {
			
		this.orderStatus = orderStatus.getCode();
		
		}
	}

	public User getClient() {
		return client;
	}

	public void setClient(User client) {
		this.client = client;
	}
	
	@JsonIgnore
	public Set<OrderItem> getItems() {
		
		return items;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
	


}
