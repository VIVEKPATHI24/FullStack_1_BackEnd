package com.IntroSB.demo.Orders;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.IntroSB.demo.Customer.CustomerModel;
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
		System.out.println("orepo.findAll()   -- " + orepo.findAll());
		return orepo.findAll();
		
	}
	
	public Optional<OrderModel> getOrderById(long id) {
		return orepo.findById(id);
	}

	// DELETE
	public void deleteOrder(Long ordId) {
	    orepo.deleteById(ordId);  
	    
	}
	
	// UPDATE
	public OrderModel updateOrder(Long ordId, OrderModel ord) {
		OrderModel c = orepo.findById(ordId).get();
	        c.setOrdItemId(ord.getOrdItemId());
	        c.setOrdItemName(ord.getOrdItemName());
	        c.setCustomerId(ord.getCustomerId());
	        c.setOrdItemQty(ord.getOrdItemId());

	        
	        return orepo.save(c);                                
	}

}
