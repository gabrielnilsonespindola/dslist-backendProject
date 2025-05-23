package com.gabrielespindola.dslist_backendProject.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gabrielespindola.dslist_backendProject.dto.GameMinDTO;
import com.gabrielespindola.dslist_backendProject.entities.Game;
import com.gabrielespindola.dslist_backendProject.repositories.GameRepository;

@Service
public class GameService {

	@Autowired
	private GameRepository gameRepository;

	public List<GameMinDTO> findAll() {
		List<Game> result = gameRepository.findAll();
		return result.stream().map(GameMinDTO::new).toList();
	}
}