package com.sagar.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sagar.model.Customer;
import com.sagar.repository.CustomerRepository;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

   
    public List<Customer> users() {
        return customerRepository.findAll();
    }

    public String getUserUpdate(int id){
        Customer customer = customerRepository.findById(id).orElse(null);
        int isActive = customer.getStatus();
        boolean flag;

        if(isActive==0){
            customer.setStatus(1);
            flag=true;
        }
        else{
            customer.setStatus(0);
            flag=false;
        }
        customerRepository.saveAndFlush(customer);
        return (flag)? "User Activated Successfully": "User De-activated Successfully!";
    }

   

    public Customer findById(int id) {
        return customerRepository.findById(id).orElse(null);
    }

	public String getDeleteUpdate(int id) {
		
		customerRepository.deleteById(id);
		return "message=Customer is deleted successfully!";
		
	}
}
