package br.com.floresdev.dslist.entities;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

/** Entidade que efetiva o relacionamento entre Game e GameList, utilizando a técnica de obter as duas chaves
 * estrageiras necessárias através da classe auxiliar BelongingPK */
@Entity
@Table(name = "tb_belonging")
public class Belonging {

    @EmbeddedId
    private BelongingPK id = new BelongingPK();

    private Integer position;

    public Belonging(Game game, GameList list, Integer position) {
        this.id.setGame(game);
        this.id.setList(list);
        this.position = position;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public BelongingPK getId() {
        return id;
    }

    public void setId(BelongingPK id) {
        this.id = id;
    }
}
