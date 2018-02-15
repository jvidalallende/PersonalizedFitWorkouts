package velascogculebras.personalizedfitworkouts.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import velascogculebras.personalizedfitworkouts.Configuration.UserRepositoryAuthenticationProvider;

@Controller
public class LoggedController {
    @Autowired
    private UserRepositoryAuthenticationProvider userRepositoryAuthenticationProvider;

    @RequestMapping("/Logged")
    private String logged(Model model, @RequestParam String mail, @RequestParam String password){

        return "/";
    }

    @RequestMapping("/login")
    private String login() {
        return "login";
    }

    @RequestMapping("/loginerror")
    private String loginError(Model model) {
        model.addAttribute("error", "Email or password incorrect");
        return "login";
    }
}
