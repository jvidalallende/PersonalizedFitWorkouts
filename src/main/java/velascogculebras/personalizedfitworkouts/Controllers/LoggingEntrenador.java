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

    @RequestMapping("/entrenador")
    private String LoggingEntrenador(Model model, @RequestParam String nombreE, @RequestParam String passwordE, @RequestParam String emailE,@RequestParam String bioE){
        model.addAttribute("nombre",nombreE);
        model.addAttribute("mail",emailE);
        model.addAttribute("password",passwordE);
        model.addAttribute("biografia",bioE);
        entrenadorRepository.findByMailAndPassword("pepe@gmail.com","pepe");
        return "Entrenador";
    }
}