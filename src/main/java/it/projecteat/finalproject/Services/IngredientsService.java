package it.projecteat.finalproject.Services;


import it.projecteat.finalproject.Entity.Ingredients;
import it.projecteat.finalproject.Entity.Recipes;
import it.projecteat.finalproject.Entity.User;
import it.projecteat.finalproject.Repositories.IngredientsRepo;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Transactional
public class IngredientsService {


    private IngredientsRepo ingredientsRepo;


    private void saveIngredient (Ingredients ingredients){
        ingredients.setIngredientName(ingredients.getIngredientName());
        ingredients.setKcal(ingredients.getKcal());
        ingredientsRepo.save(ingredients);
    }

    @EntityGraph("recipes")
    public Set<Ingredients> showByRecipe(Recipes recipes){
        return ingredientsRepo.findAllByRecipes(recipes);
    }

    public List<Ingredients> showAll(){
        return ingredientsRepo.findAll();
    }

    public Set<Ingredients> allShow(){
        Set<Ingredients> set = ingredientsRepo.findAll().stream().collect(Collectors.toSet());
        return set;
    }

    public void saveIngredients (Ingredients ingredients){
        ingredients.setIngredientName(ingredients.getIngredientName());
        ingredients.setKcal(ingredients.getKcal());
        ingredientsRepo.save(ingredients);
    }

    public boolean ingredientExists (Ingredients ingredients){
        if (ingredientsRepo.findByIngredientName(ingredients.getIngredientName()).isEmpty()){
            return false;
        }else {
            return true;
        }
    }



}
