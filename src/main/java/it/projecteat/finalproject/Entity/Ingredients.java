package it.projecteat.finalproject.Entity;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "Ingredients")
public class Ingredients {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String ingredientName;
    private int kcal;

    @ManyToMany(mappedBy = "ingredients", fetch = FetchType.EAGER)
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private Set<Recipes> recipes;

    public int getId() {
        return id;
    }

    public String getIngredientName() {
        return ingredientName;
    }

    public void setIngredientName(String ingredientName) {
        this.ingredientName = ingredientName;
    }

    public int getKcal() {
        return kcal;
    }

    public void setKcal(int kcal) {
        this.kcal = kcal;
    }

    @Override
    public String toString() {
        return "Ingredients{" +
                "id=" + id +
                ", ingredientName='" + ingredientName + '\'' +
                ", kcal=" + kcal +
                '}';
    }

    public Ingredients() {
    }

    public Ingredients(String ingredientName, int kcal) {
        this.ingredientName = ingredientName;
        this.kcal = kcal;
    }
}
