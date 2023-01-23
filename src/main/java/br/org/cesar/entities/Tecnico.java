package br.org.cesar.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Tecnico {

	@Id
	private long id;
	private String nomeTecnico;
	
	@OneToMany(mappedBy = "tecnico")
	private List<Parecer> pareceres;
	
	public Tecnico(){
		
	}

	public Tecnico(long id, String nomeTecnico) {
		this.id = id;
		this.nomeTecnico = nomeTecnico;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNomeTecnico() {
		return nomeTecnico;
	}

	public void setNomeTecnico(String nomeTecnico) {
		this.nomeTecnico = nomeTecnico;
	}
	
	
}
