package it.projecteat.finalproject.Controllers;

import it.projecteat.finalproject.Entity.Cusine;
import it.projecteat.finalproject.Entity.Ingredients;
import it.projecteat.finalproject.Entity.Recipes;
import it.projecteat.finalproject.Repositories.CusineRepo;
import it.projecteat.finalproject.Repositories.IngredientsRepo;
import it.projecteat.finalproject.Repositories.RecipeRepo;
import it.projecteat.finalproject.Services.IngredientsService;
import it.projecteat.finalproject.Services.RecipeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.util.List;
import java.util.Set;


@Controller
@AllArgsConstructor
public class RecipeController {

    RecipeService recipeService;
    RecipeRepo recipeRepo;
    IngredientsRepo ingredientsRepo;
    CusineRepo cusineRepo;

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

    @GetMapping("/addRecipe")
    public String addRecipe (Model model){
        Set<Ingredients> ingredients =  ingredientsService.allShow();
        model.addAttribute("recipe", new Recipes());
        model.addAttribute("ingredients", ingredients);
        model.addAttribute("cusine", cusineRepo.findAll());
        return "addRecipe";
    }

    @PostMapping("/addRecipes")
    public String addRecipes (Recipes recipes, RedirectAttributes redirAttrs) throws IOException, IOException {
        recipeService.addRecipe(recipes);
        redirAttrs.addFlashAttribute("success", "Recipe added");
        return "redirect:/addRecipe";
    }
}
