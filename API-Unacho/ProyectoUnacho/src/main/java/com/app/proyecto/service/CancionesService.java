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
public class CancionesService implements ICancionesService {

	@Autowired
	private ICancionesjpa repoCanciones;

	// CONSULTA TODAS LAS CANCIONES
	@Override
	public List<Canciones> consultaCanciones() {
		// TODO Auto-generated method stub
		return repoCanciones.findAll();
	}

	// INSERTA UNA NUEVA CANCION
	@Override
	public ResponseEntity<Map<String, String>> insertarCancion(Canciones obj) {
		Map<String, String> okResponse = new HashMap<>();
		okResponse.put("message", "La cancion se ha registrado correctamente");
		okResponse.put("status", HttpStatus.CREATED.toString());
		repoCanciones.save(obj);
		return new ResponseEntity<>(okResponse, HttpStatus.CREATED);
	}

	// ACTUALIZACION DE UNA CANCION POR ID
	@Override
	public ResponseEntity<Map<String, String>> actualizarCancion(Canciones obj, int idCancion) {
		Map<String, String> okResponse = new HashMap<>();
		okResponse.put("message", "Los datos de la cancion han sido actualizados correctamente");
		okResponse.put("status", HttpStatus.OK.toString());

		Map<String, String> errorResponse = new HashMap<>();
		errorResponse.put("message", "No existe una cancion con el Id: " + idCancion);
		errorResponse.put("status", HttpStatus.NOT_FOUND.toString());

		return repoCanciones.findById(idCancion).map(p -> {
			obj.setIdCancion(idCancion);
			repoCanciones.save(obj);
			return new ResponseEntity<>(okResponse, HttpStatus.OK);
		}).orElse(new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND));

	}

	// ELIMINAR UN ARTISTA POR SU ID
	@Override
	public ResponseEntity<Map<String, String>> eliminarCancion(int idCancion) {

		Map<String, String> errorResponse = new HashMap<>();
		errorResponse.put("message", "La cancion no fue encontrada");
		errorResponse.put("status", HttpStatus.NOT_FOUND.toString());

		Map<String, String> okResponse = new HashMap<>();
		okResponse.put("message", "La cancion fue eliminada correctamente");
		okResponse.put("status", HttpStatus.OK.toString());

		return repoCanciones.findById(idCancion).map(p -> {
			repoCanciones.deleteById(idCancion);
			return new ResponseEntity<>(okResponse, HttpStatus.OK);
		}).orElse(new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND));

	}
}
