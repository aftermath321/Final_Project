package it.projecteat.finalproject.Services;

import it.projecteat.finalproject.Entity.Cusine;
import it.projecteat.finalproject.Entity.Recipes;
import it.projecteat.finalproject.Repositories.CusineRepo;
import it.projecteat.finalproject.Repositories.IngredientsRepo;
import it.projecteat.finalproject.Repositories.RecipeRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@Service
@AllArgsConstructor
@Transactional
public class RecipeService {

    private final RecipeRepo recipeRepo;
    private final IngredientsRepo ingredientsRepo;
    private final CusineRepo cusineRepo;
    EntityManager entityManager;

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
//        entityManager.persist(recipe);
    }

    public List<Recipes> showList (){
        return recipeRepo.findAll();
    }

    public Recipes findById(int id){
       return recipeRepo.findById(id).get();
    }

    public List<Cusine> findAllCusine(){
        return cusineRepo.findAll();
    }

    public List<Recipes> findByName(String name){
        return recipeRepo.findByRecipeNameContaining(name);
    }


}
