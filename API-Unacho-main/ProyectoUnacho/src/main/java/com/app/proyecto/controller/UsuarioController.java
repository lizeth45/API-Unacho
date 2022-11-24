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

import com.app.proyecto.entity.Usuario;
import com.app.proyecto.service.IUsuarioService;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET})
@RequestMapping("/api")
public class UsuarioController {
	
	@Autowired
	private IUsuarioService lognegocioUsuario;
	
	// Muestra TODOS los usuarios
		@GetMapping("/usuario")
		public List<Usuario> showAllUsuarios() {
			return lognegocioUsuario.consultaUsuario();
		}

		// AGREGAR un usuario
		@PostMapping("/usuario")
		public String insertarUsuario(@RequestBody Usuario objUsuario) {
			lognegocioUsuario.insertarUsuario(objUsuario);
			return "La cancion fue registrada correctamente";
		}

		// ACTUALIZAR un usuario pot el id
		@PutMapping("/usuario/{id}")
		public ResponseEntity<Map<String, String>> actualizarUsuario(@RequestBody Usuario obj,
				@PathVariable("id") int idUsuario) {
			return lognegocioUsuario.actualizarUsuario(obj, idUsuario);
		}

		// Elimina un usuario con el id indicado
		@DeleteMapping("/usuario/{id}")
		public ResponseEntity<?> eliminarCancion(@PathVariable("id") int idUsuario) {
			return lognegocioUsuario.eliminarUsuario(idUsuario);
		}


}
