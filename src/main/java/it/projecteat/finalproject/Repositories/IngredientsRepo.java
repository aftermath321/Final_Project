package it.projecteat.finalproject.Repositories;

import it.projecteat.finalproject.Entity.Ingredients;
import it.projecteat.finalproject.Entity.Recipes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface IngredientsRepo extends JpaRepository<Ingredients, Long> {

    Optional<Ingredients> findByIngredientName(String ingredient);

    Set<Ingredients> findAllByRecipes(Recipes recipes);

    List<Ingredients> findByIngredientNameContaining(@Param("name") String name);

}
