package br.org.cesar.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Equipamento {

	@Id
	private long id;
	
	private String aparelho;
	
	@OneToMany(mappedBy = "equipamento")
	private List<Parecer> pareceres;
	
	public Equipamento() {
		
	}

	public Equipamento(long id, String aparelho) {
		this.id = id;
		this.aparelho = aparelho;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAparelho() {
		return aparelho;
	}

	public void setAparelho(String aparelho) {
		this.aparelho = aparelho;
	}
	
	
}
