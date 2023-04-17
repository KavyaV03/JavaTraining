package com.dao;

import dal.model.Employee;

import java.sql.SQLException;
import java.util.Scanner;

public class MainClassDao {
	public static void main(String[] args) throws SQLException {
//		Scanner sc = new Scanner(System.in);
//		System.out.println("Enter Customer Id:");
//        int customerId=sc.nextInt();
//        System.out.println("Enter Customer Name:");
//        String customerName=sc.next();
//        
	EmployeeDaoImp empdao = new EmployeeDaoImp();
//	empdao.insertEmployee(new Employee(customerId,customerName));
//	empdao.showEmployee();
//	empdao.updateEmployee(new Employee(customerId,customerName));
	empdao.deleteEmployee(1);
	}

}
