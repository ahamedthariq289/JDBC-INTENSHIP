package in.kce.main;

import java.util.Scanner;

import in.kce.service.EmployeeService;

public class TestEmployee {
public static void main(String[] args) {
	Scanner in=new Scanner(System.in);
	//switch for menu
	System.out.println("Employee Management"
			+ "1. Store Employee"
			+ "2. Update Employee"
			+ "3. Fetch one Employee"
			+ "4. Fetch All Employee"
			+ "5. Delete Employee");
	int option=new Scanner(System.in).nextInt();
	switch (option) {
	case 1: {
		//Get 3 inputs
		System.out.println("enter values");
		int id=in.nextInt();
		String name=in.next();
		String des=in.next();
		
		
		EmployeeService employeeService=new EmployeeService();
		boolean result=employeeService.saveEmployee(id,name,des);
		if(result) {
		System.out.println("sucess");	
		}
	}
	default:
		throw new IllegalArgumentException("Unexpected value: " + option);
	}
	
}
}
