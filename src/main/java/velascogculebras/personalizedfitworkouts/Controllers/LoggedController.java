package velascogculebras.personalizedfitworkouts.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
        if((usuarioReporsitory.findByMailAndPassword(mail,password)!= null) || (entrenadorRepository.findByMailAndPassword(mail,password)!= null))
            return "index.html";
        return "login.html";
    }
}
