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
public class BranchDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private String branchName;

	private String branchLocation;

	private String branchOwnerName;

	private String branchAddress;

	private String emailId;

	private String contactNumber;

	private Date createdDate;

}
