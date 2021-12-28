package com.sagar.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Sales {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long salesId;

	private String branchName;

	private Double totalSales;

	private String filledBy;

	private Date createdDate;

}
