package com.mafracompany.course.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tb_product")
public class Product implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	
	@Id //CRIA A TABELA
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String description;
	private Double price;
	private String imgUrl;
	
	//GARANTE QUE A LISTA NAO COMECE NULA
	@ManyToMany //MUITOS PARA MUITOS
	//FAZ A ASSOCIAÇÃO ENTRE A CATEGORA E O PRODUTO (MANY_TO_MANY)
	@JoinTable(name = "tb_product_categorie", joinColumns = @JoinColumn(name = "product_id"), inverseJoinColumns = @JoinColumn(name = "Category_id"))//NOME DA OUTRA CLASSE PARA MESCLAR
	
	private Set<Category> categories = new HashSet<>();
	
	//SET NAO ADMITE REPETIÇÃO DO MESMO ITEM
	@OneToMany(mappedBy = "id.order")//ID.ORDER PORQUE O ORDERITEM TEM O ATRIBUTO ID E O ORDERITEM_PK TEM O ATRIBUTO ORDER
	private Set<OrderItem> items = new HashSet<>();
	
	public Product(){
		
	}
	
	public Product(Long id, String name, String description, Double price, String imgUrl) {
		
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.imgUrl = imgUrl;
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public Set<Category> getCategories() {
		
		return categories;
	}
	
	@JsonIgnore
	public Set<Order> getOrders(){
		
		Set<Order> set = new HashSet<>();
		
		//PERCORRE A COLEÇÃO ITEM - DO TIPO ORDER ITEM ASSOCIADO AO PRODUTO
		for(OrderItem x : items) {
			
			set.add(x.getOrder());//PARA CADA ELEMENTO ADICIONA O X.GET_ORDER
		}
		
		return set;
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
		Product other = (Product) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	

}
