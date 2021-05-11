package it.projecteat.finalproject.Repositories;

import it.projecteat.finalproject.Entity.Cusine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CusineRepo extends JpaRepository<Cusine, Long> {


}
