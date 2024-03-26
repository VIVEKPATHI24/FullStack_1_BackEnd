package com.IntroSB.demo.Items;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.IntroSB.demo.Customer.CustomerModel;

@Repository
public interface ItemsRepository extends JpaRepository<ItemsModel, Long> {
	

}
