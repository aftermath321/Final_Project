package it.projecteat.finalproject.Controllers;

import it.projecteat.finalproject.Entity.Ingredients;
import it.projecteat.finalproject.Entity.Recipes;
import it.projecteat.finalproject.Services.IngredientsService;
import it.projecteat.finalproject.Services.RecipeService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.security.Principal;
import java.util.List;
import java.util.Set;

@Controller
@AllArgsConstructor
public class IngredientsController {

    private IngredientsService ingredientsService;
    private RecipeService recipeService;

    @GetMapping("/ingredients")
    public String recipes(Model model) {
        model.addAttribute("ingredients", ingredientsService.showAll());
        return "ingredients";
    }

    @GetMapping("/addIngredient")
    public String addIngredient(Model model) {
        model.addAttribute("ingredient", new Ingredients());
        return "addIngredients";
    }

    @PostMapping("/addIngredients")
    public String addIngredient(Ingredients ingredient, RedirectAttributes redirAttrs) throws IOException, IOException {
        if (!ingredientsService.ingredientExists(ingredient)) {
            ingredientsService.saveIngredients(ingredient);
            redirAttrs.addFlashAttribute("success", "Ingredient added");
            return "redirect:/addIngredient";
        } else {
            redirAttrs.addFlashAttribute("error", "Ingredient already exists");
            return "redirect:/addIngredient";
        }

    }
    @ModelAttribute("recipes")
    public List<Recipes> recipes() {
        return this.recipeService.showList();
    }

}
