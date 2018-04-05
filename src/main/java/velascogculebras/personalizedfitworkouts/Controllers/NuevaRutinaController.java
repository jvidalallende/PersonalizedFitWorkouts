package velascogculebras.personalizedfitworkouts.Controllers;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import velascogculebras.personalizedfitworkouts.Entities.Entrenador;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class NuevaRutinaController {

    @GetMapping("/nuevaRutina")
    @CacheEvict(value = {"rutinas", "index"}, allEntries = true)
    public String getPerfil(Model model, HttpServletRequest request, HttpSession session) {

        model.addAttribute("logged", session.getAttribute("user"));
        model.addAttribute("isTrainer", session.getAttribute("user") instanceof Entrenador);

        if (request.isUserInRole("ROLE_TRAINER")) {
            model.addAttribute("trainer", session.getAttribute("user"));
            return "nuevaRutina";
        }

        return "error";
    }
}

