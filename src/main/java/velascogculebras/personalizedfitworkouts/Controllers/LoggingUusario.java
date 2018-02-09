package velascogculebras.personalizedfitworkouts.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import velascogculebras.personalizedfitworkouts.Repositories.UsuarioReporsitory;

@Controller
public class LoggingUusario {
    @Autowired
    private UsuarioReporsitory usuarioReporsitory;

    @RequestMapping("/user")
    private String LoggingUsuario(Model model){
        usuarioReporsitory.findByMailAndPassword("p@gmail.com","p");
        return "Usuario";
    }
}
