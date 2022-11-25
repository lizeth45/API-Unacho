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
@Table(name = "tb_usuario")
public class Usuario {
	
	@Id	
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id_Usuario")
	private int idUsuario;
	
	@Column(name = "nombre_Usuario")
	private String nombreUsuario;
	
	@Column(name = "ap_Pat")
	private String apPaterno;
	
	@Column(name = "ap_mat")
	private String apMaterno;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "fecha_nacimiento")
	private String fechaNacimiento;
	
	@Column(name = "pais")
	private String pais;
	
	
	//Mapeo que usara PLAYLIST
	@OneToMany(mappedBy = "usuario", fetch = FetchType.EAGER)
	private List<Playlist> playlist;
	
	public Usuario() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Usuario(String nombreUsuario, String apPaterno, String apMaterno, String email, String password,
			String fechaNacimiento, String pais, List<Playlist> playlist) {
		super();
		this.nombreUsuario = nombreUsuario;
		this.apPaterno = apPaterno;
		this.apMaterno = apMaterno;
		this.email = email;
		this.password = password;
		this.fechaNacimiento = fechaNacimiento;
		this.pais = pais;
		this.playlist = playlist;
	}


	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	

	public String getNombreUsuario() {
		return nombreUsuario;
	}


	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}


	public String getApPaterno() {
		return apPaterno;
	}

	public void setApPaterno(String apPaterno) {
		this.apPaterno = apPaterno;
	}

	public String getApMaterno() {
		return apMaterno;
	}

	public void setApMaterno(String apMaterno) {
		this.apMaterno = apMaterno;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	public String getPais() {
		return pais;
	}


	public void setPais(String pais) {
		this.pais = pais;
	}
	
}