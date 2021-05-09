package it.projecteat.finalproject.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "Recipes")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Recipes {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String recipeName;
    private int preparationTime;
    private String recipeDescription;

    @ManyToMany(fetch = FetchType.EAGER)
    Set<Ingredients> ingredients;

    private String preparation;

    @ManyToOne(fetch = FetchType.EAGER)
    @Cascade(org.hibernate.annotations.CascadeType.MERGE)
    private Cusine cusine;

    public Cusine getCusine() {
        return cusine;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCusine(Cusine cusine) {
        this.cusine = cusine;
    }


    public int getId() {
        return id;
    }

    public String getRecipeName() {
        return recipeName;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    public String getRecipeDescription() {
        return recipeDescription;
    }

    public void setRecipeDescription(String recipeDescription) {
        this.recipeDescription = recipeDescription;
    }

    public String getPreparation() {
        return preparation;
    }

    public void setPreparation(String preparation) {
        this.preparation = preparation;
    }

    public int getPreparationTime() {
        return preparationTime;
    }

    public void setPreparationTime(int preparationTime) {
        this.preparationTime = preparationTime;
    }

    @Override
    public String toString() {
        return "Recipes{" +
                "id=" + id +
                ", recipeName='" + recipeName + '\'' +
                ", recipeDescription='" + recipeDescription + '\'' +
                ", ingredients=" + ingredients +
                ", preparation='" + preparation + '\'' +
                ", preparationTime=" + preparationTime +
                ", cusine=" + cusine +
                '}';
    }

    public Set<Ingredients> getIngredients() {
        return ingredients;
    }

    public void setIngredients(Set<Ingredients> ingredients) {
        this.ingredients = ingredients;
    }

    public Recipes(String recipeName, int preparationTime, String recipeDescription, Set<Ingredients> ingredients, String preparation, Cusine cusine) {
        this.recipeName = recipeName;
        this.preparationTime = preparationTime;
        this.recipeDescription = recipeDescription;
        this.ingredients = ingredients;
        this.preparation = preparation;
        this.cusine = cusine;
    }

}
