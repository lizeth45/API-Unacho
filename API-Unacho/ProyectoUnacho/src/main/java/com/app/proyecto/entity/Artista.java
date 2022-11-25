package com.app.proyecto.entity;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "tb_artista")
public class Artista{
	@Id	
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id_Artista")
	private int idArtista;
	
	@Column(name = "nombre_artista")
	private String nombreArtista;
	
	@Column(name = "edad")
	private int edadArtista;
	
	@Column(name = "genero_musical")
	private String generoMusicalA;
	
	@Column(name = "popularidad")
	private String popularidadA;
	
	@Column(name = "facebook_URL")
	private String facebookURL;
	
	@Column(name = "imagen_URLArtista")
	private String imagenURLArtista;
	
	//Mapeo que usara ALBUM
	@OneToMany(mappedBy = "artista", fetch = FetchType.EAGER)
	private List<Album> album;

	public Artista(String nombreArtista, int edadArtista, String generoMusicalA, String popularidadA,
			String facebookURL, String imagenURLArtista, List<Album> album) {
		super();
		this.nombreArtista = nombreArtista;
		this.edadArtista = edadArtista;
		this.generoMusicalA = generoMusicalA;
		this.popularidadA = popularidadA;
		this.facebookURL = facebookURL;
		this.imagenURLArtista = imagenURLArtista;
		this.album = album;
	}



	public Artista() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public int getIdArtista() {
		return idArtista;
	}

	public void setIdArtista(int idArtista) {
		this.idArtista = idArtista;
	}

	public String getNombreArtista() {
		return nombreArtista;
	}

	public void setNombreArtista(String nombreArtista) {
		this.nombreArtista = nombreArtista;
	}

	public int getEdadArtista() {
		return edadArtista;
	}

	public void setEdadArtista(int edadArtista) {
		this.edadArtista = edadArtista;
	}

	public String getGeneroMusicalA() {
		return generoMusicalA;
	}

	public void setGeneroMusicalA(String generoMusicalA) {
		this.generoMusicalA = generoMusicalA;
	}

	public String getPopularidadA() {
		return popularidadA;
	}

	public void setPopularidadA(String popularidadA) {
		this.popularidadA = popularidadA;
	}

	public String getFacebookURL() {
		return facebookURL;
	}

	public void setFacebookURL(String facebookURL) {
		this.facebookURL = facebookURL;
	}

	public String getImagenURLArtista() {
		return imagenURLArtista;
	}

	public void setImagenURLArtista(String imagenURLArtista) {
		this.imagenURLArtista = imagenURLArtista;
	}

	public List<Album> getAlbum() {
		return album;
	}

	public void setAlbum(List<Album> album) {
		this.album = album;
	}
}