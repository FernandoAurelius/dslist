package br.com.floresdev.dslist.services;

import br.com.floresdev.dslist.entities.Game;
import br.com.floresdev.dslist.entities.dto.GameMinDTO;
import br.com.floresdev.dslist.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * A anotação @Service serve para marcar a classe como um componente do Spring, aplicando IoC e DI */
@Service
public class GameService {

    @Autowired
    GameRepository repository;

    public List<GameMinDTO> findAll() {
        List<Game> result = repository.findAll();
        return result.stream().map(GameMinDTO::new).toList();
    }

}
