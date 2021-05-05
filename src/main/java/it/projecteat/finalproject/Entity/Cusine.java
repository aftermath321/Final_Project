package it.projecteat.finalproject.Entity;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.Set;

@Entity(name="Cusine")
public class Cusine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @OneToMany
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    Set<Recipes> recipes;

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
