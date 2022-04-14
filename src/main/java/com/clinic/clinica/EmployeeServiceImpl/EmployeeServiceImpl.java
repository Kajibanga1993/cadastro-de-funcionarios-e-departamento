package com.clinic.clinica.EmployeeServiceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clinic.clinica.Service.EmployeeService;
import com.clinic.clinica.modelo.Employees;
import com.clinic.clinica.repositorio.EmployeeReposit;




@Service
public class EmployeeServiceImpl  implements EmployeeService{
	
	@Autowired
	private EmployeeReposit emplReposit;

	@Override
	public List<Employees> getAllEmployees() {
		return emplReposit.findAll();
		
	}

	@Override
	public void saveEmployee(Employees employee) {
		this.emplReposit.save(employee);
		
	}

	@Override
	public Employees getEmployeeById(long id) {
		Optional<Employees> optional = emplReposit.findById(id);
		Employees employee = null;
		
		if(optional.isPresent()) {
			
			employee = optional.get();
		}else
		{
			
		     throw new RuntimeException(" Employee not found for id :: " + id);
        }
        return employee;
    }
	

	@Override
	public void deleteEmployeeById(long id) {
		this.emplReposit.deleteById(id);
		
	}
	
	

}
