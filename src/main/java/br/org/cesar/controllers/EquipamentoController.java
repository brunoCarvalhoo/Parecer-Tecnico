package br.org.cesar.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.org.cesar.entities.Equipamento;
import br.org.cesar.repositories.EquipamentoRepository;

@RestController
@RequestMapping(value = "/Equipamento")
public class EquipamentoController {

	@Autowired
	private EquipamentoRepository repository;

	@GetMapping
	public List<Equipamento> findAll() {
		List<Equipamento> result = repository.findAll();
		return result;
	}

	@GetMapping(value = "/{id}")
	public Equipamento findById(@PathVariable Long id) {
		Equipamento result = repository.findById(id).get();
		return result;
	}

}
