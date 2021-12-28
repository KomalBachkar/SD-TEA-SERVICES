package com.sagar.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sagar.dto.ProductDetailsDTO;
import com.sagar.service.Constant;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/customer")
@Slf4j
public class CustomerController {

	Logger logger = LoggerFactory.getLogger(CustomerController.class);

	@GetMapping(value={"/index","/index.html"})
	public String getDashboard(Model model) {
		model.addAttribute("command", new ProductDetailsDTO());
		model.addAttribute("userClickUserHome", true);
        model.addAttribute("companyName", Constant.HEADER_NAME);
		return "index";
	}

}
