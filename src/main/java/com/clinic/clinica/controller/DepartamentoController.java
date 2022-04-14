package com.clinic.clinica.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.clinic.clinica.departamentoServiceImpl.DepartamentoImplementService;
import com.clinic.clinica.modelo.Departamento;


@Controller
public class DepartamentoController {
	
	
	@Autowired
	DepartamentoImplementService departamento;
	
	
	@GetMapping("/formularioDepartamento")
	public String formularioDepartamento(Model model) {
		Departamento departamento = new Departamento();
		model.addAttribute("departamento", departamento);
		return "nvo_departamento";
		
	}
	
	
	@PostMapping("/saveDepartamento")
	public String saveDepartamento(@ModelAttribute("departamento") Departamento dep) {
	
		departamento.saveDepartamento(dep);
		return "redirect:/departamento";
		
	}
	
	
	
	@GetMapping("/departamento")
	public String paginaInicial(Model model) {
		model.addAttribute("listaDepartamento", departamento.getAllDepartamentos());
		return "index_departamento";
	}
	
	
	@GetMapping("/formularioAtualizacao/{id}")
	public String formularioAtualizacao(@PathVariable(value="id") long id, Model model) {
		
		
	Departamento departamentos =departamento.getDepartamentoById(id);
	model.addAttribute("departamento", departamentos);
	return "atualizacao_departamento";
		
	}
	
	
	 @GetMapping("/deleteDepartamento/{id}")
	 public String deleteEmployee(@PathVariable(value = "id") long id) {
		 
		 
		this.departamento.deleteDepartamentoById(id);
		return "redirect:/departamento";

}}
