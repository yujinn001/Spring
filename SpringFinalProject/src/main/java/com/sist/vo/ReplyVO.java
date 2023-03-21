package com.sist.vo;

import lombok.Getter;
import lombok.Setter;
import java.util.*;

@Getter
@Setter
public class ReplyVO {
	private int rno,type,no;
	private String id,name,msg,dbday;
	private Date regdate;
}
