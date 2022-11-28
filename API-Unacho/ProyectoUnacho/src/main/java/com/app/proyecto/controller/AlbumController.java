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

import com.app.proyecto.entity.Album;
import com.app.proyecto.entity.Canciones;
import com.app.proyecto.service.IAlbumService;

@RestController
@CrossOrigin(origins = "*", methods = { RequestMethod.GET })
@RequestMapping("/api")
public class AlbumController {

	@Autowired
	private IAlbumService lognegocioAlbum;

	// Muestra TODOS los albums
	@GetMapping("/album")
	public List<Album> showAllAlbums() {
		return lognegocioAlbum.consultaAlbum();
	}

	// Muestra TODAS las canciones de un album
	@GetMapping("/album/{id}/cancion")
	public List<Canciones> mostrarCancionesAlbum(@PathVariable("id") int idAlbum) {
		return lognegocioAlbum.consultaCancionesAlbum(idAlbum);
	}

	// AGREGAR un album
	@PostMapping("/album")
	public String insertarAlbum(@RequestBody Album objAlbum) {
		lognegocioAlbum.insertarAlbum(objAlbum);
		return "El album fue registrado correctamente";
	}

	// ACTUALIZAR un album por el id
	@PutMapping("/album/{id}")
	public ResponseEntity<Map<String, String>> actualizarAlbum(@RequestBody Album obj,
			@PathVariable("id") int idAlbum) {
		return lognegocioAlbum.actualizarAlbum(obj, idAlbum);
	}

	// Elimina un album con el id indicado
	@DeleteMapping("/album/{id}")
	public ResponseEntity<?> eliminarAlbum(@PathVariable("id") int idAlbum) {
		return lognegocioAlbum.eliminarAlbum(idAlbum);
	}
}
