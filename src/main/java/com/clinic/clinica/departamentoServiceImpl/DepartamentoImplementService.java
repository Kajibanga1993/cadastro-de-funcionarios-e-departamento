package com.clinic.clinica.departamentoServiceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.clinic.clinica.DepartamentoRepositorio.DepartamentoRepositorio;
import com.clinic.clinica.departamentoService.DepartamentoService;
import com.clinic.clinica.modelo.Departamento;


@Service
public class DepartamentoImplementService implements DepartamentoService{
    private DepartamentoRepositorio departamentoRepositorio;
    
	
	
	
	@Override
	public List<Departamento> getAllDepartamentos() {
		// TODO Auto-generated method stub
		return this.departamentoRepositorio.findAll();
	}

	@Override
	public void saveDepartamento(Departamento departamento) {
		this.departamentoRepositorio.save(departamento);
		
	}

	@Override
	public Departamento getDepartamentoById(long id) {
		Optional<Departamento> optional = departamentoRepositorio.findById(id);
		Departamento departamento =null;
		
		if(optional.isPresent()) {
			departamento = optional.get();
		}else
		
		{
			
		     throw new RuntimeException(" Employee not found for id :: " + id);
        }
        return departamento;
	}

	@Override
	public void deleteDepartamentoById(long id) {
		this.departamentoRepositorio.deleteById(id);
		
	}
	
	
	
	

}
