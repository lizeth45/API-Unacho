package com.app.proyecto.jpa;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.app.proyecto.entity.*;

public interface IArtistajpa extends JpaRepository<Artista, Integer>{
	
	//Query que retorna los artistas que su nombre inicie con Letra``
	@Query ("select o from Artista o where o.nombreArtista like :letra%") 
	List<Artista> mostrarxinicialNombre(@Param("letra") String letra);
	
}
