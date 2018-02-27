package velascogculebras.personalizedfitworkouts.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import velascogculebras.personalizedfitworkouts.Repositories.EntrenadorRepository;

import javax.servlet.http.HttpSession;

@Controller
public class secEntrenadoresController {
    @Autowired
    EntrenadorRepository entrenadorRepository;

    @RequestMapping("/secEntrenadores")
    private String getEntrenadores(Model model, HttpSession session) {
        model.addAttribute("logged", session.getAttribute("user"));
        model.addAttribute("entrenadores", entrenadorRepository.findAll());
        return "SecEntrenadores";
    }
}
