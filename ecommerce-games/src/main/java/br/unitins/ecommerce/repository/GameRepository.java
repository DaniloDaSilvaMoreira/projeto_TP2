package br.unitins.ecommerce.repository;

import br.unitins.ecommerce.model.produto.Game;
import io.quarkus.hibernate.orm.panache.PanacheQuery;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.panache.common.Sort;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class GameRepository implements PanacheRepository<Game> {
    
    public PanacheQuery<Game> findByNome(String nome, Sort sort){

        if (nome == null)
            return null;

        return find("UPPER(nome) LIKE ?1 ", sort, "%"+nome.toUpperCase()+"%");
    }
}
