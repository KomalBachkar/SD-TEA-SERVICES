package com.sagar.controller;

import java.util.Collections;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sagar.model.Customer;
import com.sagar.model.Role;
import com.sagar.repository.CustomerRepository;
import com.sagar.service.Action;
import com.sagar.service.Constant;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class IndexController {
	
	Logger logger=LoggerFactory.getLogger(IndexController.class);

	@Autowired
	
	CustomerRepository customerRepository;

	@GetMapping(value = { "/", "/login", "/pages-login.html" })
	String getIndex(Model mv) {
		mv.addAttribute("title", Constant.TITLE);
		mv.addAttribute("header_name", Constant.HEADER_NAME);
		mv.addAttribute("action", Action.LOGIN);
		return "/pages-login";
	}
	
	@GetMapping(value = { "/pages-admin.html" })
	String getAdmin(Model mv) {
		mv.addAttribute("title", Constant.TITLE);
		mv.addAttribute("header_name", Constant.HEADER_NAME);
		mv.addAttribute("action", Action.ADMIN);
		return "/pages-admin";
	}
	
	@PostMapping(value = { "/admin-validation" })
	String getAdminLogin(@RequestParam String email, @RequestParam String password, HttpSession session,
			Model model) {
		model.addAttribute("title", Constant.TITLE);
		model.addAttribute("header_name", Constant.HEADER_NAME);
		model.addAttribute("action", Action.ADMIN);

		Customer customer = customerRepository.findByEmail(email);

		if (customer == null) {
			model.addAttribute("message", "Cutsomer is not register,please register your account then,try!");
			return "/pages-admin";
		}

		if (!customer.getPassword().equalsIgnoreCase(password)) {
			model.addAttribute("message", "Email & Password is not matching!");
			return "/pages-admin";
		}
		addUserInSession(session, customer.getEmail(), Constant.ADMIN_ROLE);
		// set the name and the id
		session.setAttribute("userModel", customer);
		session.setAttribute("userID", customer.getId());
		model.addAttribute("userClickAdminHome", true);
		model.addAttribute("companyName", Constant.HEADER_NAME);
		return "redirect:/admin/admin.html";
	}

	@PostMapping(value = { "/login-validation" })
	String getLogin(@RequestParam String email, @RequestParam String password, HttpSession session,
			Model model) {
		model.addAttribute("title", Constant.TITLE);
		model.addAttribute("header_name", Constant.HEADER_NAME);
		model.addAttribute("action", Action.LOGIN);

		Customer customer = customerRepository.findByEmail(email);

		if (customer == null) {
			model.addAttribute("message", "Cutsomer is not register,please register your account then,try!");
			return "/pages-login";
		}

		if (!customer.getPassword().equalsIgnoreCase(password)) {
			model.addAttribute("message", "Email & Password is not matching!");
			return "/pages-login";
		}
		addUserInSession(session, customer.getEmail(), Constant.USER_ROLE);
		// set the name and the id
		session.setAttribute("userModel", customer);
		session.setAttribute("userID", customer.getId());
		model.addAttribute("userClickUserHome", true);
		model.addAttribute("companyName", Constant.HEADER_NAME);
		return "redirect:/customer/index.html";
	}

	@GetMapping(value = { "/signup", "/pages-register.html" })
	String getSignUp(Model mv) {
		mv.addAttribute("title", Constant.TITLE);
		mv.addAttribute("header_name", Constant.HEADER_NAME);
		mv.addAttribute("action", Action.REGISTER);
		return "/pages-register";
	}

	@PostMapping(value = { "/register" })
	String getRegister(@RequestParam String firstName, @RequestParam String lastName, @RequestParam String email,
			@RequestParam String password, @RequestParam String mobileNumber, @RequestParam String address,
			@RequestParam String pinCode,Model mv) {
		mv.addAttribute("title", Constant.TITLE);
		mv.addAttribute("header_name", Constant.HEADER_NAME);
		mv.addAttribute("action", Action.REGISTER);
		Customer customer = Customer.builder().firstName(firstName).lastName(lastName).email(email).password(password)
				.mobileNumber(mobileNumber).address(address).pinCode(pinCode).build();

		Role role = new Role();
		role.setRole("USER");
		customer.setRoles(Collections.singleton(role));

		if (customer != null) {
			if (customerRepository.findByEmail(email) != null) {
				mv.addAttribute("message", "Customer already register,please try new one!");
			} else {
				customerRepository.save(customer);
				mv.addAttribute("message", "Customer Registration is done successfully!");
			}

		}

		return "/pages-register";
	}
	
	public void addUserInSession(HttpSession session, String email, String role) {
		try {
			session.setAttribute("email", email);
			session.setAttribute("role", role);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session, Model model) {
		session.invalidate();
		model.addAttribute("userClickHome", true);
		return "redirect:/pages-login.html";
	}
	
	@GetMapping("/admin/logout")
	public String logoutAdmin(HttpSession session, Model model) {
		session.invalidate();
		model.addAttribute("userClickAdmin", true);
		return "redirect:/pages-admin.html";
	}

}
