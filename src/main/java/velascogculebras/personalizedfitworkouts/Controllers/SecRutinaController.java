package velascogculebras.personalizedfitworkouts.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import velascogculebras.personalizedfitworkouts.Entities.Rutina;
import velascogculebras.personalizedfitworkouts.Repositories.RutinaRepository;

@Controller
public class SecRutinaController {
    @Autowired
    private RutinaRepository rutinaRepository;


    @RequestMapping("/secRutina")
    private String getComentarios(Model model, long rutinaId) {
        Rutina rutina = rutinaRepository.getOne(rutinaId);

        model.addAttribute("Rutinas", rutina);
        model.addAttribute("Comentarios", rutina.getComentarios());
        return "secRutina";

    }
}