package com.sagar.restcontroller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sagar.model.BranchDetails;
import com.sagar.model.Customer;
import com.sagar.model.ProductDetails;
import com.sagar.model.Sales;
import com.sagar.repository.BranchRepository;
import com.sagar.repository.ProductRepository;
import com.sagar.repository.SalesRepository;
import com.sagar.service.CustomerService;

@RestController
public class JSONController {
	
	@Autowired
	CustomerService customerService;
	
	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	BranchRepository branchRepository;
	
	@Autowired
	SalesRepository salesRepository;
	
	@GetMapping("/admin/all/product")
	public List<ProductDetails> getProductDetails(){
		return productRepository.findAll();
	}
	
	@GetMapping("/admin/all/branch")
	public List<BranchDetails> getBranchDetails(){
		return branchRepository.findAll();
	}
	
	@GetMapping("/admin/all/sales")
	public List<Sales> getSalesDetails(){
		return salesRepository.findAll();
	}
	
	@GetMapping("/admin/all/{id}/Users")
	public List<Customer> getList(@PathVariable("id") long id){
		return customerService.users().stream().filter(s->s.getId()!=id).collect(Collectors.toList());
	}
	
	@PutMapping("/admin/manage/{id}/activation")
    public String getUserUpdate(@PathVariable int id){
        return customerService.getUserUpdate(id);
    }
	
}
