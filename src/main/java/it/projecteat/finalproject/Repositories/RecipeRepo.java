package it.projecteat.finalproject.Repositories;

import it.projecteat.finalproject.Entity.Cusine;
import it.projecteat.finalproject.Entity.Ingredients;
import it.projecteat.finalproject.Entity.Recipes;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface RecipeRepo extends JpaRepository<Recipes, Long> {

    Optional<Recipes> findByCusine(Cusine cusine);
    Optional<Recipes> findByRecipeName(String name);
    Optional<Recipes> findByIngredients(Ingredients ingredient);
    Optional<Recipes> findById(Integer id);

}
