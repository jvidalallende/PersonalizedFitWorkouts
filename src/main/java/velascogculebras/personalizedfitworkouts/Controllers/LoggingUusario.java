package velascogculebras.personalizedfitworkouts.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import velascogculebras.personalizedfitworkouts.Repositories.UsuarioReporsitory;

@Controller
public class LoggingUusario {
    @Autowired
    private UsuarioReporsitory usuarioReporsitory;

    @RequestMapping("/user")
    private String LoggingUsuario(Model model, @RequestParam String nombreU,@RequestParam String passwordU,@RequestParam String emailU){
        model.addAttribute("name",nombreU);
        model.addAttribute("mail",emailU);
        model.addAttribute("password",passwordU);
        usuarioReporsitory.findByMailAndPassword("p@gmail.com","p");
        return "Usuario";
    }
}
