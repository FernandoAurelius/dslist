package br.com.floresdev.dslist.controllers;

import br.com.floresdev.dslist.entities.GameList;
import br.com.floresdev.dslist.entities.dto.GameListDTO;
import br.com.floresdev.dslist.services.GameListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/lists")
@RestController
public class GameListController {

    @Autowired
    GameListService service;

    @GetMapping
    public List<GameListDTO> findAll() {
        return service.findAll();
    }

}
