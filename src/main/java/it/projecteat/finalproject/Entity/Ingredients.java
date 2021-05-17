package it.projecteat.finalproject.Entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Cascade;
import javax.persistence.*;
import java.util.Set;

@Entity(name = "Ingredients")
@NoArgsConstructor
@Setter
@Getter
public class Ingredients {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String ingredientName;

    private int kcal;

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "ingredients")
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    Set<Recipes> recipes;

    @Override
    public String toString() {
        return "Ingredients{" +
                "id=" + id +
                ", ingredientName='" + ingredientName + '\'' +
                ", kcal=" + kcal +
                '}';

    }

    public Ingredients(int id, String ingredientName, int kcal) {
        this.id = id;
        this.kcal = kcal;
        this.ingredientName = ingredientName;

    }

    public Ingredients(int id) {
        this.id = id;

    }

}
