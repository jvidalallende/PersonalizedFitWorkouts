package velascogculebras.personalizedfitworkouts.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import velascogculebras.personalizedfitworkouts.Repositories.EntrenadorRepository;

@Controller
public class LoggingEntrenador {
    @Autowired
    private EntrenadorRepository entrenadorRepository;

    @RequestMapping("/trainer")
    private String LoggingEntrenador(Model model){
        model.addAttribute("trainer",entrenadorRepository.findByMailAndPassword("lol","lol"));
        return "Entrenador";
    }
}