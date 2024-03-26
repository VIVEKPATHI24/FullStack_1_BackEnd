package com.IntroSB.demo.Customer;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CustomerService {
	
	@Autowired
	CustomerRepository crepo;
	
	// CREATE 
	public CustomerModel createCustomer(CustomerModel cust) {
	    return crepo.save(cust);
	}

	// READ
	public List<CustomerModel> getCustomer() {
	    return crepo.findAll();
	}
	
	public Optional<CustomerModel> getCustomerById(long id) {
		return crepo.findById(id);
	}

	// DELETE
	public void deleteCustomer(Long custId) {
	    crepo.deleteById(custId);  
	    
	}

	// UPDATE
	public CustomerModel updateEmployee(Long custId, CustomerModel cust) {
		CustomerModel c = crepo.findById(custId).get();
	        c.setFirstName(cust.getFirstName());
	        c.setLastName(cust.getLastName());
	        c.setAddress(cust.getAddress());
	        c.setPhone(cust.getPhone());
	        
	        return crepo.save(c);                                
	}
}
