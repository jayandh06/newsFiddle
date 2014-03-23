package com.company.rssfiddle.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="categorydetail")
public class CategoryDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int catDetailId;	
	
	
	@Column(name="rssUrl")
	private String rssUrl;
	
	@Column(name="company")
	private String company;
	
	@Column(name="companyUrl")
	private String companyUrl;
	
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="categoryId",referencedColumnName="categoryId",nullable=false,unique=true)
	private Category category;


	public int getCatDetailId() {
		return catDetailId;
	}


	public void setCatDetailId(int catDetailId) {
		this.catDetailId = catDetailId;
	}


	public String getRssUrl() {
		return rssUrl;
	}


	public void setRssUrl(String rssUrl) {
		this.rssUrl = rssUrl;
	}


	public String getCompany() {
		return company;
	}


	public void setCompany(String company) {
		this.company = company;
	}


	public String getCompanyUrl() {
		return companyUrl;
	}


	public void setCompanyUrl(String companyUrl) {
		this.companyUrl = companyUrl;
	}


	public Category getCategory() {
		return category;
	}


	public void setCategory(Category category) {
		this.category = category;
	}
	
	
}
