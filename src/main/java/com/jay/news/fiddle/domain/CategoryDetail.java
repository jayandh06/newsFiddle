package com.jay.news.fiddle.domain;

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
	
	
}
