package com.example.demo.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.Proveedor;
import com.example.demo.service.ProveedorServiceImpl;

@RestController
@RequestMapping("/api")
public class ControladorProveedor {

	@Autowired
	ProveedorServiceImpl proveedorServiceImpl;

	@GetMapping("/proveedor")
	public List<Proveedor> listarproveedor() {
		return proveedorServiceImpl.listarProveedor();
	}

	@PostMapping("/proveedor")
	public Proveedor crearProveedor(@RequestBody Proveedor proveedor) {

		return proveedorServiceImpl.crearProveedor(proveedor);

	}

	@GetMapping("/proveedor/{id}")
	public Proveedor leerProveedor(@PathVariable(name = "id") int id) {

		Proveedor proveedor = new Proveedor();

		proveedor = proveedorServiceImpl.leerProveedorById(id);

		System.out.println("Proveedor segun ID: " + proveedor);

		return proveedor;
	}

	@PutMapping("/proveedor/{id}")
	public Proveedor actualizarProveedor(@PathVariable(name = "id") int id,
			@RequestBody Proveedor proveedor) {

		Proveedor proveedor_seleccionado = new Proveedor();
		Proveedor proveedor_actualizado = new Proveedor();

		proveedor_seleccionado = proveedorServiceImpl.leerProveedorById(id);

		proveedor_seleccionado.setNombre(proveedor.getNombre());

		proveedor_actualizado = proveedorServiceImpl.actualizarProveedor(proveedor_seleccionado);

		System.out.println("El proveedor actualizado es: " + proveedor_actualizado);

		return proveedor_actualizado; 
	}

	@DeleteMapping("/proveedor/{id}")
	public void borrarProveedor(@PathVariable(name = "id") int id) {
		proveedorServiceImpl.borrarProveedorById(id);
	}

}