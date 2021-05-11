package it.projecteat.finalproject.Repositories;

import it.projecteat.finalproject.Entity.Recipes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import java.util.List;
import java.util.Optional;

public interface RecipeRepo extends JpaRepository<Recipes, Long> {


    Optional<Recipes> findById(Integer id);
    List<Recipes> findByRecipeNameContaining (@Param("name") String name);

}
