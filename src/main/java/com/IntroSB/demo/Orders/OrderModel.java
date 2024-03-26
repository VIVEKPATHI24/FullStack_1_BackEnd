package com.IntroSB.demo.Orders;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Orders")
public class OrderModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Order_Id")
	public Long OrderId;
	
	@Column(name="Ordered_Item_Id")
	public Long OrdItemId;
	
	@Column(name="Ordered_Item_Name")
	public String OrdItemName;
	
	@Column(name="Ordered_Item_Quantity")
	public Long  OrdItemQty;
	
	@Column(name="Customer_Id")
	public Long CustomerId;

	public Long getCustomerId() {
		return CustomerId;
	}

	public void setCustomerId(Long customerId) {
		this.CustomerId = customerId;
	}

	public Long getOrderId() {
		return OrderId;
	}

	public void setOrderId(Long orderId) {
		this.OrderId = orderId;
	}

	public Long getOrdItemId() {
		return OrdItemId;
	}

	public void setOrdItemId(Long ordItemId) {
		this.OrdItemId = ordItemId;
	}

	public String getOrdItemName() {
		return OrdItemName;
	}

	public void setOrdItemName(String ordItemName) {
		this.OrdItemName = ordItemName;
	}

	public Long getOrdItemQty() {
		return OrdItemQty;
	}

	public void setOrdItemQty(Long ordItemQty) {
		this.OrdItemQty = ordItemQty;
	}
	
	
	

}
