package it.projecteat.finalproject.Controllers;

import it.projecteat.finalproject.Entity.Ingredients;
import it.projecteat.finalproject.Entity.Recipes;
import it.projecteat.finalproject.Services.IngredientsService;
import it.projecteat.finalproject.Services.RecipeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import java.io.IOException;
import java.util.Set;


@Controller
@AllArgsConstructor
public class RecipeController {

    RecipeService recipeService;
    IngredientsService ingredientsService;

    @GetMapping("/recipes")
    public String recipes (Model model){
        model.addAttribute("recipes", recipeService.showList());
        return "recipes";
    }

    @GetMapping("/addRecipe")
    public String addRecipe (Model model){
        model.addAttribute("recipe", new Recipes());
        Set<Ingredients> ingredients =  ingredientsService.allShow();
        model.addAttribute("ingredients", ingredients);
        model.addAttribute("cusines", recipeService.findAllCusine());
        return "addRecipe";
    }

    @PostMapping("/addRecipes")
    public String addRecipes (Recipes recipes, RedirectAttributes redirAttrs) throws IOException {
        recipeService.addRecipe(recipes);
        redirAttrs.addFlashAttribute("success", "Recipe added");
        return "redirect:/addRecipe";
    }

    @GetMapping("/recipeDetails/{id}")
    public String recipeDetails (Model model, @PathVariable Integer id){
        model.addAttribute("recipes", recipeService.findById(id));
        Set<Ingredients> ingredients =  ingredientsService.showByRecipe(recipeService.findById(id));
        model.addAttribute("ingredients", ingredients);
        return "recipeDetails";
    }

    @GetMapping("/search")
    public String getSearch (){
        return "search";
    }

    @PostMapping("/search")
    public String postSearch (@RequestParam int id,@RequestParam String phrase, Model model){
        switch (id){
            case 1:
                model.addAttribute("resultsI", ingredientsService.findByName(phrase));
            case 2:
                model.addAttribute("resultsR", recipeService.findByName(phrase));
        }
        return "results";
    }

    @GetMapping("/results/")
    public String results (){

        return "results";
    }
}
