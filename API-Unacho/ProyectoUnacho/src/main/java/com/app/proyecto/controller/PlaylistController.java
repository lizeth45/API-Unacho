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

import com.app.proyecto.entity.Playlist;
import com.app.proyecto.service.IPlaylistService;

@RestController
@CrossOrigin(origins = "*", methods = { RequestMethod.GET })
@RequestMapping("/api")
public class PlaylistController {

	@Autowired
	private IPlaylistService lognegocioPlaylist;

	// Muestra TODOS las playlist
	@GetMapping("/playlist")
	public List<Playlist> showAllCanciones() {
		return lognegocioPlaylist.consultaPlaylist();
	}

	// AGREGAR una playlist
	@PostMapping("/playlist")
	public String insertarPlaylist(@RequestBody Playlist objPlaylist) {
		lognegocioPlaylist.insertarPlaylist(objPlaylist);
		return "La playlist fue registrada correctamente";
	}

	// ACTUALIZAR una playlist por el id
	@PutMapping("/playlist/{id}")
	public ResponseEntity<Map<String, String>> actualizarPlaylist(@RequestBody Playlist obj,
			@PathVariable("id") int idPlaylist) {
		return lognegocioPlaylist.actualizarPlaylist(obj, idPlaylist);
	}

	// Elimina una playlist con el id indicado
	@DeleteMapping("/playlist/{id}")
	public ResponseEntity<?> eliminarPlaylist(@PathVariable("id") int idPlaylist) {
		return lognegocioPlaylist.eliminarPlaylist(idPlaylist);
	}

}