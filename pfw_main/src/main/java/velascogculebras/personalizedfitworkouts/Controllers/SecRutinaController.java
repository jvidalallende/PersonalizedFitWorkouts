package velascogculebras.personalizedfitworkouts.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import velascogculebras.personalizedfitworkouts.Entities.*;
import velascogculebras.personalizedfitworkouts.Repositories.ComentarioRepository;
import velascogculebras.personalizedfitworkouts.Repositories.RutinaRepository;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class SecRutinaController {
    @Autowired
    private RutinaRepository rutinaRepository;
    @Autowired
    private ComentarioRepository comentarioRepository;


    @RequestMapping("/secRutina")
    @Cacheable("rutina")
    public String getComentarios(Model model, HttpSession session, @RequestParam long rutinaId) {
        Rutina rutina = rutinaRepository.findOne(rutinaId);
        List<Comentario> comentarios = comentarioRepository.findByRutinaOrderByDateAsc(rutina);
        Usuario usuario = (Usuario) session.getAttribute("user");
        if (usuario != null) {
            RutinaFav rutinaFav = new RutinaFav(rutina, usuario.getRutinasFav().contains(rutina));
            model.addAttribute("rutina", rutinaFav);
            model.addAttribute("logged", session.getAttribute("user"));
            model.addAttribute("isTrainer", session.getAttribute("user") instanceof Entrenador);
        } else {
            model.addAttribute("rutina", rutina);
        }
        model.addAttribute("rutina", rutina);
        model.addAttribute("comentarios", comentarios);
        return "secRutina";

    }

    @PostMapping("/comentar")
    @CacheEvict("rutina")
    public String comentar(Model model, HttpSession session, @RequestParam long rutinaId, @RequestParam String comentario) {
        Comentario comentarioObj = new Comentario();
        Rutina rutina = rutinaRepository.findOne(rutinaId);
        comentarioObj.setRutina(rutina);
        Usuario usuario = (Usuario) session.getAttribute("user");
        comentarioObj.setUser(usuario);
        comentarioObj.setComentario(comentario);
        comentarioObj.setDate(new Date());
        comentarioRepository.save(comentarioObj);
        return "redirect:/secRutina?rutinaId=" + rutina.getRutinaId();
    }
}