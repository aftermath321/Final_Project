package it.projecteat.finalproject.Services;


import it.projecteat.finalproject.Entity.Cusine;
import it.projecteat.finalproject.Entity.Ingredients;
import it.projecteat.finalproject.Entity.Recipes;
import it.projecteat.finalproject.Repositories.CusineRepo;
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
    private CusineRepo cusineRepo;


    public void addRecipe (Recipes recipe){
        recipe.setRecipeName(recipe.getRecipeName());
        recipe.setRecipeDescription(recipe.getRecipeDescription());
        recipe.setPreparationTime(recipe.getPreparationTime());
        recipe.setPreparation(recipe.getPreparation());
        recipe.setCusine(recipe.getCusine());
        recipe.setIngredients(recipe.getIngredients());
//        ingredientsRepo.save(ingredients);
//        cusineRepo.save(cusine);
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
