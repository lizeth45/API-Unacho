package com.app.proyecto.service;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;

import com.app.proyecto.entity.Artista;

public interface IArtistaService {
	List<Artista> consultaArtista();
	ResponseEntity<Map<String, String>> insertarArtista(Artista obj);
	ResponseEntity<Map<String, String>> actualizarArtista(Artista obj, int idArtista);
	List<Artista> consultarbyInicial(String inicial);
}
