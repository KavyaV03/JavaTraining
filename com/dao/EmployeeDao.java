package com.dao;

import java.sql.SQLException;

import dal.model.Employee;

public interface EmployeeDao {
	
	public void insertEmployee(Employee emp);
	public void showEmployee();
	public void updateEmployee(Employee emp) throws SQLException;
	public void deleteEmployee(int eid);

}
