package com.sagar.model;

import java.sql.Date;

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
public class CustomerRequirment {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long customerId;
	private Long productId;

	private Date createdDate;

	private Date endDate;

}
