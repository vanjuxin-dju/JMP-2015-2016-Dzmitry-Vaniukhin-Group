package com.epam.example.visitorexample;

/**
 * @author Dzmitry_Vaniukhin
 *
 */
public class EmployeeCounter implements Visitor {

	@Override
	public void visit(Company company) {
		company.setNumberOfEmployees(company.getEmployees().size());
	}

}
