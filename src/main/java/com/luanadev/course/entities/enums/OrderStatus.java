package com.luanadev.course.entities.enums;

public enum OrderStatus {
	
	WAITING_PAYMENT(1),
	PAID(2),
	SHIPPED(3),
	DELIVERED(4),
	CANCELED(5);
	
	private int code;

	/*Do tipo private*/
	private OrderStatus(int code) {
		this.code = code;
	}
	
	/*Para ficar acessivel*/
	public int getCode() {
		return code;
	}
	
	/*Static - metodo vai funcionar sem precisar de instanciar*/
	public static OrderStatus valueOf(int code) {
		for (OrderStatus value : OrderStatus.values()) {
			if (value.getCode() == code) {
				return value;
			}
		}
		throw new IllegalArgumentException("Invalid OrderStatus code");
	}
}
