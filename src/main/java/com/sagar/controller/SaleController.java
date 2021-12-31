package com.sagar.controller;

import java.sql.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sagar.model.Sales;
import com.sagar.repository.SalesRepository;
import com.sagar.service.Constant;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/admin")
@Slf4j
public class SaleController {

	@Autowired
	SalesRepository salesRepository;
	
	@GetMapping(value={"/sales.html"})
	public String getSales(Model model,HttpServletRequest request) {
		
		HttpSession session = request.getSession(false);
		Object customer=session.getAttribute("userModel");
		
		if(customer==null) {
			session.invalidate();
			return "redirect:/pages-admin.html";
		}
		model.addAttribute("title", Constant.TITLE);
		model.addAttribute("header_name", Constant.HEADER_NAME);
		model.addAttribute("userClickSalesAdmin", true);
		model.addAttribute("action", "/admin/salesSave.html");
        model.addAttribute("companyName", Constant.HEADER_NAME);
		return "index";
	}

	@GetMapping(value={"/sales-details.html"})
	public String getSalesDetails(Model model,HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		Object customer=session.getAttribute("userModel");
		
		if(customer==null) {
			session.invalidate();
			return "redirect:/pages-admin.html";
		}
		model.addAttribute("title", Constant.TITLE);
		model.addAttribute("header_name", Constant.HEADER_NAME);
		model.addAttribute("userClickSalesDetailsAdmin", true);
        model.addAttribute("companyName", Constant.HEADER_NAME);
        model.addAttribute("action", "/admin/salesSave.html");
		return "index";
	}

	
	@PostMapping("/salesSave.html")
	private String productSave(@RequestParam String branchName,
			@RequestParam Double totalSales,
			@RequestParam String filledBy,
			Model model,HttpServletRequest request
			) {
		HttpSession session = request.getSession(false);
		Object customer=session.getAttribute("userModel");
		
		if(customer==null) {
			session.invalidate();
			return "redirect:/pages-admin.html";
		}
	
		Sales sales=Sales.builder().branchName(branchName).totalSales(totalSales).
				filledBy(filledBy).build();
		if(sales==null) {
			model.addAttribute("message", "Sales Record is not added successfully!");
		}
		salesRepository.save(sales);
		model.addAttribute("message", "Sales Record is added successfully!");
		return "index";
	}

	@GetMapping("/salesReports")
	private String getSales(@RequestParam String branchName, @RequestParam Date fromDate,
			@RequestParam Date toDate,HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		Object customer=session.getAttribute("userModel");
		
		if(customer==null) {
			session.invalidate();
			return "redirect:/pages-admin.html";
		}
		salesRepository.findBycreatedDateBetween(fromDate, toDate);
		return "index";
	}

}
