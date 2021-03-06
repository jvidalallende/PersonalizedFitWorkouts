package velascogculebras.personalizedfitworkouts.Controllers;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import velascogculebras.personalizedfitworkouts.Entities.Entrenador;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class ProfileController {

    @GetMapping("/miPerfil")
    @Cacheable("profile")
public String getPerfil(Model model, HttpServletRequest request, HttpSession session) {

    model.addAttribute("logged", session.getAttribute("user"));
        model.addAttribute("isTrainer", session.getAttribute("user") instanceof Entrenador);

        if (request.isUserInRole("ROLE_TRAINER")) {
        model.addAttribute("trainer", session.getAttribute("user"));
        return "Entrenador";
    } else if (request.isUserInRole("ROLE_USER")) {
        model.addAttribute("user", session.getAttribute("user"));
        return "Usuario";
    }

    return "error";
}
}
