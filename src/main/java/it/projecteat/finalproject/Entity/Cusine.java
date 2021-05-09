package it.projecteat.finalproject.Entity;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity(name="Cusine")
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Cusine(String name, Set<Recipes> recipes) {
        this.name = name;
        this.recipes = recipes;
    }

    public Cusine() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Recipes> getRecipes() {
        return recipes;
    }

    public void setRecipes(Set<Recipes> recipes) {
        this.recipes = recipes;
    }
}
