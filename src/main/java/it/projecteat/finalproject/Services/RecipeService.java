package it.projecteat.finalproject.Services;


import it.projecteat.finalproject.Entity.Ingredients;
import it.projecteat.finalproject.Entity.Recipes;
import it.projecteat.finalproject.Repositories.IngredientsRepo;
import it.projecteat.finalproject.Repositories.RecipeRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@AllArgsConstructor
@Transactional
public class RecipeService {

    private RecipeRepo recipeRepo;
    private IngredientsRepo ingredientsRepo;


    public void addRecipe (Recipes recipe){
        recipe.setRecipeName(recipe.getRecipeName());
        recipe.setRecipeDescription(recipe.getRecipeDescription());
        recipe.setIngredients(recipe.getIngredients());
        recipe.setPreparationTime(recipe.getPreparationTime());
        recipe.setPreparation(recipe.getPreparation());
        recipe.setCusine(recipe.getCusine());
        recipeRepo.save(recipe);
    }

    public List<Recipes> showList (){
        return recipeRepo.findAll();
    }


//    public List<Ingredients> showIngredients(Integer id){
//        List<Ingredients> list = ingredientsRepo.findByRecipeId(id);
//        return list;
//    }
}
