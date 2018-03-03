package velascogculebras.personalizedfitworkouts.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import velascogculebras.personalizedfitworkouts.Entities.Entrenador;
import velascogculebras.personalizedfitworkouts.Entities.Usuario;
import velascogculebras.personalizedfitworkouts.Repositories.EntrenadorRepository;
import velascogculebras.personalizedfitworkouts.Repositories.UsuarioReporsitory;

import javax.servlet.http.HttpSession;

@Controller
public class ModifyTrainerProfileController {
    @Autowired
    public EntrenadorRepository entrenadorRepository;
    @Autowired
    public UsuarioReporsitory usuarioReporsitory;

    //Falta coger la imagen y cambiarla por la antigua
    @PostMapping("/modifyTrainerProfile")
    private String saveProfile(HttpSession session, @RequestParam String name,
                               @RequestParam String passwordHash, @RequestParam String email,
                               @RequestParam String bio){
        Usuario usuario = (Usuario) session.getAttribute("user");
        if(usuario.getRoles().contains("ROLE_TRAINER")){
            Entrenador trainer = (Entrenador) usuario;
            trainer.setName(name);
            trainer.setPasswordHash(passwordHash);
            trainer.setMail(email);
            trainer.setBiografia(bio);
            entrenadorRepository.save(trainer);
        }
        return "redirect:/";
    }
}

