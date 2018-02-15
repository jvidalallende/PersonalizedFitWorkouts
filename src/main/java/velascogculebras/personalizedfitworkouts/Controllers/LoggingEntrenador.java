package velascogculebras.personalizedfitworkouts.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import velascogculebras.personalizedfitworkouts.Repositories.EntrenadorRepository;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LoggingEntrenador {
    @Autowired
    private EntrenadorRepository entrenadorRepository;

    @RequestMapping("/trainer")
    private String LoggingEntrenador(Model model, HttpServletRequest request){
        model.addAttribute("admin", request.isUserInRole("ADMIN"));
        return "Entrenador";
    }
}