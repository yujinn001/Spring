package com.sist.web.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
/*
 * cno int AI PK 
title varchar(1000) 
subject varchar(1000) 
poster varchar(500) 
link varchar(200)
 */
@Getter 
@Setter

@Entity
@Table(name="project_category")
public class CategoryEntity {
	@Id
	private int cno;
	private String title,subject,poster,link;
}
