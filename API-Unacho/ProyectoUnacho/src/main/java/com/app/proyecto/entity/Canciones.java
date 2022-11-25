package com.app.proyecto.entity;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;



@Entity
@Table(name = "tb_canciones")
public class Canciones{
	@Id	
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id_Cancion")
	private int idCancion;
	
	@Column(name = "nombre_Cancion")
	private String nombreCancion;
	
	@Column(name = "anio_lanzamiento")
	private int anio_lanzCancion;
	
	@Column(name = "duracionMin")
	private int duracion_Cancion;
	
	@Column(name = "genero_Cancion")
	private String generoCancion;
	
	//Union de columnas usando el mapeo de ALBUM
	@ManyToMany(fetch = FetchType.LAZY , cascade =CascadeType.ALL,mappedBy = "canciones")
	private Set<Album> albums;
	
	//Mapeo para que se pueda usar la tabla de CANCIONES en PLAYLIST
	@ManyToMany(fetch = FetchType.LAZY , cascade =CascadeType.ALL)
	@JoinTable(
		name = "tb_cancion_playlist", 
		joinColumns = @JoinColumn(name = "id_Cancion_fk"),
		inverseJoinColumns = @JoinColumn(name = "id_Playlist_fk")
	)
	private Set<Playlist> playlist = new HashSet<>();
	
	
	public Canciones() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public Canciones(String nombreCancion, int anio_lanzCancion, int duracion_Cancion, String generoCancion,
			Set<Album> albums, Set<Playlist> playlist) {
		super();
		this.nombreCancion = nombreCancion;
		this.anio_lanzCancion = anio_lanzCancion;
		this.duracion_Cancion = duracion_Cancion;
		this.generoCancion = generoCancion;
		this.albums = albums;
		this.playlist = playlist;
	}



	public int getIdCancion() {
		return idCancion;
	}

	public void setIdCancion(int idCancion) {
		this.idCancion = idCancion;
	}

	public String getNombreCancion() {
		return nombreCancion;
	}

	public void setNombreCancion(String nombreCancion) {
		this.nombreCancion = nombreCancion;
	}

	public int getAnio_lanzCancion() {
		return anio_lanzCancion;
	}

	public void setAnio_lanzCancion(int anio_lanzCancion) {
		this.anio_lanzCancion = anio_lanzCancion;
	}

	public int getDuracion_Cancion() {
		return duracion_Cancion;
	}

	public void setDuracion_Cancion(int duracion_Cancion) {
		this.duracion_Cancion = duracion_Cancion;
	}

	public String getGeneroCancion() {
		return generoCancion;
	}

	public void setGeneroCancion(String generoCancion) {
		this.generoCancion = generoCancion;
	}	

}