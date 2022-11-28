package com.app.proyecto.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.app.proyecto.entity.Playlist;
import com.app.proyecto.jpa.IPlaylistjpa;

@Service
public class PlaylistService implements IPlaylistService {

	@Autowired
	private IPlaylistjpa repoPlaylist;
	
	@Override
	public List<Playlist> consultaPlaylist() {
		// TODO Auto-generated method stub
		return repoPlaylist.findAll();
	}

	// INSERTA UNA NUEVA PLAYLIST
	@Override
	public ResponseEntity<Map<String, String>> insertarPlaylist(Playlist obj) {
		Map<String, String> okResponse = new HashMap<>();
		okResponse.put("message", "La playlist se ha registrado correctamente");
		okResponse.put("status", HttpStatus.CREATED.toString());
		repoPlaylist.save(obj);
		return new ResponseEntity<>(okResponse, HttpStatus.CREATED);
	}

	// ACTUALIZACION DE UNA PLAYLIST POR ID
	@Override
	public ResponseEntity<Map<String, String>> actualizarPlaylist(Playlist obj, int idPlaylist) {
		Map<String, String> okResponse = new HashMap<>();
		okResponse.put("message", "Los datos de la playlist han sido actualizados correctamente");
		okResponse.put("status", HttpStatus.OK.toString());

		Map<String, String> errorResponse = new HashMap<>();
		errorResponse.put("message", "No existe una playlist con el Id: " + idPlaylist);
		errorResponse.put("status", HttpStatus.NOT_FOUND.toString());

		return repoPlaylist.findById(idPlaylist).map(p -> {
			obj.setIdPlaylist(idPlaylist);
			repoPlaylist.save(obj);
			return new ResponseEntity<>(okResponse, HttpStatus.OK);
		}).orElse(new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND));

	}

	// ELIMINAR UNA PLAYLIST POR SU ID
	@Override
	public ResponseEntity<Map<String, String>> eliminarPlaylist(int idPlaylist) {

		Map<String, String> errorResponse = new HashMap<>();
		errorResponse.put("message", "La playlist no fue encontrada");
		errorResponse.put("status", HttpStatus.NOT_FOUND.toString());

		Map<String, String> okResponse = new HashMap<>();
		okResponse.put("message", "La playlist fue eliminada correctamente");
		okResponse.put("status", HttpStatus.OK.toString());

		return repoPlaylist.findById(idPlaylist).map(p -> {
			repoPlaylist.deleteById(idPlaylist);
			return new ResponseEntity<>(okResponse, HttpStatus.OK);
		}).orElse(new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND));

	}

}