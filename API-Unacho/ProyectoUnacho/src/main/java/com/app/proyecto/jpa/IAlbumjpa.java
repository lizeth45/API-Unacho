package com.app.proyecto.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.proyecto.entity.Album;
import com.app.proyecto.entity.Canciones;

public interface IAlbumjpa extends JpaRepository<Album, Integer> {

	// Query que retorna las canciones de un album en especifico
	@Query("select o.canciones from Album o where o.idAlbum=?1")
	List<Canciones> mostrarCancionesAlbum(Integer idAlbum);
}
