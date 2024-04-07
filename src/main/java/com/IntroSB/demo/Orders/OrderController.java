package com.IntroSB.demo.Orders;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin
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
	
////	public String deleteOrder(@PathVariable(value="id") long id) {
////		return oservice.
////	}
	@GetMapping("/getOrderById/{id}")
	public Optional<OrderModel> getOrderById(@PathVariable(value= "id") long id) {
		return oservice.getOrderById(id);
	}
	
//	@RequestMapping(value="/deleteCustomer/{id}", method=RequestMethod.DELETE)
	@DeleteMapping("/deleteOrder/{id}")
	public String deleteOrder(@PathVariable(value="id") long id) {
		oservice.deleteOrder(id);
		return "Order Deleted Successfully";
	}
}
