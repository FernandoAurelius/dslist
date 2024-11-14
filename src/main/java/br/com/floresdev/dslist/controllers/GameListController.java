package br.com.floresdev.dslist.controllers;

import br.com.floresdev.dslist.entities.GameList;
import br.com.floresdev.dslist.entities.dto.GameListDTO;
import br.com.floresdev.dslist.entities.dto.GameMinDTO;
import br.com.floresdev.dslist.entities.dto.ReplacementDTO;
import br.com.floresdev.dslist.services.GameListService;
import br.com.floresdev.dslist.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/lists")
@RestController
public class GameListController {

    @Autowired
    GameListService service;

    @Autowired
    GameService gameService;

    @Autowired
    GameListService gameListService;

    @GetMapping
    public List<GameListDTO> findAll() {
        return service.findAll();
    }

    /**
     * Este endpoint segue um padrão de consulta "relacionada", onde o ID da lista é
     * passado primeiro para restringir a busca, e em seguida, os itens relacionados
     * (neste caso, os jogos) são retornados com base na lista especificada.
     */
    @GetMapping(value = "/{listId}/games")
    public List<GameMinDTO> findByList(@PathVariable Long listId) {
        return gameService.findByList(listId);
    }

    @PostMapping(value = "/{listId}/replacement")
    public void replaceGameByList(@PathVariable Long listId, @RequestBody ReplacementDTO replacement) {
        gameListService.move(listId, replacement.getSourceIndex(), replacement.getDestinationIndex());
    }

}
