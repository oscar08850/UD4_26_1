package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.Suministra;

public interface ISuministraService {

	// Metodos del CRUD

	public List<Suministra> listarSuministra(); // Listar All

	public Suministra crearSuministra(Suministra suministra); // CREATE

	public Suministra leerSuministraById(int id); // READ

	public Suministra actualizarSuministra(Suministra suministra); // UPDATE

	public void borrarSuministraById(int id);// DELETE

}