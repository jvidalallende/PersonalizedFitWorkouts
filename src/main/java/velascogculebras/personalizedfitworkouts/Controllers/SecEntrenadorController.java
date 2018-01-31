package velascogculebras.personalizedfitworkouts.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import velascogculebras.personalizedfitworkouts.Entities.Entrenador;
import velascogculebras.personalizedfitworkouts.Repositories.EntrenadorRepository;

@Controller
public class SecEntrenadorController {
    @Autowired
    private EntrenadorRepository entrenadorRepository;

    @RequestMapping("/secEntrenador")
    private String getEntrenador(Model model, long id) {
        Entrenador entrenador = entrenadorRepository.findOne(id);
        model.addAttribute("entrenador", entrenador);
        return "SecEntrenador";
    }

}
