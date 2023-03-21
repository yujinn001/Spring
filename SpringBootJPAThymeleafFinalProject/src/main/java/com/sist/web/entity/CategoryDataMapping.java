package com.sist.web.entity;

public interface CategoryDataMapping {
	// sql 쿼리에서 일부만 가져올경우 매핑 시켜준다
	public int getCno();
	public String getTitle();
	public String getPoster();
	
}
