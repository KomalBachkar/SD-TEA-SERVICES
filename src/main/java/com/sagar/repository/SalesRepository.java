package com.sagar.repository;



import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sagar.model.Sales;

public interface SalesRepository extends JpaRepository<Sales, Long>{
	
	
	public List<Sales> findBycreatedDateBetween(Date fromDate,Date toDate);

}
