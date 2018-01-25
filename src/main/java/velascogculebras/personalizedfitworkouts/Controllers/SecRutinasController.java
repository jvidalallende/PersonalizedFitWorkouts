package velascogculebras.personalizedfitworkouts.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import velascogculebras.personalizedfitworkouts.Entities.Rutina;
import velascogculebras.personalizedfitworkouts.Repositories.RutinaRepository;

import java.util.List;

@Controller
public class SecRutinasController {
    @Autowired
    private RutinaRepository rutinaRepository;

    @RequestMapping("/SecRutinas")
    public String getRutines(Model model) {
        List<Rutina> rutinas = rutinaRepository.findAll();
        model.addAttribute("Rutinas", rutinas);
        return "SecRutinas";
    }

}
