package com.sist.food.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Entity(name="project_category") // name=> 테이블명
public class CategoryEntity {
	@Id
	private int cno;
	private String title,subject,poster,link;
}
