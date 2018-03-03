package velascogculebras.personalizedfitworkouts.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import velascogculebras.personalizedfitworkouts.Entities.Rutina;
import velascogculebras.personalizedfitworkouts.Entities.RutinaFav;
import velascogculebras.personalizedfitworkouts.Entities.Usuario;
import velascogculebras.personalizedfitworkouts.Repositories.RutinaRepository;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class FavController {
    @Autowired
    RutinaRepository rutinaRepository;

    @GetMapping("/favoritos")
    public String showFav(Model model, HttpSession session) {
        Usuario usuario = (Usuario) session.getAttribute("user");
        model.addAttribute("logged", usuario);
        List<RutinaFav> rutinasFav = new ArrayList<>(usuario.getRutinasFav().size());
        for (Rutina rutina : usuario.getRutinasFav()) {
            rutinasFav.add(new RutinaFav(rutina, true));
        }
        model.addAttribute("Rutinas", rutinasFav);
        return "secRutinas";
    }


}
