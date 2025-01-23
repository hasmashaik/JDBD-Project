package com.employee;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class EmployeeOperations {
	static Connection con = DBC.getConnection();
	static Scanner sc =new Scanner(System.in);
	
	public static void addEmployee(Employee emp) {
		String empName = emp.getEmpName();
		String empAddress=emp.getAddress();
		int empId = emp.getEmpId();
		double empSalary =emp.getEmpSalary();
		try {
			Statement st =con.createStatement();
			String qurrey = String.format("insert into employee values(%d, '%s', %f, '%s')" ,empId,empName, empSalary, empAddress);
			st.executeUpdate(qurrey);
			System.out.println("EMPLOYEE INSETED SUCCESSFULLY .............");
		}catch(Exception e){
			e.printStackTrace();
			
		}
	}
		public static void displayEmployes() {
			try {
				Statement st =con.createStatement();
				String query ="select * from employee";
				ResultSet rs =st.executeQuery(query);
				int count =0;
				System.out.println("ID    Name    salary    Address");
				
				while(rs.next()) {
					System.out.println(rs.getInt(1) +"  "+rs.getString(2)+"  "+rs.getDouble(3)+"  "+ rs.getString(4));
					count++;
				}
				if(count ==0) {
					System.out.println("EMPLOYEE DETAILS NOT FOUND ...");
				}
			}catch(Exception e) {
				e.printStackTrace(); 
			}
		}	
	
		public static void  updateEmployee(int empId) {
			System.out.println("ENTER NEW EMPLOYEEE NAME: ");
			String empName=sc.next();
			System.out.println("ENTER NEW EMPLOYEEE SALARY: ");
			double empSalary=sc.nextDouble();
			System.out.println("ENTER NEW EMPLOYEEE Address: ");
			String empAddress=sc.next();
			
			 try {
				 Statement st =con.createStatement();
					String qurrey = String.format("update employee set empname ='%s', empsalary=%f, empaddress='%s' where empId=%d",empName,empSalary,empAddress,empId);
					st.executeUpdate(qurrey);
					System.out.println("EMPLOYEE UPDATED SUCCESFULLY..........");
			 }catch(Exception e) {
				 e.printStackTrace();
			 }
		}
		public static void deleteEmployee(int empId) {
			try {
				 Statement st =con.createStatement();
					String qurrey = String.format("delete from employee where empId=%d", empId);
					st.executeUpdate(qurrey);
					System.out.println("EMPLOYEE DELETED SUCCESFULLY..........");
			 }catch(Exception e) {
				 e.printStackTrace();
			 }
			
		}
		public static void SearchEmployee(int empId) {
			try {
				 Statement st =con.createStatement();
					String qurrey = String.format("select * from employee where empId=%d", empId);
					ResultSet rs=st.executeQuery(qurrey);
					System.out.println("ID    Name     salary     Address");
					if(rs.next()) {
						System.out.println(rs.getInt(1) +" "+rs.getString(2)+" "+rs.getDouble(3)+" "+ rs.getString(4));
					}else {
						System.out.println("EMPLOYEE NOT FOUND ......");
					}
			 }catch(Exception e) {
				 e.printStackTrace();
			 }
			
		}
	
	}


