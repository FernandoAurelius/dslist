package br.com.floresdev.dslist.entities.dto;

import br.com.floresdev.dslist.entities.Game;
import br.com.floresdev.dslist.projections.GameMinProjection;

/**
 * Um DTO (Data Transfer Object) é um objeto utilizado para manipular os dados do banco e servi-los de maneira
 * personalizada para o Front-end no formato JSON.
 * - é instanciado a partir das informações resgatadas no banco por um repositório
 * - (que por sua vez é um objeto de acesso a dados)
* */
public class GameMinDTO {

    private Long id;

    private String title;

    private Integer year;

    private String imgUrl;

    private String shortDescription;

    public GameMinDTO() {
    }

    public GameMinDTO(Game game) {
        id = game.getId();
        title = game.getTitle();
        year = game.getYear();
        imgUrl = game.getImgUrl();
        shortDescription = game.getShortDescription();
    }

    /** Construtor que recebe uma projeção derivada de uma query SQL nativa, implementada no repositório
     * */
    public GameMinDTO(GameMinProjection projection) {
        id = projection.getId();
        title = projection.getTitle();
        year = projection.getYear();
        imgUrl = projection.getImgUrl();
        shortDescription = projection.getShortDescription();
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Integer getYear() {
        return year;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public String getShortDescription() {
        return shortDescription;
    }
}
