package com.app.proyecto.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.proyecto.entity.Canciones;

public interface ICancionesjpa extends JpaRepository<Canciones, Integer>{

}
