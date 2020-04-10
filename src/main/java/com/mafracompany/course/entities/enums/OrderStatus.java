package com.mafracompany.course.entities.enums;

public enum OrderStatus {
	
	WAITING_PAYMENT(1),
	PAID(2),
	SHIPPED(2),
	DELIVEREDE(4),
	CANCELED(5);
	
	private int code;
	
	private OrderStatus(int code) {
		
		this.code = code;
	}
	
	public int getCode() {
		
		return code;
	}
	
	//ESTATICO NAO PRECISA INSTANCIAR
	public static OrderStatus valueOf(int code) {
		
		for(OrderStatus value: OrderStatus.values()) {
			
			if(value.getCode() == code) {
				return value;
			}
		}
		
		throw new IllegalArgumentException("Invalid Orderstatus code");
	}
}