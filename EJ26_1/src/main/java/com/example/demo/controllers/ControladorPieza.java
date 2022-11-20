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

import com.example.demo.dto.Pieza;
import com.example.demo.service.PiezaServiceImpl;

@RestController
@RequestMapping("/api")
public class ControladorPieza {

	@Autowired
	PiezaServiceImpl piezaServiceImpl;

	@GetMapping("/pieza")
	public List<Pieza> listarpieza() {
		return piezaServiceImpl.listarPieza();
	}

	@PostMapping("/pieza")
	public Pieza crearPieza(@RequestBody Pieza pieza) {

		return piezaServiceImpl.crearPieza(pieza);

	}

	@GetMapping("/pieza/{id}")
	public Pieza leerPieza(@PathVariable(name = "id") int id) {

		Pieza pieza = new Pieza();

		pieza = piezaServiceImpl.leerPiezaById(id);

		System.out.println("Pieza segun ID: " + pieza);

		return pieza;
	}

	@PutMapping("/pieza/{id}")
	public Pieza actualizarPieza(@PathVariable(name = "id") int id,
			@RequestBody Pieza pieza) {

		Pieza pieza_seleccionado = new Pieza();
		Pieza pieza_actualizado = new Pieza();

		pieza_seleccionado = piezaServiceImpl.leerPiezaById(id);

		pieza_seleccionado.setNombre(pieza.getNombre());

		pieza_actualizado = piezaServiceImpl.actualizarPieza(pieza_seleccionado);

		System.out.println("El pieza actualizado es: " + pieza_actualizado);

		return pieza_actualizado;
	}

	@DeleteMapping("/pieza/{id}")
	public void borrarPieza(@PathVariable(name = "id") int id) {
		piezaServiceImpl.borrarPiezaById(id);
	}

}