package br.com.floresdev.dslist.controllers;

import br.com.floresdev.dslist.entities.dto.GameDTO;
import br.com.floresdev.dslist.entities.dto.GameMinDTO;
import br.com.floresdev.dslist.projections.GameMinProjection;
import br.com.floresdev.dslist.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Classe controladora da entidade Game, faz parte da camada de controle da aplicação
 * A anotação @RequestMapping define o endpoint específico do controlador, que vai expor as informações através da API
 * A anotação @RestController define que a classe é uma controladora de uma API Rest e configura a classe para retornar
 * dados diretamente ao cliente no formato JSON ou XML, sem redirecionamento para nenhuma view */
@RequestMapping("/games")
@RestController
public class GameController {

    /**
     * Injeção de dependências
     * */
    @Autowired
    GameService service;

    /**
     * A anotação @GetMapping define que esse método será chamado quando o verbo HTTP da requisição web for GET */
    @GetMapping
    public List<GameMinDTO> findAll() {
        // O controlador faz o intermédio entre o Front-end e as outras camadas do Back-end
        return service.findAll();
    }

    /** O parâmetro value na anotação @GetMapping indica que a requisição GET será seguida de um parâmetro de busca (id)
     * A sintaxe adequada está explicitada abaixo, utilizando '/{nome_da_variavel_aqui}'
     * Também é importante anotar o parâmetro do método com @PathVariable, para indicar que é uma variável de caminho
     *  */
    @GetMapping(value = "/{id}")
    public GameDTO findById(@PathVariable Long id) {
        return service.findById(id);
    }

}
