package br.org.cesar.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.org.cesar.entities.Defeito;
import br.org.cesar.repositories.DefeitoRepository;

@RestController
@RequestMapping(value = "/Defeito")
public class DefeitoController {

	@Autowired
	private DefeitoRepository repository;

	@GetMapping
	public List<Defeito> findAll() {
		List<Defeito> result = repository.findAll();
		return result;
	}

	@GetMapping(value = "/{id}")
	public Defeito findById(@PathVariable Long id) {
		Defeito result = repository.findById(id).get();
		return result;
	}

}
