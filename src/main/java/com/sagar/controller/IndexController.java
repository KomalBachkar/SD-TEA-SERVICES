package com.sagar.controller;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.sagar.model.Customer;
import com.sagar.model.Role;
import com.sagar.repository.CustomerRepository;
import com.sagar.service.Action;
import com.sagar.service.Constant;

@Controller
public class IndexController {

	@Autowired
	CustomerRepository customerRepository;

	@GetMapping(value = { "/", "/login", "/pages-login.html" })
	ModelAndView getIndex() {
		ModelAndView mv = new ModelAndView("pages-login");
		mv.addObject("title", Constant.TITLE);
		mv.addObject("header_name", Constant.HEADER_NAME);
		mv.addObject("action", Action.LOGIN);
		return mv;
	}

	@PostMapping(value = { "/login-validation" })
	ModelAndView getLogin(@RequestParam String email, @RequestParam String password) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("title", Constant.TITLE);
		mv.addObject("header_name", Constant.HEADER_NAME);
		mv.addObject("action", Action.LOGIN);

		Customer customer = customerRepository.findByEmail(email);

		if (customer == null) {
			mv.addObject("message", "Cutsomer is not register,please register your account then,try!");
			mv.setViewName("/pages-login");
			return mv;
		}

		if (!customer.getPassword().equalsIgnoreCase(password)) {
			mv.addObject("message", "Email & Password is not matching!");
			mv.setViewName("/pages-login");
			return mv;
		}
		mv.addObject("message", "Login is successfully!");
		mv.setViewName("/index");
		return mv;
	}

	@GetMapping(value = { "/signup", "/pages-register.html" })
	ModelAndView getSignUp() {
		ModelAndView mv = new ModelAndView("pages-register");
		mv.addObject("title", Constant.TITLE);
		mv.addObject("header_name", Constant.HEADER_NAME);
		mv.addObject("action", Action.REGISTER);
		return mv;
	}

	@PostMapping(value = { "/register" })
	ModelAndView getRegister(@RequestParam String firstName, @RequestParam String lastName, @RequestParam String email,
			@RequestParam String password, @RequestParam String mobileNumber, @RequestParam String address,
			@RequestParam String pinCode) {
		ModelAndView mv = new ModelAndView("pages-register");
		mv.addObject("title", Constant.TITLE);
		mv.addObject("header_name", Constant.HEADER_NAME);
		mv.addObject("action", Action.REGISTER);
		Customer customer = Customer.builder().firstName(firstName).lastName(lastName).email(email).password(password)
				.mobileNumber(mobileNumber).address(address).pinCode(pinCode).build();

		Role role = new Role();
		role.setRole("USER");
		customer.setRoles(Collections.singleton(role));

		if (customer != null) {
			if (customerRepository.findByEmail(email) != null) {
				mv.addObject("message", "Customer already register,please try new one!");
			} else {
				customerRepository.save(customer);
				mv.addObject("message", "Customer Registration is done successfully!");
			}

		}

		return mv;
	}

}
