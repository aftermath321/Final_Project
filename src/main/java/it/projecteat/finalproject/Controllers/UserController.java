package it.projecteat.finalproject.Controllers;

import it.projecteat.finalproject.Entity.Token;
import it.projecteat.finalproject.Entity.User;
import it.projecteat.finalproject.Repositories.AppUserRepo;
import it.projecteat.finalproject.Repositories.TokenRepo;
import it.projecteat.finalproject.Services.UserService;
import org.springframework.orm.hibernate5.SpringSessionContext;
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
    private AppUserRepo appUserRepo;

    public UserController(UserService userService, TokenRepo tokenRepo, AppUserRepo appUserRepo) {

        this.userService = userService;
        this.tokenRepo = tokenRepo;
        this.appUserRepo = appUserRepo;
    }

/*    @GetMapping("/hello")
    @ResponseBody
    public String hello(){
        return "hello";
    }*/

    @GetMapping("/hello")
    public String hello(Principal principal, Model model) {
        model.addAttribute("name", principal.getName());
        Collection<? extends GrantedAuthority> authorities =  SecurityContextHolder.getContext().getAuthentication().getAuthorities();
        model.addAttribute("authorities", authorities);
        return "hello";
    }

    @GetMapping("/sign-up")
    public String singup(Model model) {
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
        appUserRepo.save(user);
        return "hello";
    }
    }





