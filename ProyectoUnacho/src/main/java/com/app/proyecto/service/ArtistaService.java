package com.app.proyecto.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.app.proyecto.entity.Artista;
import com.app.proyecto.jpa.IArtistajpa;

@Service
public class ArtistaService implements IArtistaService {
	
	@Autowired
	private IArtistajpa repoArtista;
	
	//CONSULTA TODOS LOS ARTISTAS
	@Override
	public List<Artista> consultaArtista() {
		// TODO Auto-generated method stub
		return repoArtista.findAll();
	}
	
	//INSERCION DE UN NUEVO ARTISTA
	@Override
	public ResponseEntity<Map<String, String>> insertarArtista(Artista obj) {
		Map<String, String> okResponse = new HashMap<>();
		okResponse.put("message", "El artista se ha registrado correctamente");
	    okResponse.put("status", HttpStatus.CREATED.toString());
	    repoArtista.save(obj);
		return new ResponseEntity<>(okResponse,HttpStatus.CREATED);
	}
	
	//ACTUALIZACION DE UN ARTISTA
	@Override
	public ResponseEntity<Map<String, String>> actualizarArtista(Artista obj, int idArtista) {
		Map<String, String> okResponse = new HashMap<>();
			okResponse.put("message", "Los datos del Artista han sido actualizados correctamente");
			okResponse.put("status", HttpStatus.OK.toString());
	    
		Map<String, String> errorResponse = new HashMap<>();
			errorResponse.put("message", "No existe un artista con el Id: " + idArtista);
			errorResponse.put("status", HttpStatus.NOT_FOUND.toString());
		
		return repoArtista.findById(idArtista).map( p -> {				
				obj.setIdArtista(idArtista);	
				repoArtista.save(obj); 
			return new ResponseEntity<>(okResponse, HttpStatus.OK);
		})
		.orElse(new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND));

	}
	
	//CONSULTA DE ARTISTA DADO UNA INCIAL DE SU NOMBRE
	@Override
	public List<Artista> consultarbyInicial(String inicial) {		
		return repoArtista.mostrarxinicialNombre(inicial);
					
	}
	
}
