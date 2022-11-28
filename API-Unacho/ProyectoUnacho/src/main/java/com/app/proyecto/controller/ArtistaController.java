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

import com.app.proyecto.entity.Artista;
import com.app.proyecto.service.IArtistaService;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET})
@RequestMapping("/api")
public class ArtistaController {
	
	@Autowired
	private IArtistaService lognegocioArtista;
	
	
	//Muestra TODOS los artistas
	@GetMapping("/artistas")
	public List<Artista> showAllArtistas(){  
		return lognegocioArtista.consultaArtista();
	}
	
	//AGREGAR un artista
	@PostMapping("/artistas")
	public String insertarArtista(@RequestBody Artista objArtista){
		lognegocioArtista.insertarArtista(objArtista);
		return "El artista fue registrado correctamente";
	}
	
	//ACTUALIZAR un artista por el id
	@PutMapping("/artistas/{id}")
	public ResponseEntity<Map<String, String>> actualizarArtista(@RequestBody Artista obj, @PathVariable("id") int idArtista){
		return lognegocioArtista.actualizarArtista(obj, idArtista);
	}
	
	//Muestra a los artistas segun LA INICIAL DE SU NOMBRE
	@GetMapping("/artistas/{letra}")
	public List<Artista> showArtistasxInicial(@PathVariable("letra") String inicial){  
		return lognegocioArtista.consultarbyInicial(inicial);
	}
	
	//Elimina un artista con el id indicado
	@DeleteMapping("/artistas/{id}")
	public ResponseEntity<?> eliminarArtista(@PathVariable("id") int idArtista){
		return lognegocioArtista.eliminarArtista(idArtista);      
	}
	
}
