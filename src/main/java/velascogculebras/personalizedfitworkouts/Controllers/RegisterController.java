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
public class RegisterController {
    @Autowired
    private EntrenadorRepository entrenadorRepository;
    @Autowired
    private UsuarioReporsitory usuarioReporsitory;

    @RequestMapping("/register")
    private String reqister(Model model, @RequestParam String nombre, @RequestParam String password, @RequestParam String type, @RequestParam String email) {
        if (entrenadorRepository.findByMail(email) == null && usuarioReporsitory.findByMail(email) == null) {

            if (type.equals("Usuario")) {
                Usuario usuario = new Usuario();
                usuario.setMail(email);
                usuario.setName(nombre);
                usuario.setPassword(password);
                usuarioReporsitory.save(usuario);
            } else if (type.equals("Entrenador")) {
                Entrenador entrenador = new Entrenador();
                entrenador.setNombre(nombre);
                entrenador.setMail(email);
                entrenador.setPassword(password);
                entrenadorRepository.save(entrenador);
            }

            return "redirect:/";
        } else {
            model.addAttribute("error", "This email is already in use");
            return "registro";
        }


    }

    @RequestMapping("/registro")
    private String registro() {
        return "registro";
    }
}
