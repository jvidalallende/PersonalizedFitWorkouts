package velascogculebras.personalizedfitworkouts.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import velascogculebras.personalizedfitworkouts.Repositories.UsuarioReporsitory;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LoggingUusario {
    @Autowired
    private UsuarioReporsitory usuarioReporsitory;

    @RequestMapping("/user")
    private String LoggingUsuario(Model model, HttpServletRequest request){
        model.addAttribute("user", request.isUserInRole("USER"));
        model.addAttribute("user",usuarioReporsitory.findByMailAndPassword("p@gmail.com","p"));
        return "Usuario";
    }
}
