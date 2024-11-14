package br.com.floresdev.dslist.services;

import br.com.floresdev.dslist.entities.dto.GameListDTO;
import br.com.floresdev.dslist.entities.dto.GameMinDTO;
import br.com.floresdev.dslist.projections.GameMinProjection;
import br.com.floresdev.dslist.repository.GameListRepository;
import br.com.floresdev.dslist.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GameListService {

    @Autowired
    GameListRepository repository;

    @Autowired
    GameRepository gameRepository;

    @Transactional(readOnly = true)
    public List<GameListDTO> findAll() {
        return repository.findAll().stream().map(GameListDTO::new).toList();
    }

    @Transactional(readOnly = true)
    public void move(Long listId, int sourceIndex, int destinationIndex) {
        List<GameMinProjection> list = gameRepository.searchByList(listId);

        GameMinProjection gameToBeMoved = list.remove(sourceIndex);
        list.add(destinationIndex, gameToBeMoved);

        int min = Math.min(sourceIndex, destinationIndex);
        int max = Math.max(sourceIndex, destinationIndex);

        for (int i = min; i <= max; i++) {
            repository.updateBelongingPosition(listId, list.get(i).getId(), i);
        }

    }

}
