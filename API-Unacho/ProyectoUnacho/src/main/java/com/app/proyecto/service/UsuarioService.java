package com.app.proyecto.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.app.proyecto.entity.Usuario;
import com.app.proyecto.jpa.IUsuariojpa;

@Service
public class UsuarioService implements IUsuarioService {

	@Autowired
	private IUsuariojpa repoUsuario;

	// CONSULTA DE LOS USUARIOS
	@Override
	public List<Usuario> consultaUsuario() {
		// TODO Auto-generated method stub
		return repoUsuario.findAll();
	}

	// INSERTA UN NUEVO USUARIO
	@Override
	public ResponseEntity<Map<String, String>> insertarUsuario(Usuario obj) {
		Map<String, String> okResponse = new HashMap<>();
		okResponse.put("message", "El usuario se ha registrado correctamente");
		okResponse.put("status", HttpStatus.CREATED.toString());
		repoUsuario.save(obj);
		return new ResponseEntity<>(okResponse, HttpStatus.CREATED);
	}

	// ACTUALIZACION DE UN USUARIO POR ID
	@Override
	public ResponseEntity<Map<String, String>> actualizarUsuario(Usuario obj, int idUsuario) {
		Map<String, String> okResponse = new HashMap<>();
		okResponse.put("message", "Los datos del usuario han sido actualizados correctamente");
		okResponse.put("status", HttpStatus.OK.toString());

		Map<String, String> errorResponse = new HashMap<>();
		errorResponse.put("message", "No existe un usuario con el Id: " + idUsuario);
		errorResponse.put("status", HttpStatus.NOT_FOUND.toString());

		return repoUsuario.findById(idUsuario).map(p -> {
			obj.setIdUsuario(idUsuario);
			repoUsuario.save(obj);
			return new ResponseEntity<>(okResponse, HttpStatus.OK);
		}).orElse(new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND));

	}

	// ELIMINAR UN USUARIO POR SU ID
	@Override
	public ResponseEntity<Map<String, String>> eliminarUsuario(int idUsuario) {

		Map<String, String> errorResponse = new HashMap<>();
		errorResponse.put("message", "El usuario no fue encontrado");
		errorResponse.put("status", HttpStatus.NOT_FOUND.toString());

		Map<String, String> okResponse = new HashMap<>();
		okResponse.put("message", "El usuario fue eliminado correctamente");
		okResponse.put("status", HttpStatus.OK.toString());

		return repoUsuario.findById(idUsuario).map(p -> {
			repoUsuario.deleteById(idUsuario);
			return new ResponseEntity<>(okResponse, HttpStatus.OK);
		}).orElse(new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND));

	}

}