package com.sisdcon.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Cidade implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cidade_id")
	private Integer id;

	@Column(name = "cidade_nome")
	private String nome;

	@Column(name = "cidade_codigo")
	private String codigo;

	// --- muitos pra 1

	// @Column(name="cidade_estado")

	// cidade_estado
	// ext_estado_cidade
	@ManyToOne
	@JoinColumn(name = "cidade_estado") // coluna da tabela cidade que faz referencia ao estado
	//@JsonBackReference
	//@JsonIgnore
	private Estado estado;

	public Cidade() {
	}

	public Cidade(Integer id, String nome, String codigo, Estado estado) {
		super();
		this.id = id;
		this.nome = nome;
		this.codigo = codigo;
		this.estado = estado;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cidade other = (Cidade) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
