package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.SyncAsync.MyDBConnections;
import dal.model.Employee;

public class EmployeeDaoImp implements EmployeeDao{

	Connection con;
	PreparedStatement ps;
	Statement stmt;
	ResultSet rs;
	
	
	@Override
	public void insertEmployee(Employee emp) {
	     
		try {
			con  = MyDBConnections.getDbConnection();
			ps=con.prepareStatement("insert into dele values(?,?)");
			
			ps.setInt(1, emp.getEid());
			ps.setString(2, emp.getEname());
			int noofrows = ps.executeUpdate();
			System.out.println(noofrows  + " got inserted... ");
		} catch (SQLException e) {

			e.printStackTrace();
		}
		
		
	}

	@Override
	public void showEmployee() {	
		try {
			con  = MyDBConnections.getDbConnection();
			stmt= con.createStatement();
			rs = stmt.executeQuery("select * from project");
			while(rs.next()) {
				System.out.println(rs.getInt(1) + " -- " + rs.getString(2));
				
			}
			
			
		} catch (SQLException e) {

			e.printStackTrace();
		}
		
		
	}

	@Override
	public void updateEmployee(Employee emp) throws SQLException {
		try {
			con = MyDBConnections.getDbConnection();
	        String sql = "UPDATE project SET CUSTOMERNAME='Malhotra' WHERE CUSTOMERID=1234";
	        ps = con.prepareStatement(sql);
	        ps.setString(1, emp.getEname());
	        ps.setInt(2, emp.getEid());
	        int i = ps.executeUpdate(sql);
			System.out.println(i+" updated");
		}catch (SQLException e) {
			e.printStackTrace();
			}
	}

	@Override
	public void deleteEmployee(int id) {
		
		try{		   
			con = MyDBConnections.getDbConnection();
			String sql = "delete from dele where EMPID="+id;
			ps = con.prepareStatement(sql);
			int result = ps.executeUpdate(sql);
			System.out.println("Number of records affected :: " + result);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} 
	}

}
