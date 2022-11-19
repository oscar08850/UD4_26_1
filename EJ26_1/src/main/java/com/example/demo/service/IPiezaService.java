package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.Pieza;

public interface IPiezaService {

	// Metodos del CRUD

	public List<Pieza> listarPieza(); // Listar All

	public Pieza crearPieza(Pieza pieza); // CREATE

	public Pieza leerPiezaById(int id); // READ

	public Pieza actualizarPieza(Pieza pieza); // UPDATE

	public void borrarPiezaById(int id);// DELETE

}