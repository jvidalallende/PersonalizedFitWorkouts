package velascogculebras.personalizedfitworkouts.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import velascogculebras.personalizedfitworkouts.Repositories.EntrenadorRepository;
import velascogculebras.personalizedfitworkouts.Repositories.UsuarioReporsitory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.security.Principal;

@Controller
public class LoggedController {

    @Autowired
    public EntrenadorRepository entrenadorRepository;
    @Autowired
    public UsuarioReporsitory usuarioReporsitory;


    @RequestMapping("/login")
    private String login() {
        return "login";
    }

    @GetMapping("/logged")
    private String logged(HttpSession session, HttpServletRequest request) {
        Principal user = request.getUserPrincipal();
        if (request.isUserInRole("ROLE_TRAINER")) {
            session.setAttribute("user", entrenadorRepository.findByMail(user.getName()));
        } else {
            session.setAttribute("user", usuarioReporsitory.findByMail(user.getName()));
        }

        return "redirect:/";
    }



    @RequestMapping("/loginerror")
    private String loginError(Model model) {
        model.addAttribute("error", "Email or password incorrect");
        return "login";
    }
}
