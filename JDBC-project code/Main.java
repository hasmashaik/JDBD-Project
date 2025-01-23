package com.employee;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
	System.out.println("..................WELCOME TO EMPLOYEE MANAGEMENT APPLICATION");
	boolean isExit=false;
	while(!isExit) {
		System.out.println("1.Add the Employee");
		System.out.println("2.Display the Employee");
		System.out.println("3.Update the Employee");
		System.out.println("4.Delete the Employee");
		System.out.println("5.Search  the Employee");
		System.out.println("6.Exit");
		System.out.println("PLEASE SELECT THE BELOW OPTIONS:");
		int op=sc.nextInt();
		switch(op) {
		case 1:{
			System.out.println("ENTER THE EMPLOYEE ID: ");
			int empId=sc.nextInt();
			System.out.println("ENTER THE EMPLOYEE NAME: ");
			String empName=sc.next();
			System.out.println("ENTER THE EMPLOYEE SALARY: ");
			double empSalary=sc.nextDouble();
			System.out.println("ENTER EMPLOYEE ADDRESS: ");
			String empAddress=sc.next();
			Employee emp= new Employee(empName,empId, empSalary,empAddress);
			EmployeeOperations.addEmployee(emp);
			break;	
		}
	    case 2:
			EmployeeOperations.displayEmployes();
		break; 
	    case 3:{
	    	System.out.println("ENTER EMPLOYEE ID TO UPDATE");
	    	int empId=sc.nextInt();
	    	EmployeeOperations.updateEmployee(empId);break;
	    }
	    case 4:{
	    	System.out.println("ENTER EMPLOYEEE ID TO DELETE ");
	    	int empId=sc.nextInt();
	    	EmployeeOperations.deleteEmployee(empId);
	    }
	    case 5:{
	    	System.out.println("ENTER EMPLOYEE ID TO SEARCH");
	    	int empId = sc.nextInt();
	    	EmployeeOperations.SearchEmployee(empId);
	    }
	    case 6:isExit=true;
	    	System.out.println("......THANK YOU FOR USING OUR APPLICATION....VISIT AGAIN......");
	    	
	    	default:
	    		System.out.println("PLEASE SELECT THE VALIDE OPTION....");
	    	
		}
		

	}
	

}
}
