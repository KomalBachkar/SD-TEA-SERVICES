package com.sagar.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDetailsDTO {

	private String item;

	private String quantity;

	private double unitPrice;

}
