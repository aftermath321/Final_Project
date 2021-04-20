package it.projecteat.finalproject.Repositories;

import it.projecteat.finalproject.Entity.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UserDetailsRepo extends JpaRepository<UserDetails, Long> {


    UserDetails findByUser_Id (int id);

}

