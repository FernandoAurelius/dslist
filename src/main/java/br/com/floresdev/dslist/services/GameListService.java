package br.com.floresdev.dslist.services;

import br.com.floresdev.dslist.entities.GameList;
import br.com.floresdev.dslist.entities.dto.GameListDTO;
import br.com.floresdev.dslist.repository.GameListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameListService {

    @Autowired
    GameListRepository repository;

    @Transactional(readOnly = true)
    public List<GameListDTO> findAll() {
        return repository.findAll().stream().map(GameListDTO::new).toList();
    }

}
