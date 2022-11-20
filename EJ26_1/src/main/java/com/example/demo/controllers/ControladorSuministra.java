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

import com.example.demo.dto.Suministra;
import com.example.demo.service.SuministraServiceImpl;

@RestController
@RequestMapping("/api")
public class ControladorSuministra {

	@Autowired
	SuministraServiceImpl suministraServiceImpl;

	@GetMapping("/suministra")
	public List<Suministra> listarsuministra() {
		return suministraServiceImpl.listarSuministra();
	}

	@PostMapping("/suministra")
	public Suministra crearSuministra(@RequestBody Suministra suministra) {

		return suministraServiceImpl.crearSuministra(suministra);

	}

	@GetMapping("/suministra/{id}")
	public Suministra leerSuministra(@PathVariable(name = "id") int id) {

		Suministra suministra = new Suministra();

		suministra = suministraServiceImpl.leerSuministraById(id);

		System.out.println("Suministra segun ID: " + suministra);

		return suministra;
	}

	@PutMapping("/suministra/{id}")
	public Suministra actualizarSuministra(@PathVariable(name = "id") int id, @RequestBody Suministra suministra) {

		Suministra suministra_seleccionado = new Suministra();
		Suministra suministra_actualizado = new Suministra();

		suministra_seleccionado = suministraServiceImpl.leerSuministraById(id);

		suministra_seleccionado.setPieza(suministra.getPieza());
		suministra_seleccionado.setProveedor(suministra.getProveedor());
		suministra_seleccionado.setPrecio(suministra.getPrecio());

		suministra_actualizado = suministraServiceImpl.actualizarSuministra(suministra_seleccionado);

		System.out.println("El suministra actualizado es: " + suministra_actualizado);

		return suministra_actualizado;
	}

	@DeleteMapping("/suministra/{id}")
	public void borrarSuministra(@PathVariable(name = "id") int id) {
		suministraServiceImpl.borrarSuministraById(id);
	}

}