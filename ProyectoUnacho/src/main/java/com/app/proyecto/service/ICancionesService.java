package com.app.proyecto.service;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;

import com.app.proyecto.entity.Canciones;

public interface ICancionesService{

	List<Canciones> consultaCanciones();
	ResponseEntity<Map<String, String>> insertarCancion(Canciones obj);

}
