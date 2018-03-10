package velascogculebras.personalizedfitworkouts.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import velascogculebras.personalizedfitworkouts.Entities.Entrenador;
import velascogculebras.personalizedfitworkouts.Repositories.EntrenadorRepository;

import javax.servlet.http.HttpSession;

@Controller
public class SecEntrenadorController {
    @Autowired
    private EntrenadorRepository entrenadorRepository;

    @RequestMapping("/secEntrenador")
    private String getEntrenador(Model model, HttpSession session, long id) {
        model.addAttribute("logged", session.getAttribute("user"));
        model.addAttribute("isTrainer", session.getAttribute("user") instanceof Entrenador);

        Entrenador entrenador = entrenadorRepository.findOne(id);
        model.addAttribute("entrenador", entrenador);
        model.addAttribute("Rutinas", entrenador.getRutinas());
        return "SecEntrenador";
    }

}
