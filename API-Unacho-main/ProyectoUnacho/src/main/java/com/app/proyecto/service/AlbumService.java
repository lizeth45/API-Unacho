package com.app.proyecto.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.app.proyecto.entity.Album;
import com.app.proyecto.jpa.IAlbumjpa;

@Service
public class AlbumService implements IAlbumService {

	@Autowired
	private IAlbumjpa repoAlbum;

	// SELECCIONAR TODOS LOS ALBUMNES
	@Override
	public List<Album> consultaAlbum() {
		// TODO Auto-generated method stub
		return repoAlbum.findAll();
	}

	// INSERTA UN NUEVO ALBUM
	@Override
	public ResponseEntity<Map<String, String>> insertarAlbum(Album obj) {
		Map<String, String> okResponse = new HashMap<>();
		okResponse.put("message", "El album se ha registrado correctamente");
		okResponse.put("status", HttpStatus.CREATED.toString());
		repoAlbum.save(obj);
		return new ResponseEntity<>(okResponse, HttpStatus.CREATED);
	}

	// ACTUALIZACION DE UN ALBUM POR ID
	@Override
	public ResponseEntity<Map<String, String>> actualizarAlbum(Album obj, int idAlbum) {
		Map<String, String> okResponse = new HashMap<>();
		okResponse.put("message", "Los datos del album han sido actualizados correctamente");
		okResponse.put("status", HttpStatus.OK.toString());

		Map<String, String> errorResponse = new HashMap<>();
		errorResponse.put("message", "No existe un album con el Id: " + idAlbum);
		errorResponse.put("status", HttpStatus.NOT_FOUND.toString());

		return repoAlbum.findById(idAlbum).map(p -> {
			obj.setIdAlbum(idAlbum);
			repoAlbum.save(obj);
			return new ResponseEntity<>(okResponse, HttpStatus.OK);
		}).orElse(new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND));

	}

	// ELIMINAR UN ALBUM POR SU ID
	@Override
	public ResponseEntity<Map<String, String>> eliminarAlbum(int idAlbum) {

		Map<String, String> errorResponse = new HashMap<>();
		errorResponse.put("message", "El album no fue encontrado");
		errorResponse.put("status", HttpStatus.NOT_FOUND.toString());

		Map<String, String> okResponse = new HashMap<>();
		okResponse.put("message", "El album fue eliminado correctamente");
		okResponse.put("status", HttpStatus.OK.toString());

		return repoAlbum.findById(idAlbum).map(p -> {
			repoAlbum.deleteById(idAlbum);
			return new ResponseEntity<>(okResponse, HttpStatus.OK);
		}).orElse(new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND));

	}
}
