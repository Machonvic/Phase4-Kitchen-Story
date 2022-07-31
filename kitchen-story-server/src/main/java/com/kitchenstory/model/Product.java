package com.kitchenstory.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "product")
public class Product {
	
	public Product() {
		super();
	}

	public Product(String aproductname, String bproductcategory, BigDecimal cprice,String dimagename ) {
		
		this.dimagename = dimagename;
		this.cprice = cprice;
		this.bproductcategory = bproductcategory;
		this.aproductname = aproductname;
	}

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "productname")
	private String aproductname;

	@Column(name = "productcategory")
	private String bproductcategory;
	
	@Column(name = "price")
   	private BigDecimal cprice;
	
	@Column(name = "imagename")
	private String dimagename;
	
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAproductname() {
		return aproductname;
	}

	public void setAproductname(String aproductname) {
		this.aproductname = aproductname;
	}

	public String getBproductcategory() {
		return bproductcategory;
	}

	public void setBproductcategory(String bproductcategory) {
		this.bproductcategory = bproductcategory;
	}

	public BigDecimal getCprice() {
		return cprice;
	}

	public void setCprice(BigDecimal cprice) {
		this.cprice = cprice;
	}

	public String getDimagename() {
		return dimagename;
	}

	public void setDimagename(String dimagename) {
		this.dimagename = dimagename;
	}


	


}
