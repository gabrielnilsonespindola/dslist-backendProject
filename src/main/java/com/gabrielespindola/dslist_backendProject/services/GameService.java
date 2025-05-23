package com.gabrielespindola.dslist_backendProject.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import com.gabrielespindola.dslist_backendProject.dto.GameDTO;
import com.gabrielespindola.dslist_backendProject.dto.GameMinDTO;
import com.gabrielespindola.dslist_backendProject.entities.Game;
import com.gabrielespindola.dslist_backendProject.repositories.GameRepository;


 public class GameService {
	@Autowired
	private GameRepository gameRepository;

	@Transactional(readOnly = true)
	public GameDTO findById(@PathVariable Long listId) {
		Game result = gameRepository.findById(listId).get();
		return new GameDTO(result);
	}
	
	@Transactional(readOnly = true)
	public List<GameMinDTO> findAll() {
		List<Game> result = gameRepository.findAll();
		return result.stream().map(GameMinDTO::new).toList();
		
	}
 }