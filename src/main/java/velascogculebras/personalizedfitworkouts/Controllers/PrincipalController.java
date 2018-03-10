package velascogculebras.personalizedfitworkouts.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import velascogculebras.personalizedfitworkouts.Entities.*;
import velascogculebras.personalizedfitworkouts.Repositories.*;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Controller
public class PrincipalController {
    @Autowired
    private RutinaRepository rutinaRepository;
    @Autowired
    private CategoriaRepository categoriaRepository;
    @Autowired
    private EntrenadorRepository entrenadorRepository;
    @Autowired
    private UsuarioReporsitory usuarioReporsitory;
    @Autowired
    private ComentarioRepository comentarioRepository;

    @PostConstruct
    public void init() {

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        List<Ejercicio> ejercicios = new ArrayList<>(4);
        Ejercicio ejercicio = new Ejercicio("Press Militar", 4, "12-10-10-8");
        ejercicios.add(ejercicio);
        ejercicio = new Ejercicio("Sentadilla", 4, "10-10-8-6");
        ejercicios.add(ejercicio);
        Rutina rutina = new Rutina(ejercicios);
        rutina.setNombre("rutina de prueba");
        rutina.setDate(new Date());
        Categoria categoria = new Categoria();
        categoria.setNombre("CategoriaPrueba");
        List<Rutina> rutinas = new ArrayList<>();
        rutinas.add(rutina);
        categoria.setRutinas(rutinas);
        categoriaRepository.save(categoria);
        List<Categoria> categorias = new ArrayList<>();
        categorias.add(categoria);
        rutina.setCategorias(categorias);
        rutina.setDescripcion("rutina de prueba para poder desarollar el front con datos");
        rutinaRepository.save(rutina);

        Entrenador entrenador = new Entrenador();
        entrenador.setMail("lol");
        entrenador.setPasswordHash(encoder.encode("lol"));
        entrenador.setName("Entrenador");
        entrenador.setProfileIcon("/trainers/images/1.jpg");
        entrenador.setBiografia("Soy burgalés, pero afincado en Madrid desde hace muchos años. Soy periodista y amante " +
                "del deporte y de todo lo que le rodea. Siempre me ha gustado investigar al respecto y aprender nuevas ");
        entrenadorRepository.save(entrenador);


        Ejercicio ejercicio1 = new Ejercicio("Zancadas", 4, "10-10-8-6f");
        Ejercicio ejercicio2 = new Ejercicio("Peso Muerto", 5, "5-5-5-5-5f");
        List<Ejercicio> ejercicios1 = new ArrayList<>();
        ejercicios1.add(ejercicio1);
        ejercicios1.add(ejercicio2);
        Rutina rutina2 = new Rutina(ejercicios1);
        rutina2.setNombre("Test2");
        rutina2.setDescripcion("Rutina para probar el for");
        rutina2.setEntrenador(entrenador);
        rutina2.setDate(new Date());
        entrenador.setRutinas(rutinas);
        rutinaRepository.save(rutina2);

        Usuario usuario1 = new Usuario();
        usuario1.setMail("p@gmail.com");
        usuario1.setName("Jose");
        usuario1.setPasswordHash(encoder.encode("p"));
        usuarioReporsitory.save(usuario1);

        Entrenador entrenador1 = new Entrenador();
        entrenador1.setName("pepe");
        entrenador1.setPasswordHash(encoder.encode("pepe"));
        entrenador1.setMail("pepe@gmail.com");

        entrenadorRepository.save(entrenador1);

        Comentario comentario = new Comentario();
        comentario.setComentario("De Puta madre niño");
        comentario.setDate(new Date());
        comentario.setUser(usuario1);
        comentario.setRutina(rutina2);
        comentarioRepository.save(comentario);
    }

    @RequestMapping("/")
    private String getIndex(Model model, HttpSession session, HttpServletRequest request) {
        model.addAttribute("logged", session.getAttribute("user"));
        model.addAttribute("isTrainer", session.getAttribute("user") instanceof Entrenador);
        model.addAttribute("entrenador", entrenadorRepository.findAll());
        Pageable first5 = new PageRequest(0, 5, Sort.Direction.ASC, "date");
        model.addAttribute("Rutinas", rutinaRepository.findAll(first5));
        return "index";
    }


}
