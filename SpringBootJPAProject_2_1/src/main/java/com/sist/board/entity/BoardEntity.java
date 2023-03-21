package com.sist.board.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrePersist;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name="board")
public class BoardEntity {
	@Id // 자동 증가 번호 생성 => 중복이 없는 속성
	private int no;
	
	private String name,subject,content,pwd;
	private int hit;
	private LocalDateTime regdate;
	
	@PrePersist // 날짜 가져올때 => 등록하는 방법
	public void refdate() {
	   this.regdate=LocalDateTime.now();
	}
}
