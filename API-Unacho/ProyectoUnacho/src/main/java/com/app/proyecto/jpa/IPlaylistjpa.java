package com.app.proyecto.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.proyecto.entity.Playlist;

public interface IPlaylistjpa extends JpaRepository<Playlist, Integer>{

}
