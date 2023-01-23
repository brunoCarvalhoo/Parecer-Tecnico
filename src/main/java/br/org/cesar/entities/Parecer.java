package br.org.cesar.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Parecer {
	
	@Id
	private long id;
	private String parecer;
	
	@ManyToOne
	@JoinColumn(name = "id_defeito")
	private Defeito defeito;
	@ManyToOne
	@JoinColumn(name = "id_equipamento")
	private Equipamento equipamento;
	@ManyToOne
	@JoinColumn(name = "id_tecnico")
	private Tecnico tecnico;
	@ManyToOne
	@JoinColumn(name = "id_cliente")
	private Cliente cliente;
	
	
	public Parecer() {
		
	}

	public Parecer(long id, String parecer, Defeito defeito, Equipamento equipamento, Tecnico tecnico, Cliente cliente) {
		this.id = id;
		this.parecer = parecer;
		this.defeito = defeito;
		this.equipamento = equipamento;
		this.tecnico = tecnico;
		this.cliente = cliente;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getParecer() {
		return parecer;
	}

	public void setParecer(String parecer) {
		this.parecer = parecer;
	}

	public Defeito getDefeito() {
		return defeito;
	}

	public void setDefeito(Defeito defeito) {
		this.defeito = defeito;
	}

	public Equipamento getEquipamento() {
		return equipamento;
	}

	public void setEquipamento(Equipamento equipamento) {
		this.equipamento = equipamento;
	}

	public Tecnico getTecnico() {
		return tecnico;
	}

	public void setTecnico(Tecnico tecnico) {
		this.tecnico = tecnico;
	}
	
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
}
