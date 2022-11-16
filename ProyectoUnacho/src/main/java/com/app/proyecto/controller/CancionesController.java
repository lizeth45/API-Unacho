package com.app.proyecto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.app.proyecto.entity.Canciones;
import com.app.proyecto.service.ICancionesService;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET})
@RequestMapping("/api")
public class CancionesController {

	@Autowired
	private ICancionesService lognegocioCanciones;
	
	//Muestra TODOS las canciones
	@GetMapping("/cancion")
	public List<Canciones> showAllCanciones(){  
		return lognegocioCanciones.consultaCanciones();
	}
	
	//AGREGAR un artista
	@PostMapping("/cancion")
	public String insertarCancion(@RequestBody Canciones objCanciones){
		lognegocioCanciones.insertarCancion(objCanciones);
		return "La cancion fue registrada correctamente";
	}
	
	//FALTA ACTUALIZAR 
}
