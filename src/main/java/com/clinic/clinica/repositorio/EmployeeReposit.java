package com.clinic.clinica.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.clinic.clinica.modelo.Employees;

public interface EmployeeReposit  extends JpaRepository<Employees,Long>{

}
