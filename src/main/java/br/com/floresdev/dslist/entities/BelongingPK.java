package br.com.floresdev.dslist.entities;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.util.Objects;

/** Classe auxiliar que representa a chave primária da entidade Belonging, que é uma tabela de efetivação de relação
 *  -
 *  De maneira programática, não podemos definir um ID como sendo dois objetos diferentes, então utilizamos desse
 *  recurso auxiliar para manter a composição de elementos, a chave estrangeira adequada e respeitando a limitação da
 *  linguagem
 *  -
 *  A anotação Embeddable serve para indicar ao JPA que essa classe auxiliar efetiva uma relação e será referenciada
 *  como chave primária de outra classe, que por sua vez precisa da "mistura" dessas duas outras chaves estrangeiras
 *  */
@Embeddable
public class BelongingPK {

    /** Coluna que mapeia a chave estrangeira da entidade Game
     * */
    @ManyToOne
    @JoinColumn(name = "game_id")
    private Game game;

    /** Coluna que mapeia a chave estrangeira da entidade GameList
     * */
    @ManyToOne
    @JoinColumn(name = "list_id")
    private GameList list;

    public BelongingPK() {
    }

    public BelongingPK(Game game, GameList list) {
        this.game = game;
        this.list = list;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public GameList getList() {
        return list;
    }

    public void setList(GameList list) {
        this.list = list;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BelongingPK that = (BelongingPK) o;
        return Objects.equals(game, that.game) && Objects.equals(list, that.list);
    }

    @Override
    public int hashCode() {
        return Objects.hash(game, list);
    }
}
