package br.com.floresdev.dslist.projections;

/** O padrão de uma projeção é de definir contratos respectivos a cada consulta feita no corpo da query, mas de maneira
 * programática e seguindo os padrões de nomenclatura do Java
 * */
public interface GameMinProjection {

    Long getId();

    String getTitle();

    // Adaptado para o POSTGRES (não aceita ``)
    Integer getGameYear();

    String getImgUrl();

    String getShortDescription();

    Integer getPosition();

}
