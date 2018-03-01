package velascogculebras.personalizedfitworkouts.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import velascogculebras.personalizedfitworkouts.Entities.Rutina;
import velascogculebras.personalizedfitworkouts.Entities.Usuario;
import velascogculebras.personalizedfitworkouts.Repositories.RutinaRepository;

import javax.servlet.http.HttpSession;

@Controller
public class FavController {
    @Autowired
    RutinaRepository rutinaRepository;

    @RequestMapping("/addFav")
    public String addToFav(long rutinaId, HttpSession session) {
        Usuario usuario = (Usuario) session.getAttribute("user");
        Rutina rutina = rutinaRepository.findOne(rutinaId);
        if (usuario.getRutinasFav().contains(rutina)) {
            usuario.getRutinasFav().remove(rutina);
        } else {
            usuario.getRutinasFav().add(rutina);
        }

        return "redirect:/secRutinas";
    }

}
