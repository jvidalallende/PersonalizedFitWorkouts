package velascogculebras.personalizedfitworkouts.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import velascogculebras.personalizedfitworkouts.Entities.Categoria;
import velascogculebras.personalizedfitworkouts.Entities.Rutina;
import velascogculebras.personalizedfitworkouts.Repositories.CategoriaRepository;
import velascogculebras.personalizedfitworkouts.Repositories.RutinaRepository;

import java.util.List;

@Controller
public class SecRutinasController {
    @Autowired
    private RutinaRepository rutinaRepository;
    @Autowired
    private CategoriaRepository categoriaRepository;

    @RequestMapping("/secRutinas")
    public String getRutines(Model model) {
        List<Rutina> rutinas = rutinaRepository.findAll();
        model.addAttribute("Rutinas", rutinas);
        return "SecRutinas";
    }

    @RequestMapping("/secRutinas/filter")
    public String getRutinesByCategoria(Model model, @RequestParam long categoriaId) {
        Categoria categoria = categoriaRepository.findOne(categoriaId);
        List<Rutina> rutinas = categoria.getRutinas();
        model.addAttribute("Rutinas", rutinas);
        return "SecRutinas";
    }

}
