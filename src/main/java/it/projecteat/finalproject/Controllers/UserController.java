package it.projecteat.finalproject.Controllers;

import it.projecteat.finalproject.Entity.Token;
import it.projecteat.finalproject.Entity.User;
import it.projecteat.finalproject.Repositories.UserRepo;
import it.projecteat.finalproject.Repositories.TokenRepo;
import it.projecteat.finalproject.Services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.Principal;
import java.util.Collection;

@Controller
@AllArgsConstructor
public class UserController {

    private UserService userService;
    private TokenRepo tokenRepo;
    private UserRepo userRepo;

    @GetMapping("/hello")
    public String hello(Principal principal, Model model) {
        User user = userRepo.findByUsername(principal.getName()).orElseThrow(RuntimeException::new);
        model.addAttribute("user", user);
        Collection<? extends GrantedAuthority> authorities =  SecurityContextHolder.getContext().getAuthentication().getAuthorities();
        model.addAttribute("authorities", authorities);
        return "hello";
    }

    @GetMapping("/index")
    public String homePage() {
        return "index";
    }

    @GetMapping("/edit")
    public String getEdit(Principal principal, Model model){
        User user = userRepo.findByUsername(principal.getName()).orElseThrow(RuntimeException::new);
        model.addAttribute("user", user);
        return "user-details";
    }

    @PostMapping("/edit")
    public String submitEdit(@ModelAttribute User user, Model model, RedirectAttributes redirAttrs){
        model.addAttribute("user", user);
        userService.updateUser(user);
        redirAttrs.addFlashAttribute("okay", "Details changed!");
        return "redirect:/logout";
//      Zabezpiecz przed already in use!!!
    }

    @GetMapping("/sign-up")
    public String signup(Model model) {
        model.addAttribute("user", new User());
        return "sign-up";
    }


    @PostMapping("/register")
    public String register(User user, RedirectAttributes redirAttrs)
            throws IOException, IOException {
        if (!userService.isEmailexists(user) || !userService.isUserNameExists(user)) {
            userService.addUser(user);
            redirAttrs.addFlashAttribute("success", "Please confirm your e-mail address");
            return "redirect:/sign-up";
        } else {
            redirAttrs.addFlashAttribute("error", "Username or E-mail already in use!");
            return "redirect:/sign-up";
        }
    }

    @GetMapping("/token")
    public String signup (@RequestParam String value){
        Token byValue = tokenRepo.findByValue(value);
        User user = byValue.getUser();
        user.setEnabled(true);
        userRepo.save(user);
        return "index";
    }
}

