package br.com.floresdev.dslist.repository;

import br.com.floresdev.dslist.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Classe de acesso a dados que faz parte da camada de acesso a dados da aplicação
 * Extende de JpaRepository, que é uma interface do JPA que facilita operações programáticas com bancos relacionais
 *  */
public interface GameRepository extends JpaRepository<Game, Long> {
}
