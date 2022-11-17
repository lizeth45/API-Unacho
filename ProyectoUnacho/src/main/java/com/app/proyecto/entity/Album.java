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
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_album")
public class Album {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_Album")
	private int idAlbum;

	@Column(name = "nombre_album")
	private String nombreAlbum;

	@Column(name = "anio_lanzamiento")
	private int anio_lanzAlbum;

	@Column(name = "productora")
	private String productora;

	@Column(name = "noTracks")
	private int noTracks;

	@Column(name = "imagen_URLAlbum")
	private String imagenURLAlbum;

	// Relacion hacia la tabla de artista, donde el mapeo se hace en artista
	@ManyToOne(cascade = CascadeType.REMOVE)
	@JoinColumn(name = "id_Artista", referencedColumnName = "id_Artista")
	private Artista artista;

	// Aqui se hace el mapeo que se usara en la tabla de Canciones
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "tb_album_cancion", joinColumns = @JoinColumn(name = "id_Album_fk"), inverseJoinColumns = @JoinColumn(name = "id_Cancion_fk"))
	private Set<Canciones> canciones = new HashSet<>();

	public void addCancion(Canciones track){
        if(this.canciones == null){
            this.canciones = new HashSet<>();
        }
        this.canciones.add(track);
    }

	public Album(String nombreAlbum, int anio_lanzAlbum, String productora, int noTracks, String imagenURLAlbum,
			Artista artista, Set<Canciones> canciones) {
		super();
		this.nombreAlbum = nombreAlbum;
		this.anio_lanzAlbum = anio_lanzAlbum;
		this.productora = productora;
		this.noTracks = noTracks;
		this.imagenURLAlbum = imagenURLAlbum;
		this.artista = artista;
		this.canciones = canciones;
	}

	public Album() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getIdAlbum() {
		return idAlbum;
	}

	public void setIdAlbum(int idAlbum) {
		this.idAlbum = idAlbum;
	}

	public String getNombreAlbum() {
		return nombreAlbum;
	}

	public void setNombreAlbum(String nombreAlbum) {
		this.nombreAlbum = nombreAlbum;
	}

	public int getAnio_lanzAlbum() {
		return anio_lanzAlbum;
	}

	public void setAnio_lanzAlbum(int anio_lanzAlbum) {
		this.anio_lanzAlbum = anio_lanzAlbum;
	}

	public String getProductora() {
		return productora;
	}

	public void setProductora(String productora) {
		this.productora = productora;
	}

	public int getNoTracks() {
		return noTracks;
	}

	public void setNoTracks(int noTracks) {
		this.noTracks = noTracks;
	}

	public String getImagenURLAlbum() {
		return imagenURLAlbum;
	}

	public void setImagenURLAlbum(String imagenURLAlbum) {
		this.imagenURLAlbum = imagenURLAlbum;
	}

	public Artista getArtista() {
		return artista;
	}

	public void setArtista(Artista artista) {
		this.artista = artista;
	}

	public Set<Canciones> getCanciones() {
		return canciones;
	}

	public void setCanciones(Set<Canciones> canciones) {
		this.canciones = canciones;
	}
}