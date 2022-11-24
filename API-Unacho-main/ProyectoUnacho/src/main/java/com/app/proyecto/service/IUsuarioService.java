package com.app.proyecto.service;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;

import com.app.proyecto.entity.Usuario;


public interface IUsuarioService {

	List<Usuario> consultaUsuario();
	ResponseEntity<Map<String, String>> insertarUsuario(Usuario obj);
	ResponseEntity<Map<String, String>> actualizarUsuario(Usuario obj, int idUsuario);
	ResponseEntity<Map<String, String>> eliminarUsuario(int idUsuario);


}
