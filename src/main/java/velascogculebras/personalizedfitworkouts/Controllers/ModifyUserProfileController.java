package velascogculebras.personalizedfitworkouts.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import velascogculebras.personalizedfitworkouts.Entities.Usuario;
import velascogculebras.personalizedfitworkouts.Repositories.UsuarioReporsitory;

import javax.servlet.http.HttpSession;

@Controller
public class ModifyUserProfileController {
    @Autowired
    public UsuarioReporsitory usuarioReporsitory;

    //Falta coger la imagen y cambiarla por la antigua
    @PostMapping("/modifyUserProfile")
    @CacheEvict("profile")
    public String saveProfile(HttpSession session, @RequestParam String name,
                               @RequestParam String passwordHash,@RequestParam String email){
        Usuario usuario = (Usuario) session.getAttribute("user");
        if(usuario.getRoles().contains("ROLE_USER")){
            usuario.setName(name);
            usuario.setPasswordHash(passwordHash);
            usuario.setMail(email);
            usuarioReporsitory.save(usuario);
        }
        return "redirect:/";
    }
}
