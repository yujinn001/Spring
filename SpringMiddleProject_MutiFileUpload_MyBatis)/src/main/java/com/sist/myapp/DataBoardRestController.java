package com.sist.myapp;
import java.util.*;
import com.sist.dao.*;
import java.io.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
// Rest : 자바와 (?) 연동
@RestController
public class DataBoardRestController {
	@Autowired
	private DataBoardDAO dao; // setterDI
	
	@PostMapping("databoard/delet.do")
	public String databoard_delete(int no, String pwd)
	{
		String result="";
		try
		{
			DataBoardVO vo =dao.databoardFileInfoData(no);
			if(vo.getFilecount()>0)
			{
				String[] fn=vo.getFilename().split(",");
				for(String f:fn)
				{
					File file=new File("c:\\Download\\"+f);
					file.delete(); // 폴더에 있는 파일 지우기
				}
			}
		}catch(Exception ex) {}
		boolean bCheck=dao.databoardDelete(no, pwd);
		if(bCheck==true)
			result="yes";
		else
			result="no";
		return result;
	}
	
	@PostMapping("databoard/pwd_check.do")
	public String pwd_check(int no,String pwd)
	{
		String result="";
		boolean bCheck=dao.pwdCheck(no, pwd);
		if(bCheck==true)
			result="yes";
		else
			result="no";
		
		return result;
	}
}
























