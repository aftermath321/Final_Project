package it.projecteat.finalproject.Services;

import it.projecteat.finalproject.Entity.Ingredients;
import it.projecteat.finalproject.Entity.Recipes;
import it.projecteat.finalproject.Repositories.IngredientsRepo;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
@Transactional
public class IngredientsService {


    final private IngredientsRepo ingredientsRepo;
    EntityManager entityManager;

    @EntityGraph("recipes")
    public Set<Ingredients> showByRecipe(Recipes recipes) {
        return ingredientsRepo.findAllByRecipes(recipes);

    }

    public List<Ingredients> showAll() {
        return ingredientsRepo.findAll();

    }

    public Set<Ingredients> allShow() {
        return new HashSet<>(ingredientsRepo.findAll());

    }

    public void saveIngredients(Ingredients ingredients) {
        ingredients.setIngredientName(ingredients.getIngredientName());
        ingredients.setKcal(ingredients.getKcal());
        ingredientsRepo.save(ingredients);

    }

    public boolean ingredientExists(Ingredients ingredients) {
        return ingredientsRepo.findByIngredientName(ingredients.getIngredientName()).isPresent();

    }

    public List<Ingredients> findByName(String name) {
        return ingredientsRepo.findByIngredientNameContaining(name);

    }

}
