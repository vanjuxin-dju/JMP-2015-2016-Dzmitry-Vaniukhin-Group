package com.epam.example.visitorexample;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;

/**
 * @author Dzmitry_Vaniukhin
 *
 */
public class App {

	public static void main(String[] args) {
		Company company = new Company();
		company.setEmployees(new HashSet<Employee>(Arrays.asList(new Employee[] {
				new Employee("dmitry", "java", 450.0),
				new Employee("andrey", "dotnet", 850.0),
				new Employee("vasiliy", "testing", 750.0),
				new Employee("anna", "java", 950.0),
				new Employee("zhanna", "java", 1650.0),
				new Employee("alexander", "dotnet", 450.0),
				new Employee("sergey", "testing", 650.0),
				new Employee("pyotr", "testing", 1050.0),
				new Employee("nikolay", "java", 750.0),
				new Employee("philipp", "dotnet", 450.0)
		}))); // 10 employees
		company.acceptVisitor(new EmployeeCounter());
		System.out.println("Number of employees: " + company.getNumberOfEmployees());
		company.acceptVisitor(new TotalSalariesCounter());
		System.out.println("General salary: " + company.getGeneralSalary());
		company.acceptVisitor(new AverageSalaryCounter());
		System.out.println("Average salary: " + company.getAverageSalary());
		company.acceptVisitor(new EmployeesPerDepartment());
		Map<String, Integer> empsPerDept = company.getEmployeesPerDepartment();
		System.out.println("Employees per department");
		for (String dept: empsPerDept.keySet()) {
			System.out.println(dept + " department has " + empsPerDept.get(dept) + " employees");
		}

	}

}
