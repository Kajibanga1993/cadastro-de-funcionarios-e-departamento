package com.clinic.clinica.Service;

import java.util.List;

import com.clinic.clinica.modelo.Employees;

public interface EmployeeService {
	
	List<Employees> getAllEmployees();
	void saveEmployee(Employees employee);
	Employees getEmployeeById(long id);
	void deleteEmployeeById(long id);

}
