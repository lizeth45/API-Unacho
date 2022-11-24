package com.app.proyecto.service;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;

import com.app.proyecto.entity.Playlist;

public interface IPlaylistService{

	List<Playlist> consultaPlaylist();
	ResponseEntity<Map<String, String>> insertarPlaylist(Playlist obj);
	ResponseEntity<Map<String, String>> actualizarPlaylist(Playlist obj, int idPlaylist);
	ResponseEntity<Map<String, String>> eliminarPlaylist(int idPlaylist);
	
}
