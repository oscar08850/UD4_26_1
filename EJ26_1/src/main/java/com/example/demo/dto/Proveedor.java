package com.example.demo.dto;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "proveedores")
public class Proveedor {

	// Atribitos

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "nombre")
	private String nombre;

	@OneToMany
	@JoinColumn(name = "id")
	private List<Suministra> suministras;

	// Constructores
	public Proveedor() {
	}

	public Proveedor(int id, String nombre, List<Suministra> suministras) {
		this.id = id;
		this.nombre = nombre;
		this.suministras = suministras;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "Suministra")
	public List<Suministra> getSuministras() {
		return suministras;
	}

	public void setSuministras(List<Suministra> suministras) {
		this.suministras = suministras;
	}

}
