package it.projecteat.finalproject.Repositories;

import it.projecteat.finalproject.Entity.Ingredients;
import it.projecteat.finalproject.Entity.Recipes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface IngredientsRepo extends JpaRepository<Ingredients, Long> {

    Optional<Ingredients> findByIngredientName (String ingredient);
    Optional<Ingredients> findById(Integer id);
    Optional<Ingredients> findAllById(Integer id);
    Set<Ingredients> findAllByRecipes (Recipes recipes);


////    @Query("select u from RecipeIngredients u where u.recipeId = :id")
//    List<Ingredients> findByRecipeId(Integer id);

}
