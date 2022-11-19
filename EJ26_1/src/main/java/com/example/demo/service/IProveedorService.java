package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.Proveedor;

public interface IProveedorService {

	// Metodos del CRUD

	public List<Proveedor> listarProveedor(); // Listar All

	public Proveedor crearProveedor(Proveedor Proveedor); // CREATE

	public Proveedor leerProveedorById(int id); // READ

	public Proveedor actualizarProveedor(Proveedor Proveedor); // UPDATE

	public void borrarProveedorById(int id);// DELETE

}