package it.projecteat.finalproject.Repositories;

import it.projecteat.finalproject.Entity.Cusine;
import it.projecteat.finalproject.Entity.Ingredients;
import it.projecteat.finalproject.Entity.Recipes;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

public interface RecipeRepo extends JpaRepository<Recipes, Long> {

    Optional<Recipes> findByCusine(Cusine cusine);
    Optional<Recipes> findByRecipeName(String name);
    Optional<Recipes> findByIngredients(Ingredients ingredient);
    Optional<Recipes> findById(Integer id);


//    @EntityGraph(value = Recipes.ingredients, type= EntityGraph.EntityGraphType.FETCH)
//    List<Ingredients> findById ;

}
