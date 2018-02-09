package velascogculebras.personalizedfitworkouts.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import velascogculebras.personalizedfitworkouts.Repositories.EntrenadorRepository;

@Controller
public class LoggingEntrenador {
    @Autowired
    private EntrenadorRepository entrenadorRepository;

    @RequestMapping("/entrenador")
    private String LoggingEntrenador(Model model){
        entrenadorRepository.findByMailAndPassword("pepe@gmail.com","pepe");
        return "Entrenador";
    }
}