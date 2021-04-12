package it.projecteat.finalproject.Services;


import it.projecteat.finalproject.Entity.Token;
import it.projecteat.finalproject.Repositories.AppUserRepo;
import it.projecteat.finalproject.Entity.User;
import it.projecteat.finalproject.Repositories.TokenRepo;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.util.UUID;

@Service
public class UserService {

    private AppUserRepo appUserRepo;
    private PasswordEncoder passwordEncoder;
    private TokenRepo tokenRepo;
    private MailService mailService;


    public UserService(AppUserRepo appUserRepo, PasswordEncoder passwordEncoder, TokenRepo tokenRepo, MailService mailService) {
        this.appUserRepo = appUserRepo;
        this.passwordEncoder = passwordEncoder;
        this.tokenRepo = tokenRepo;
        this.mailService = mailService;
    }


    public void addUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setEmail(user.getEmail());
        user.setRole("ROLE_USER");
        appUserRepo.save(user);
        sendToken(user);
    }

    public void sendToken(User user) {
        String tokenValue = UUID.randomUUID().toString();
        Token token = new Token();
        token.setValue(tokenValue);
        token.setUser(user);
        tokenRepo.save(token);

        String url = "http://localhost:8080/token?value=" + tokenValue;

        try {
            mailService.sendMail(user.getEmail(), "Potwierdz konto", url, false);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
