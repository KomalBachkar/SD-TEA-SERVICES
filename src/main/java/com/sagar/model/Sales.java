package com.sagar.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Builder.Default;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Sales {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long salesId;

	private String branchName;

	private Double totalSales;

	private String filledBy;

	@Default
	private Date createdDate=new Date();

}
