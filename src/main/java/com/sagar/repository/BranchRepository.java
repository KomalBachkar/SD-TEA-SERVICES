package com.sagar.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sagar.model.BranchDetails;

public interface BranchRepository extends JpaRepository<BranchDetails, Long>{

}