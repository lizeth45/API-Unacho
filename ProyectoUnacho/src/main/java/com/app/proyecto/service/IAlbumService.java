package com.app.proyecto.service;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;

import com.app.proyecto.entity.Album;

public interface IAlbumService {

	List<Album> consultaAlbum();

	ResponseEntity<Map<String, String>> insertarAlbum(Album obj);

	ResponseEntity<Map<String, String>> actualizarAlbum(Album obj, int idAlbum);

	ResponseEntity<Map<String, String>> eliminarAlbum(int idAlbum);
}
