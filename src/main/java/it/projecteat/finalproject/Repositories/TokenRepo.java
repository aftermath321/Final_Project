package it.projecteat.finalproject.Repositories;

import it.projecteat.finalproject.Entity.Token;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TokenRepo extends JpaRepository <Token, Long>{

    Token findByValue (String value);


}
