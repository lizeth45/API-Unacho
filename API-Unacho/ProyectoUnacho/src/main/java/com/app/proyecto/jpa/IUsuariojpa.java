package com.app.proyecto.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.proyecto.entity.Usuario;

public interface IUsuariojpa extends JpaRepository<Usuario, Integer>{

}