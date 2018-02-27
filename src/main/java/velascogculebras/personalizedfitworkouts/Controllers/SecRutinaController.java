package velascogculebras.personalizedfitworkouts.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import velascogculebras.personalizedfitworkouts.Entities.Comentario;
import velascogculebras.personalizedfitworkouts.Entities.Rutina;
import velascogculebras.personalizedfitworkouts.Entities.Usuario;
import velascogculebras.personalizedfitworkouts.Repositories.ComentarioRepository;
import velascogculebras.personalizedfitworkouts.Repositories.RutinaRepository;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@Controller
public class SecRutinaController {
    @Autowired
    private RutinaRepository rutinaRepository;
    @Autowired
    private ComentarioRepository comentarioRepository;


    @RequestMapping("/secRutina")
    private String getComentarios(Model model, HttpSession session, @RequestParam long rutinaId) {
        Rutina rutina = rutinaRepository.findOne(rutinaId);
        List<Comentario> comentarios = comentarioRepository.findByRutinaOrderByDateAsc(rutina);
        model.addAttribute("Rutinas", rutina);
        model.addAttribute("comentarios", comentarios);
        model.addAttribute("logged", session.getAttribute("user"));
        return "secRutina";

    }

    @PostMapping("/comentar")
    private String comentar(Model model, HttpSession session, @RequestParam long rutinaId, @RequestParam String comentario) {
        Comentario comentarioObj = new Comentario();
        Rutina rutina = rutinaRepository.findOne(rutinaId);
        comentarioObj.setRutina(rutina);
        Usuario usuario = (Usuario) session.getAttribute("user");
        comentarioObj.setUser(usuario);
        comentarioObj.setComentario(comentario);
        comentarioObj.setDate(new Date());
        comentarioRepository.save(comentarioObj);
        return "redirect:/secRutina?rutinaId=" + rutina.getId();
    }
}