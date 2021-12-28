package com.sagar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sagar.model.BranchDetails;
import com.sagar.model.ProductDetails;
import com.sagar.repository.BranchRepository;
import com.sagar.repository.ProductRepository;
import com.sagar.service.Constant;
import com.sagar.service.CustomerService;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	CustomerService customerService;
	
	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	BranchRepository branchRepository;

	@GetMapping("/admin.html")
	public String getAdmin(Model model) {
		model.addAttribute("userClickAdminDashboardHome", true);
		model.addAttribute("companyName", Constant.HEADER_NAME);
		return "/index";
	}

	@RequestMapping("/{id}/delete")
	public String getUserDelete(@PathVariable int id,Model model) {
		model.addAttribute("message", customerService.getDeleteUpdate(id));
		model.addAttribute("userClickAdminDashboardHome", true);
		model.addAttribute("companyName", Constant.HEADER_NAME);
		return "/index";
	}
	
	@GetMapping("/product.html")
	public String getProduct(Model model) {
		model.addAttribute("userClickAdminProductHome", true);
		model.addAttribute("companyName", Constant.HEADER_NAME);
		model.addAttribute("action", "/admin/product-add.html");
		return "/index";
	}
	
	@PostMapping("/product-add.html")
	public String getProductAdd(@RequestParam String item,@RequestParam double unitPrice,@RequestParam String quantity, Model model) {
		model.addAttribute("userClickAdminProductHome", true);
		model.addAttribute("companyName", Constant.HEADER_NAME);
		model.addAttribute("action", "/admin/product-add.html");
		
		ProductDetails productDetails=ProductDetails.builder().item(item).unitPrice(unitPrice).quantity(quantity).build();
		if(productDetails==null) {
			model.addAttribute("message", "Product is not inserted successfully!");
			return "/index";
		}
		productRepository.save(productDetails);
		model.addAttribute("message", "Product is inserted successfully!");
		return "/index";
	}
	
	@GetMapping("/product-details.html")
	public String getProductList(Model model) {
		model.addAttribute("userClickAdminProductDetailsHome", true);
		model.addAttribute("companyName", Constant.HEADER_NAME);
		return "/index";
	}
	
	@GetMapping("/product-requirement.html")
	public String getProductRequirement(Model model) {
		model.addAttribute("userClickAdminProductRequirementHome", true);
		model.addAttribute("companyName", Constant.HEADER_NAME);
		return "/index";
	}
	
	@GetMapping("/branch.html")
	public String getBranch(Model model) {
		model.addAttribute("userClickAdminBranch", true);
		model.addAttribute("companyName", Constant.HEADER_NAME);
		model.addAttribute("action", "/admin/branch-add.html");
		return "/index";
	}
	
	@PostMapping("/branch-add.html")
	public String getAddBranch(Model model,
			@RequestParam String branchName,
			@RequestParam String branchLocation,
			@RequestParam String branchOwnerName,
			@RequestParam String branchAddress,
			@RequestParam String emailId,
			@RequestParam String contactNumber,
			@RequestParam String createdDate
			) {
		model.addAttribute("userClickAdminBranch", true);
		model.addAttribute("companyName", Constant.HEADER_NAME);
		model.addAttribute("action", "/admin/branch-add.html");
		
		BranchDetails branch=BranchDetails.builder()
				.branchName(branchName)
				.branchLocation(branchLocation)
				.branchOwnerName(branchOwnerName)
				.branchAddress(branchAddress)
				.contactNumber(contactNumber)
				.createdDate(null).build();
		
		if(branch==null) {
			model.addAttribute("message", "Branch is not inserted successfully!");
			return "/index";
		}
		branchRepository.save(branch);
		model.addAttribute("message", "Branch is inserted successfully!");
		return "/index";
	}
	
	@GetMapping("/branch-details.html")
	public String getBranchList(Model model) {
		model.addAttribute("userClickAdminBranchDetails", true);
		model.addAttribute("companyName", Constant.HEADER_NAME);
		return "/index";
	}
}
