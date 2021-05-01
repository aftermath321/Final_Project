package it.projecteat.finalproject;

import it.projecteat.finalproject.Entity.*;
import it.projecteat.finalproject.Repositories.UserDetailsRepo;
import it.projecteat.finalproject.Repositories.UserRepo;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
class Start {

    public Start(UserRepo userRepo, PasswordEncoder passwordEncoder, UserDetailsRepo userDetailsRepo) {


        User userJ = new User();
        UserDetails userJD = new UserDetails();
        userJ.setUsername("Jarek");
        userJ.setPassword(passwordEncoder.encode("Jarek123"));
        userJ.setRole("ROLE_ADMIN");
        userJD.setUser(userJ);
        userJD.setFirstName("Jarek");
        userJD.setLastName("Kowalski");
        userJD.setDescription("Jakis tam opis");
        userJ.setEmail("jakisemail@wp.pl");
        userJ.setEnabled(true);

        User userB = new User();
        userB.setUsername("Maciej");
        userB.setPassword(passwordEncoder.encode("Maciej123"));
        userB.setRole("ROLE_USER");
        userB.setEnabled(true);

        userRepo.save(userB);
        userRepo.save(userJ);
        userDetailsRepo.save(userJD);

    }
}
