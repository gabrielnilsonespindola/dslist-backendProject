package com.gabrielespindola.dslist_backendProject.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gabrielespindola.dslist_backendProject.dto.GameListDTO;
import com.gabrielespindola.dslist_backendProject.entities.GameList;
import com.gabrielespindola.dslist_backendProject.repositories.GameListRepository;


@Service
public class GameListService {

	@Autowired
	private GameListRepository gameListRepository;
	
	@Transactional(readOnly = true)
	public List<GameListDTO> findAll() {
		List<GameList> result = gameListRepository.findAll();
		return result.stream().map(GameListDTO::new).toList();
	}
}
