package velascogculebras.personalizedfitworkouts.Controllers;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import velascogculebras.personalizedfitworkouts.Entities.Categoria;
import velascogculebras.personalizedfitworkouts.Entities.Rutina;
import velascogculebras.personalizedfitworkouts.Entities.RutinaFav;
import velascogculebras.personalizedfitworkouts.Entities.Usuario;
import velascogculebras.personalizedfitworkouts.Repositories.CategoriaRepository;
import velascogculebras.personalizedfitworkouts.Repositories.RutinaRepository;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
