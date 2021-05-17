package it.projecteat.finalproject.Entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Cascade;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "Cusine")
@Getter
@Setter
@NoArgsConstructor
public class Cusine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @OneToMany(fetch = FetchType.EAGER)
    @Cascade(org.hibernate.annotations.CascadeType.MERGE)
    Set<Recipes> recipes = new HashSet<Recipes>(0);

    @Override
    public String toString() {
        return "Cusine{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", recipes=" + recipes +
                '}';

    }


    public Cusine(String name, Set<Recipes> recipes) {
        this.name = name;
        this.recipes = recipes;

    }

}
