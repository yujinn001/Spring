package com.sist.vo;

import lombok.Getter;
import lombok.Setter;

/*
 * CNO       NOT NULL NUMBER       
	CATE_NAME NOT NULL VARCHAR2(30) 
 */
@Getter
@Setter
public class GoodsCategoryVO {
	private int cno;
	private String cate_name;
}
