package com.IntroSB.demo.Items;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ItemsService {
	
	@Autowired
	ItemsRepository irepo;
	
	// CREATE 
	public ItemsModel createCustomer(ItemsModel items) {
	    return irepo.save(items);
	}

	// READ
	public List<ItemsModel> getCustomer() {
	    return irepo.findAll();
	}
	
	public Optional<ItemsModel> getItemById(long id) {
		return irepo.findById(id);
	}

	// DELETE
	public void deleteCustomer(Long itemId) {
	    irepo.deleteById(itemId);  
	    
	}

	// UPDATE
	public ItemsModel updateItem(Long itemid, ItemsModel items) {
		ItemsModel i = irepo.findById(itemid).get();
	        i.setItemName(items.getItemName());
	        i.setItemQuantity(items.getItemQuantity());
	        
	        return irepo.save(i);                                
	}
	
	//	Update Quantity when order is placed for specific item
	public void updateItemQuantity(Long itemId, Long quantityToReduce) {
		ItemsModel i = irepo.findById(itemId).get();
		long updatedQuantity = i.getItemQuantity() - quantityToReduce;
        i.setItemQuantity(updatedQuantity);
        irepo.save(i);
	}
	
}
