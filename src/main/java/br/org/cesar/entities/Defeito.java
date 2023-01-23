package br.org.cesar.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Defeito {

	@Id
	private long id;
	private String tipoDefeito;
	
	@OneToMany(mappedBy = "defeito")
	private List<Parecer> pareceres;
	
	public Defeito() {
		
	}

	public Defeito(long id, String tipoDefeito) {
		this.id = id;
		this.tipoDefeito = tipoDefeito;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTipoDefeito() {
		return tipoDefeito;
	}

	public void setTipoDefeito(String tipoDefeito) {
		this.tipoDefeito = tipoDefeito;
	}
	
	
	
}
