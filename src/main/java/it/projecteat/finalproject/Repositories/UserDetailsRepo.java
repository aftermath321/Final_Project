package it.projecteat.finalproject.Repositories;

import it.projecteat.finalproject.Entity.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDetailsRepo extends JpaRepository<UserDetails, Long> {

}

