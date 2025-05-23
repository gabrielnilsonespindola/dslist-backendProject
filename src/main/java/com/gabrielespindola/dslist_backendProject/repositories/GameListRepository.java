package com.gabrielespindola.dslist_backendProject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gabrielespindola.dslist_backendProject.entities.GameList;

public interface GameListRepository extends JpaRepository<GameList, Long> {

}