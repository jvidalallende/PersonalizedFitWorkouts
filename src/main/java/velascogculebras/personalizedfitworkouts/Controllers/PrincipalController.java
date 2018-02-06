package velascogculebras.personalizedfitworkouts.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import velascogculebras.personalizedfitworkouts.Entities.*;
import velascogculebras.personalizedfitworkouts.Repositories.CategoriaRepository;
import velascogculebras.personalizedfitworkouts.Repositories.EntrenadorRepository;
import velascogculebras.personalizedfitworkouts.Repositories.RutinaRepository;
import velascogculebras.personalizedfitworkouts.Repositories.UsuarioReporsitory;

import javax.annotation.PostConstruct;
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

    @PostConstruct
    public void init() {


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
        entrenador.setNombre("Entrenador");
        entrenador.setProfileIcon("/users/images/1.jpg");
        entrenador.setBiografia("Soy burgalés, pero afincado en Madrid desde hace muchos años. Soy periodista y amante " +
                "del deporte y de todo lo que le rodea. Siempre me ha gustado investigar al respecto y aprender nuevas ");
        entrenadorRepository.save(entrenador);


        Ejercicio ejercicio1 = new Ejercicio("Zancadas", 4, "10-10-8-6f");
        Ejercicio ejercicio2 = new Ejercicio("Peso Muerto", 5, "5-5-5-5-5f");
        List<Ejercicio> ejercicios1 = new ArrayList<>();
        ejercicios1.add(ejercicio1);
        ejercicios1.add(ejercicio2);
        rutina = new Rutina(ejercicios1);
        rutina.setNombre("Test2");
        rutina.setDescripcion("Rutina para probar el for");
        rutina.setEntrenador(entrenador);
        rutina.setDate(new Date());
        entrenador.setRutinas(rutinas);
        rutinaRepository.save(rutina);

        Usuario usuario1 = new Usuario();
        usuario1.setMail("p@gmail.com");
        usuario1.setName("Jose");
        usuario1.setPassword("p");


    }

    @RequestMapping("/")
    private String getIndex(Model model) {
        model.addAttribute("entrenador", entrenadorRepository.findAll());
        return "index";
    }


}
