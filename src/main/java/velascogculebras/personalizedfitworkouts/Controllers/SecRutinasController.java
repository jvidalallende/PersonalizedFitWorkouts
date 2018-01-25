package velascogculebras.personalizedfitworkouts.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SecRutinasController {

    @RequestMapping("/SecRutinas")
    public String getRutines(Model model) {

        model.addAttribute("Rutinas", Rutinas);

    }

}
