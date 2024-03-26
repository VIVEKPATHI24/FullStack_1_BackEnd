package com.IntroSB.demo.Orders;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.IntroSB.demo.Items.ItemsRepository;
import com.IntroSB.demo.Items.ItemsService;

@Service
public class OrderService {
	
	@Autowired
	OrderRepository orepo;
	
	@Autowired
	ItemsService iservice;
	
	public OrderModel createOrder(OrderModel order) {
		var a= orepo.save(order);
		
		System.out.println("ID - " + order.getOrdItemId());
		System.out.println("Order qty - " + order.getOrdItemQty());
		iservice.updateItemQuantity(order.getOrdItemId(), order.getOrdItemQty());
		
		return a;
		
	}
	
	public List<OrderModel> getOrders(){
		return orepo.findAll();
		
	}

}
