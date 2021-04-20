package it.projecteat.finalproject.Controllers;

import it.projecteat.finalproject.Entity.Token;
import it.projecteat.finalproject.Entity.User;
import it.projecteat.finalproject.Repositories.UserRepo;
import it.projecteat.finalproject.Repositories.TokenRepo;
import it.projecteat.finalproject.Services.UserService;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.security.Principal;
import java.util.Collection;

@Controller
public class UserController {

    private UserService userService;
    private TokenRepo tokenRepo;
    private UserRepo userRepo;



    public UserController(UserService userService, TokenRepo tokenRepo, UserRepo userRepo) {

        this.userService = userService;
        this.tokenRepo = tokenRepo;
        this.userRepo = userRepo;
    }

    @GetMapping("/hello")
    public String hello(Principal principal, Model model) {
        User user = userRepo.findByUsername(principal.getName()).orElseThrow(RuntimeException::new);
//        UserDetails userDetails = userService.readDetails (user.getId());
//        model.addAttribute("userDetails", userDetails);
        model.addAttribute("user", user);
        Collection<? extends GrantedAuthority> authorities =  SecurityContextHolder.getContext().getAuthentication().getAuthorities();
        model.addAttribute("authorities", authorities);
        return "hello";
    }

    @GetMapping("/edit")
    public String getEdit(Principal principal, Model model){
        User user = userRepo.findByUsername(principal.getName()).orElseThrow(RuntimeException::new);
//        UserDetails userDetails = userService.readDetails (user.getId());
        model.addAttribute("user", user);
//        model.addAttribute("userDetails", userDetails);
        return "user-details";
    }

    @PostMapping("/edit")
    public String submitEdit(@ModelAttribute User user, Model model){
        model.addAttribute("user", user);
//        model.addAttribute("userDetails", userDetails);
        userService.updateUser(user);
        return "user-details";
    }

    @GetMapping("/sign-up")
    public String signup(Model model) {
        model.addAttribute("user", new User());
        return "sign-up";
    }

    @PostMapping("/register")
    public String register(User user) {
        userService.addUser(user);
        return "sign-up";
    }

    @GetMapping("/token")
    public String signup (@RequestParam String value){
        Token byValue = tokenRepo.findByValue(value);
        User user = byValue.getUser();
        user.setEnabled(true);
        userRepo.save(user);
        return "hello";
    }
    }





