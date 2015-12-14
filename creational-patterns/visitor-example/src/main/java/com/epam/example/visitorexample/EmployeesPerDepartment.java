package com.epam.example.visitorexample;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author Dzmitry_Vaniukhin
 *
 */
public class EmployeesPerDepartment implements Visitor {

	@Override
	public void visit(Company company) {
		Map<String, Integer> employeesPerDept = new HashMap<>();
		
		Iterator<Employee> it = company.getEmployees().iterator();
		while (it.hasNext()) {
			Employee employee = it.next();
			if (employeesPerDept.containsKey(employee.getDepartment())) {
				employeesPerDept.put(employee.getDepartment(), employeesPerDept.get(employee.getDepartment()) + 1);
			} else {
				employeesPerDept.put(employee.getDepartment(), 1);
			}
		}
		
		company.setEmployeesPerDepartment(employeesPerDept);
	}

}
