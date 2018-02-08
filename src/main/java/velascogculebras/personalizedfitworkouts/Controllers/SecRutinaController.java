package velascogculebras.personalizedfitworkouts.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import velascogculebras.personalizedfitworkouts.Entities.Comentario;
import velascogculebras.personalizedfitworkouts.Entities.Rutina;
import velascogculebras.personalizedfitworkouts.Repositories.ComentarioRepository;
import velascogculebras.personalizedfitworkouts.Repositories.RutinaRepository;

import java.util.List;

@Controller
public class SecRutinaController {
    @Autowired
    private RutinaRepository rutinaRepository;
    @Autowired
    private ComentarioRepository comentarioRepository;


    @RequestMapping("/secRutina")
    private String getComentarios(Model model, @RequestParam long rutinaId) {
        Rutina rutina = rutinaRepository.findOne(rutinaId);
        List<Comentario> comentarios = comentarioRepository.findByRutinaOrderByDateAsc(rutina);
        model.addAttribute("Rutinas", rutina);
        model.addAttribute("comentarios", comentarios);
        return "secRutina";

    }
}