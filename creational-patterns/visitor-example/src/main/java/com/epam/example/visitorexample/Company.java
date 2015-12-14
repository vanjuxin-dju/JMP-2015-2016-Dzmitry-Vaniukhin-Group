package com.epam.example.visitorexample;

import java.util.Map;
import java.util.Set;

/**
 * @author Dzmitry_Vaniukhin
 *
 */
public class Company {
	private Set<Employee> employees;
	
	private double generalSalary;
	
	private int numberOfEmployees;
	
	private double averageSalary;
	
	private Map<String, Integer> employeesPerDepartment;

	public Set<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}

	public void acceptVisitor(Visitor visitor) {
		visitor.visit(this);
	}

	public double getGeneralSalary() {
		return generalSalary;
	}

	public void setGeneralSalary(double generalSalary) {
		this.generalSalary = generalSalary;
	}

	public int getNumberOfEmployees() {
		return numberOfEmployees;
	}

	public void setNumberOfEmployees(int numberOfEmployees) {
		this.numberOfEmployees = numberOfEmployees;
	}

	public double getAverageSalary() {
		return averageSalary;
	}

	public void setAverageSalary(double averageSalary) {
		this.averageSalary = averageSalary;
	}

	public Map<String, Integer> getEmployeesPerDepartment() {
		return employeesPerDepartment;
	}

	public void setEmployeesPerDepartment(
			Map<String, Integer> employeesPerDepartment) {
		this.employeesPerDepartment = employeesPerDepartment;
	}
}
