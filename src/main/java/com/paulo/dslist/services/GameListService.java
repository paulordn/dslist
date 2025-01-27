package com.paulo.dslist.services;


import com.paulo.dslist.dto.GameListDTO;
import com.paulo.dslist.entities.GameList;
import com.paulo.dslist.projection.GameMinProjection;
import com.paulo.dslist.repositories.GameListRepository;
import com.paulo.dslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameListService {

    @Autowired
    private GameListRepository gameListRepository;

    @Autowired
    private GameRepository gameRepository;

    @Transactional(readOnly = true)
    public List<GameListDTO> findAll(){
        List<GameList> result = gameListRepository.findAll();
        List<GameListDTO> dto = result.stream().map(x -> new GameListDTO(x)).toList();
        return dto;
    }

    public void move(Long listId, int sourceIndex, int destinationIndex){
        List<GameMinProjection> result = gameRepository.searchByList(listId);
        GameMinProjection obj = result.remove(sourceIndex);

        int min = sourceIndex < destinationIndex ? sourceIndex : destinationIndex;
        int max = sourceIndex < destinationIndex ? destinationIndex : sourceIndex;

        for (int i = min; i <= max; i++){
            gameListRepository.updateBelongingPosition(listId, result.get(i).getId(), i);
        }

    }
}
