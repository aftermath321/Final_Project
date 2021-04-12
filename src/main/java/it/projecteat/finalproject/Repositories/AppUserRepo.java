package it.projecteat.finalproject.Repositories;

import it.projecteat.finalproject.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AppUserRepo extends JpaRepository<User, Long> {

    Optional<User> findByUsername (String username);

}
