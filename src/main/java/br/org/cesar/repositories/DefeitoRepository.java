package br.org.cesar.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.org.cesar.entities.Defeito;

public interface DefeitoRepository extends JpaRepository<Defeito, Long> {

}
