package br.org.cesar.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.org.cesar.entities.Tecnico;
import br.org.cesar.repositories.TecnicoRepository;

@RestController
@RequestMapping(value = "/Tecnico")
public class TecnicoController {

	@Autowired
	private TecnicoRepository repository;

	@GetMapping
	public List<Tecnico> findAll() {
		List<Tecnico> result = repository.findAll();
		return result;
	}

	@GetMapping(value = "/{id}")
	public Tecnico findById(@PathVariable Long id) {
		Tecnico result = repository.findById(id).get();
		return result;
	}
	@PostMapping
	public Tecnico insert(@RequestBody Tecnico tecnico){
		Tecnico result = repository.save(tecnico);
		return result;
	}

}
