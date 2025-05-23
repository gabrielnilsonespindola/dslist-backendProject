package com.gabrielespindola.dslist_backendProject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gabrielespindola.dslist_backendProject.entities.Game;



public interface GameRepository extends JpaRepository<Game, Long> {

}