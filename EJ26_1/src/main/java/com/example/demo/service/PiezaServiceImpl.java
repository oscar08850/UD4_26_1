package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IPiezaDAO;
import com.example.demo.dto.Pieza;

@Service
public class PiezaServiceImpl implements IPiezaService{
	
	@Autowired
	IPiezaDAO iPiezaDAO;

	@Override
	public List<Pieza> listarPieza() {
		return iPiezaDAO.findAll();
	}

	@Override
	public Pieza crearPieza(Pieza pieza) {
		return iPiezaDAO.save(pieza);
	}

	@Override
	public Pieza leerPiezaById(int id) {
		return iPiezaDAO.findById(id).get();
	}

	@Override
	public Pieza actualizarPieza(Pieza pieza) {
		return iPiezaDAO.save(pieza);
	}

	@Override
	public void borrarPiezaById(int id) {
		iPiezaDAO.deleteById(id);
	}

}