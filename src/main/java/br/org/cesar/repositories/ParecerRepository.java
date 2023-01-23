package br.org.cesar.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.org.cesar.entities.Parecer;

public interface ParecerRepository extends JpaRepository<Parecer, Long> {

}
