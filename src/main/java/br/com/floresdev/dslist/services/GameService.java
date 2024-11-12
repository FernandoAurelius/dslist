package br.com.floresdev.dslist.services;

import br.com.floresdev.dslist.entities.Game;
import br.com.floresdev.dslist.entities.dto.GameDTO;
import br.com.floresdev.dslist.entities.dto.GameMinDTO;
import br.com.floresdev.dslist.repository.GameRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

/**
 * A anotação @Service serve para marcar a classe como um componente do Spring, aplicando IoC e DI */
@Service
public class GameService {

    @Autowired
    GameRepository repository;

    @Transactional(readOnly = true)
    public List<GameMinDTO> findAll() {
        List<Game> result = repository.findAll();
        return result.stream().map(GameMinDTO::new).toList();
    }

    /** A anotação @Transactional enquadra nossa operação de busca dentro do padrão ACID do SQL
     * O tratamento de exceção foi feito de maneira resumida, pois a resolução real é um tanto mais complexa
     *  */
    @Transactional(readOnly = true)
    public GameDTO findById(Long id) {
        return repository.findById(id)
                .map(GameDTO::new)
                .orElseThrow(() -> new NoSuchElementException("Game not found with id: " + id));
    }


}
