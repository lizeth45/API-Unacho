package com.app.proyecto.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.app.proyecto.entity.Canciones;
import com.app.proyecto.jpa.ICancionesjpa;


@Service
public class CancionesService implements ICancionesService{
	
	@Autowired
	private ICancionesjpa repoCanciones;
	
	//CONSULTA TODAS LAS CANCIONES
	//@Override
	public List<Canciones> consultaCanciones() {
		// TODO Auto-generated method stub
		return repoCanciones.findAll();
	}
	
	//INSERTA UNA NUEVA CANCION
	@Override
	public ResponseEntity<Map<String, String>> insertarCancion(Canciones obj) {
		Map<String, String> okResponse = new HashMap<>();
		okResponse.put("message", "La cancion se ha registrado correctamente");
	    okResponse.put("status", HttpStatus.CREATED.toString());
	    repoCanciones.save(obj);
		return new ResponseEntity<>(okResponse,HttpStatus.CREATED);
	}
}
