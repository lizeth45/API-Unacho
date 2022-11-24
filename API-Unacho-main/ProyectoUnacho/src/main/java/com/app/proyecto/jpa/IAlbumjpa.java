package com.app.proyecto.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.proyecto.entity.Album;

public interface IAlbumjpa extends JpaRepository<Album,Integer>{

}
