package it.projecteat.finalproject.AppConfig;

import it.projecteat.finalproject.Entity.User;
import it.projecteat.finalproject.Repositories.AppUserRepo;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class Start {

    private AppUserRepo appUserRepo;


    public Start(AppUserRepo appUserRepo, PasswordEncoder passwordEncoder) {
        this.appUserRepo = appUserRepo;

        User userJ = new User();
        userJ.setUsername("Janusz");
        userJ.setPassword(passwordEncoder.encode("Janusz123"));
        userJ.setRole("ROLE_ADMIN");
        userJ.setEnabled(true);

        User userB = new User();
        userB.setUsername("Bogdan");
        userB.setPassword(passwordEncoder.encode("Bogdan123"));
        userB.setRole("ROLE_USER");
        userB.setEnabled(true);

        appUserRepo.save(userB);
        appUserRepo.save(userJ);


    }
}
