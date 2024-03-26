package com.IntroSB.demo.Customer;

import org.apache.el.parser.AstInteger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerModel, Long> {
	

}
