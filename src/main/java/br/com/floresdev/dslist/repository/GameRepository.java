package br.com.floresdev.dslist.repository;

import br.com.floresdev.dslist.entities.Game;
import br.com.floresdev.dslist.projections.GameMinProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Classe de acesso a dados que faz parte da camada de acesso a dados da aplicação
 * Extende de JpaRepository, que é uma interface do JPA que facilita operações programáticas com bancos relacionais
 *  */
public interface GameRepository extends JpaRepository<Game, Long> {

	/** Query SQL nativa implementada dentro do nosso repositório numa função personalizada
	 * Em projeções, é comum seguirmos o padrão de nomenclatura NomeDaClasse+Projection, definindo contratos das
	 * consultas que serão realizadas na query
	 *  */
    @Query(nativeQuery = true, value = """
		SELECT tb_game.id, tb_game.title, tb_game.game_year AS `year`, tb_game.img_url AS imgUrl,
		tb_game.short_description AS shortDescription, tb_belonging.position
		FROM tb_game
		INNER JOIN tb_belonging ON tb_game.id = tb_belonging.game_id
		WHERE tb_belonging.list_id = :listId
		ORDER BY tb_belonging.position
		""")
    List<GameMinProjection> searchByList(Long listId);

}
