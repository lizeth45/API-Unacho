package com.app.proyecto.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.app.proyecto.entity.Canciones;
import com.app.proyecto.service.ICancionesService;

@RestController
@CrossOrigin(origins = "*", methods = { RequestMethod.GET })
@RequestMapping("/api")
public class CancionesController {

	@Autowired
	private ICancionesService lognegocioCanciones;

	// Muestra TODOS las canciones
	@GetMapping("/cancion")
	public List<Canciones> showAllCanciones() {
		return lognegocioCanciones.consultaCanciones();
	}

	// AGREGAR una cancion
	@PostMapping("/cancion")
	public String insertarCancion(@RequestBody Canciones objCanciones) {
		lognegocioCanciones.insertarCancion(objCanciones);
		return "La cancion fue registrada correctamente";
	}

	// ACTUALIZAR una cancion por el id
	@PutMapping("/cancion/{id}")
	public ResponseEntity<Map<String, String>> actualizarCancion(@RequestBody Canciones obj,
			@PathVariable("id") int idCancion) {
		return lognegocioCanciones.actualizarCancion(obj, idCancion);
	}

	// Elimina una cancion con el id indicado
	@DeleteMapping("/cancion/{id}")
	public ResponseEntity<?> eliminarCancion(@PathVariable("id") int idCancion) {
		return lognegocioCanciones.eliminarCancion(idCancion);
	}
}
