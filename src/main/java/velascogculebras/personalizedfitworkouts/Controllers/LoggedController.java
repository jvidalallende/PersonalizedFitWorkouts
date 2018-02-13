package velascogculebras.personalizedfitworkouts.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import velascogculebras.personalizedfitworkouts.Entities.Entrenador;
import velascogculebras.personalizedfitworkouts.Entities.Usuario;
import velascogculebras.personalizedfitworkouts.Repositories.EntrenadorRepository;
import velascogculebras.personalizedfitworkouts.Repositories.UsuarioReporsitory;

@Controller
public class LoggedController {
    @Autowired
    private UsuarioReporsitory usuarioReporsitory;
    @Autowired
    private EntrenadorRepository entrenadorRepository;

    @RequestMapping("/Logged")
    private String logged(Model model, @RequestParam String mail, @RequestParam String password){
        Usuario u = usuarioReporsitory.findByMailAndPassword(mail,password);
        Entrenador e = entrenadorRepository.findByMailAndPassword(mail,password);
        model.addAttribute("Usuario",u);
        model.addAttribute("Entrenador",e);
        if(u!= null){
            return "redirect:/user";
        } else if (e!= null) {
            return "redirect:/trainer";
        } else {
            model.addAttribute("error", "Email or password incorrect");
            return "login";
        }
    }

    @RequestMapping("/login")
    private String login() {
        return "login";
    }
}
