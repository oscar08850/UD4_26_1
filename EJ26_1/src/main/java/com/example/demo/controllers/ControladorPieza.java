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
	PiezaServiceImpl departamentoServiceImpl;

	@GetMapping("/pieza")
	public List<Pieza> listarpieza() {
		return departamentoServiceImpl.listarPieza();
	}

	@PostMapping("/pieza")
	public Pieza crearPieza(@RequestBody Pieza departamento) {

		return departamentoServiceImpl.crearPieza(departamento);

	}

	@GetMapping("/pieza/{id}")
	public Pieza leerPieza(@PathVariable(name = "id") int id) {

		Pieza departamento = new Pieza();

		departamento = departamentoServiceImpl.leerPiezaById(id);

		System.out.println("Pieza segun ID: " + departamento);

		return departamento;
	}

	@PutMapping("/pieza/{id}")
	public Pieza actualizarPieza(@PathVariable(name = "id") int id,
			@RequestBody Pieza departamento) {

		Pieza departamento_seleccionado = new Pieza();
		Pieza departamento_actualizado = new Pieza();

		departamento_seleccionado = departamentoServiceImpl.leerPiezaById(id);

		departamento_seleccionado.setNombre(departamento.getNombre());
		//departamento_seleccionado.setPresupuesto(departamento.getPresupuesto());

		departamento_actualizado = departamentoServiceImpl.actualizarPieza(departamento_seleccionado);

		System.out.println("El departamento actualizado es: " + departamento_actualizado);

		return departamento_actualizado;
	}

	@DeleteMapping("/pieza/{id}")
	public void borrarPieza(@PathVariable(name = "id") int id) {
		departamentoServiceImpl.borrarPiezaById(id);
	}

}