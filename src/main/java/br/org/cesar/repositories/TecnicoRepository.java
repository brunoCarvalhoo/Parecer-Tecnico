package br.org.cesar.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.org.cesar.entities.Tecnico;

public interface TecnicoRepository extends JpaRepository<Tecnico, Long>{

}
