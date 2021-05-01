package it.projecteat.finalproject.Controllers;

import it.projecteat.finalproject.Entity.Ingredients;
import it.projecteat.finalproject.Entity.Recipes;
import it.projecteat.finalproject.Repositories.IngredientsRepo;
import it.projecteat.finalproject.Repositories.RecipeRepo;
import it.projecteat.finalproject.Services.IngredientsService;
import it.projecteat.finalproject.Services.RecipeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Set;


@Controller
@AllArgsConstructor
public class RecipeController {

    RecipeService recipeService;
    RecipeRepo recipeRepo;
    IngredientsRepo ingredientsRepo;

    IngredientsService ingredientsService;

    @GetMapping("/recipes")
    public String recipes (Model model){
        model.addAttribute("recipes", recipeService.showList());
        return "recipes";
    }

    @GetMapping("/recipeDetails/{id}")
    public String recipeDetails (Model model, @PathVariable Integer id){
        model.addAttribute("recipes", recipeRepo.findById(id).orElseThrow(RuntimeException::new));
        Set<Ingredients> ingredients =  ingredientsService.showByRecipe(recipeRepo.findById(id).get());
        model.addAttribute("ingredients", ingredients);
        return "recipeDetails";
    }
}
