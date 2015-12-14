package com.epam.example.visitorexample;

import java.util.Iterator;

/**
 * @author Dzmitry_Vaniukhin
 *
 */
public class TotalSalariesCounter implements Visitor {

	@Override
	public void visit(Company company) {
		double totalSalaries = 0.0;
		Iterator<Employee> it = company.getEmployees().iterator();
		while (it.hasNext()) {
			totalSalaries += it.next().getSalary();
		}
		
		company.setGeneralSalary(totalSalaries);
	}

}
