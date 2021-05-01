package it.projecteat.finalproject.Services;


import it.projecteat.finalproject.Entity.Token;
import it.projecteat.finalproject.Entity.UserDetails;
import it.projecteat.finalproject.Repositories.UserDetailsRepo;
import it.projecteat.finalproject.Repositories.UserRepo;
import it.projecteat.finalproject.Entity.User;
import it.projecteat.finalproject.Repositories.TokenRepo;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import javax.mail.MessagingException;
import java.util.UUID;

@Service
public class UserService {

    private UserRepo userRepo;
    private PasswordEncoder passwordEncoder;
    private TokenRepo tokenRepo;
    private MailService mailService;
    private UserDetailsRepo userDetailsRepo;


    public UserService(UserRepo userRepo, PasswordEncoder passwordEncoder, TokenRepo tokenRepo, MailService mailService, UserDetailsRepo userDetailsRepo) {
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
        this.tokenRepo = tokenRepo;
        this.mailService = mailService;
        this.userDetailsRepo = userDetailsRepo;
    }


    public void addUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        UserDetails userDetails = new UserDetails();
        user.setEmail(user.getEmail());
        userRepo.save(user);
        userDetailsRepo.save(userDetails);
        sendToken(user);
    }

    public void updateUser(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setEmail(user.getEmail());
        user.setUsername(user.getUsername());
        user.setEnabled(true);
        user.setRole(user.getRole());
//        userDetails.setDescription(userDetails.getDescription());
//        userDetails.setFirstName(userDetails.getFirstName());
//        userDetails.setLastName(userDetails.getLastName());
        user.getUserDetails().setUser(user);
        userRepo.save(user);
//        userDetailsRepo.save(userDetails);
    }


//    public UserDetails readDetails (int id){
//        UserDetails userDetails = userDetailsRepo.findByUser_Id(id);
//        return userDetails;
//    }

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

    public boolean isEmailexists(User user) {
        if (userRepo.findUserByEmail(user.getEmail()).isEmpty()) {
            return false;
        } else {
            return true;
        }
    }

    public boolean isUserNameExists(User user) {
        if (userRepo.findByUsername(user.getUsername()).isEmpty()) {
            return false;
        } else {
            return true;
        }
    }





















}
