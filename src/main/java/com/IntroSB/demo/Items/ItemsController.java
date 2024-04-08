package com.IntroSB.demo.Items;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin()
@RestController
@RequestMapping("/Intro")
public class ItemsController {
	
	@Autowired
	ItemsService itemservice;
	
	@RequestMapping(value="/createItem", method=RequestMethod.POST)
	public ItemsModel createItem(@RequestBody ItemsModel itemdetails) {
	    return itemservice.createCustomer(itemdetails);
	}
	
	@GetMapping("/getItem")
	public List<ItemsModel> getItem(){
		return itemservice.getCustomer();	
	}
	
	@GetMapping("/getItem/{id}")
	public Optional <ItemsModel> getItemById(@PathVariable(value= "id") long id){
		return itemservice.getItemById(id);
	}
	
	@PatchMapping("/patchItem/{id}")
	public ItemsModel getItemById(@PathVariable(value = "id") long id, @RequestBody ItemsModel itemdetails) {
		return itemservice.updateItem(id, itemdetails);
				
	}
	
//	@RequestMapping(value="/deleteCustomer/{id}", method=RequestMethod.DELETE)
	@DeleteMapping("/deleteItem/{id}")
	public String deleteItem(@PathVariable(value="id") long id) {
		itemservice.deleteCustomer(id);
		return "Item Deleted Successfully";
	}

}
