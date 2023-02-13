package com.sist.dao;
import java.util.*;

import java.sql.*;
import com.sist.commons.*;
public class EmpDAO {
	private Connection conn;
	private PreparedStatement ps;
	private DataSource ds;
	public EmpDAO(DataSource ds)
	{
		this.ds=ds;
		try
		{
			Class.forName(ds.getDriver());
		}catch(Exception ex) {}
	}
	public void getConnection()
	{
		try
		{
			conn=DriverManager.getConnection(ds.getUrl(),ds.getUser(),ds.getPassword());
		}catch(Exception ex) {}
	}
	public void disConnection()
	{
		try
		{
			if(conn!=null)conn.close();
			if(ps!=null)ps.close();
		}catch(Exception ex) {}
	}
	public List<EmpVO> empListData()
	{
		List<EmpVO> list= new ArrayList<EmpVO>();
		try
		{
			getConnection();
			String sql="select empno,ename,job from emp";
			ps=conn.prepareStatement(sql);
			ResultSet rs= ps.executeQuery();
			while(rs.next())
			{
				EmpVO vo = new EmpVO();
				vo.setEmpno(rs.getInt(1));
				vo.setEname(rs.getString(2));
				vo.setJob(rs.getString(3));
				list.add(vo);
			}
		}catch(Exception ex) 
		{
			ex.printStackTrace();
		}
		finally
		{
			disConnection();
		}
		return list;
	}
}
