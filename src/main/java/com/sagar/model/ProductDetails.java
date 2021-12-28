package com.sagar.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductDetails {
	
	@Id@GeneratedValue(strategy = GenerationType.AUTO)
	private long productId; 
	
	private String item;
	
	private String quantity;
	
	private double unitPrice;

}
