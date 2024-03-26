package com.IntroSB.demo.Customer;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin
@RestController
@RequestMapping("/Intro")
public class CustomerController {

	@Autowired
	CustomerService custservice;
	
	@RequestMapping(value="/createCustomer", method=RequestMethod.POST)
//	@PostMapping("/post")
	public CustomerModel createEmployee(@RequestBody CustomerModel custdetails) {
	    return custservice.createCustomer(custdetails);
	}
	
	@GetMapping("/getCustomer")
	public List<CustomerModel> getCustomer(){
		return custservice.getCustomer();	
	}
	
	@GetMapping("/getCustomerById/{id}")
	public Optional<CustomerModel> getCustomerById(@PathVariable(value= "id") long id) {
		return custservice.getCustomerById(id);
	}
	
	@PatchMapping("/patchCustomer/{id}")
	public CustomerModel updateCustomerById(@PathVariable(value = "id") long id, @RequestBody CustomerModel cust) {
		return custservice.updateEmployee(id, cust);		
	}
	
//	@RequestMapping(value="/deleteCustomer/{id}", method=RequestMethod.DELETE)
	@DeleteMapping("/deleteCustomer/{id}")
	public String deleteCustomer(@PathVariable(value="id") long id) {
		custservice.deleteCustomer(id);
		return "Customer Deleted Successfully";
	}
	
}
