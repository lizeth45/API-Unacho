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
@Table(name = "tb_playlist")
public class Playlist {
	
	@Id	
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id_playlist")
	private int idPlaylist;
	
	@Column(name = "nombre_playlist")
	private String nombrePlaylist;
	
	@Column(name = "fecha_creacion")
	private String fechaCreacion;

	//Relacion hacia la tabla de USUARIOS, donde el mapeo se hace en usuarios
	@ManyToOne(cascade=CascadeType.REMOVE)
	@JoinColumn(name="id_Usuario",referencedColumnName="id_Usuario")
	private Usuario usuario;
	
	
	//Union de columnas usando el mapeo de CANCIONES
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "tb_cancion_playlist",joinColumns = @JoinColumn(name = "id_Cancion_fk"),inverseJoinColumns = @JoinColumn(name = "id_Playlist_fk"))
	private Set<Canciones> cancionesP;
	
	public void addCancion(Canciones track){
        if(this.cancionesP == null){
            this.cancionesP = new HashSet<>();
        }
        this.cancionesP.add(track);
    }
	
	public Playlist() {
		super();
		// TODO Auto-generated constructor stub
	}	

	public Playlist(String nombrePlaylist, String fechaCreacion, Usuario usuario, Set<Canciones> canciones) {
		super();
		this.nombrePlaylist = nombrePlaylist;
		this.fechaCreacion = fechaCreacion;
		this.usuario = usuario;
		this.cancionesP = canciones;
	}

	public int getIdPlaylist() {
		return idPlaylist;
	}

	public void setIdPlaylist(int idPlaylist) {
		this.idPlaylist = idPlaylist;
	}

	public String getNombrePlaylist() {
		return nombrePlaylist;
	}

	public void setNombrePlaylist(String nombrePlaylist) {
		this.nombrePlaylist = nombrePlaylist;
	}

	public String getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(String fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Set<Canciones> getCanciones() {
		return cancionesP;
	}

	public void setCanciones(Set<Canciones> canciones) {
		this.cancionesP = canciones;
	}
	
	
}