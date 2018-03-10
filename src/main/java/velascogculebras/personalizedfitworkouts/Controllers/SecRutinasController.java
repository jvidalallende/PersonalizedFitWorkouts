package velascogculebras.personalizedfitworkouts.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import velascogculebras.personalizedfitworkouts.Entities.*;
import velascogculebras.personalizedfitworkouts.Repositories.CategoriaRepository;
import velascogculebras.personalizedfitworkouts.Repositories.RutinaRepository;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class SecRutinasController {
    @Autowired
    private RutinaRepository rutinaRepository;
    @Autowired
    private CategoriaRepository categoriaRepository;

    @RequestMapping("/secRutinas")
    public String getRutines(Model model, HttpSession session) {
        Sort sort = new Sort(Sort.Direction.ASC, "date");
        List<Rutina> rutinas = rutinaRepository.findAll(sort);

        Usuario usuario = (Usuario) session.getAttribute("user");
        if (usuario != null) {
            List<Rutina> rutinasFav = new ArrayList<>(rutinas.size());
            for (Rutina rutina : rutinas) {
                boolean fav = usuario.getRutinasFav().contains(rutina);
                rutinasFav.add(new RutinaFav(rutina, fav));
            }
            model.addAttribute("Rutinas", rutinasFav);
            model.addAttribute("logged", session.getAttribute("user"));
            model.addAttribute("isTrainer", session.getAttribute("user") instanceof Entrenador);

        } else {
            model.addAttribute("Rutinas", rutinas);
        }

        return "SecRutinas";
    }

    @RequestMapping("/secRutinas/filter")
    public String getRutinesByCategoria(Model model, HttpSession session, @RequestParam long categoriaId) {
        Categoria categoria = categoriaRepository.findOne(categoriaId);
        List<Rutina> rutinas = categoria.getRutinas();
        model.addAttribute("Rutinas", rutinas);
        model.addAttribute("logged", session.getAttribute("user"));
        return "SecRutinas";
    }

}
