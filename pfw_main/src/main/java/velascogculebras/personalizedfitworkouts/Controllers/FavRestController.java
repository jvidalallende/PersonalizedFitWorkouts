package velascogculebras.personalizedfitworkouts.Controllers;

import org.hibernate.annotations.Cache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import velascogculebras.personalizedfitworkouts.Entities.Rutina;
import velascogculebras.personalizedfitworkouts.Entities.Usuario;
import velascogculebras.personalizedfitworkouts.Repositories.RutinaRepository;
import velascogculebras.personalizedfitworkouts.Repositories.UsuarioReporsitory;

import javax.servlet.http.HttpSession;

@RestController
public class FavRestController {
    @Autowired
    public RutinaRepository rutinaRepository;
    @Autowired
    public UsuarioReporsitory usuarioReporsitory;

    @GetMapping("/addFav2")
    @CacheEvict("favorites")
    public Boolean addtofav2(@RequestParam long rutinaId, HttpSession session) {
        Usuario usuario = (Usuario) session.getAttribute("user");
        Rutina rutina = rutinaRepository.findOne(rutinaId);
        if (usuario.getRutinasFav().contains(rutina)) {
            usuario.getRutinasFav().remove(rutina);
        } else {
            usuario.getRutinasFav().add(rutina);
        }
        usuarioReporsitory.save(usuario);
        session.setAttribute("user", usuario);

        return true;

    }
}
