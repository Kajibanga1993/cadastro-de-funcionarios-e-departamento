package com.clinic.clinica.departamentoService;

import java.util.List;

import com.clinic.clinica.modelo.Departamento;


public interface DepartamentoService {
	
	List<Departamento> getAllDepartamentos();
	void saveDepartamento(Departamento departamento);
	Departamento getDepartamentoById(long id);
	void deleteDepartamentoById(long id);

}



