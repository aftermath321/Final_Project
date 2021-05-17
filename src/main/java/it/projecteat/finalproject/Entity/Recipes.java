package it.projecteat.finalproject.Entity;

import lombok.*;
import org.hibernate.annotations.Cascade;
import javax.persistence.*;
import java.util.Set;

@Entity(name = "Recipes")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Setter
public class Recipes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String recipeName;
    private int preparationTime;
    private String recipeDescription;
    private String preparation;

    @ManyToMany(fetch = FetchType.EAGER)
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    Set<Ingredients> ingredients;

    @ManyToOne(fetch = FetchType.EAGER)
    @Cascade(org.hibernate.annotations.CascadeType.MERGE)
    private Cusine cusine;

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

    public Recipes(String recipeName, int preparationTime, String recipeDescription, Set<Ingredients> ingredients, String preparation, Cusine cusine) {
        this.recipeName = recipeName;
        this.preparationTime = preparationTime;
        this.recipeDescription = recipeDescription;
        this.ingredients = ingredients;
        this.preparation = preparation;
        this.cusine = cusine;

    }

}
