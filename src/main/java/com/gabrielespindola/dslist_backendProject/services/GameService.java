package com.gabrielespindola.dslist_backendProject.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import com.gabrielespindola.dslist_backendProject.dto.GameDTO;
import com.gabrielespindola.dslist_backendProject.dto.GameMinDTO;
import com.gabrielespindola.dslist_backendProject.entities.Game;
import com.gabrielespindola.dslist_backendProject.projections.GameMinProjection;
import com.gabrielespindola.dslist_backendProject.repositories.GameListRepository;
import com.gabrielespindola.dslist_backendProject.repositories.GameRepository;


@Service
public class GameService {

	@Autowired
	private GameRepository gameRepository;
	
	@Autowired
	private GameListRepository gameListRepository;

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
	
	@Transactional(readOnly = true)
	public List<GameMinDTO> findByGameList(Long listId) {
		List<GameMinProjection> games = gameRepository.searchByList(listId);
		return games.stream().map(GameMinDTO::new).toList();
	}
	
	@Transactional
	public void move(Long listId, int sourceIndex, int destinationIndex) {

		List<GameMinProjection> list = gameRepository.searchByList(listId);

		GameMinProjection obj = list.remove(sourceIndex);
		list.add(destinationIndex, obj);

		int min = sourceIndex < destinationIndex ? sourceIndex : destinationIndex;
		int max = sourceIndex < destinationIndex ? destinationIndex : sourceIndex;

		for (int i = min; i <= max; i++) {
			gameListRepository.updateBelongingPosition(listId, list.get(i).getId(), i);
		}
	}
}