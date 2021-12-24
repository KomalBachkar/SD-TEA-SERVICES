package com.sagar.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sagar.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {

	Customer findByEmail(String email);
    Optional<Customer> findById(int id);


}
