package com.IntroSB.demo.Orders;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Intro")
public class OrderController {

	@Autowired
	OrderService oservice;
	
	@GetMapping("/getOrders")
	public List<OrderModel> getOrders(){
		 return oservice.getOrders();
	}
	
	@PostMapping("/postOrder")
	public OrderModel createOrder(@RequestBody OrderModel orddetails) {
//		System.out.println(orddetails.getOrderId());
//		System.out.println(orddetails.getOrdItemId());
//		System.out.println(orddetails.getOrdItemName());
//		System.out.println(orddetails.getOrdItemQty());
//		System.out.println(orddetails.getCustomerId());
		return oservice.createOrder(orddetails);
		
	}
	
//	public String deleteOrder(@PathVariable(value="id") long id) {
//		return oservice.
//	}
}
