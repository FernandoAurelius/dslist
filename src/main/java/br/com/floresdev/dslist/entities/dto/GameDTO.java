package br.com.floresdev.dslist.entities.dto;

import br.com.floresdev.dslist.entities.Game;
import org.springframework.beans.BeanUtils;

/** DTO completo da entidade Game
 * */
public class GameDTO {
    
    private Long id;
    
    private Double score;
    
    private String title;
    
    private Integer year;
    
    private String genre;
    
    private String platforms;
    
    private String imgUrl;
    
    private String shortDescription;
    
    private String longDescription;

    public GameDTO() {
    }

    public GameDTO(Game game) {

        // Classe utilitária que copia propriedades de entidades e DTOs
        BeanUtils.copyProperties(game, this);
    }

    public Long getId() {
        return id;
    }

    public Double getScore() {
        return score;
    }

    public String getTitle() {
        return title;
    }

    public Integer getYear() {
        return year;
    }

    public String getGenre() {
        return genre;
    }

    public String getPlatforms() {
        return platforms;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public String getLongDescription() {
        return longDescription;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setPlatforms(String platforms) {
        this.platforms = platforms;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public void setLongDescription(String longDescription) {
        this.longDescription = longDescription;
    }
}
