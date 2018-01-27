package velascogculebras.personalizedfitworkouts.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import velascogculebras.personalizedfitworkouts.Entities.Categoria;
import velascogculebras.personalizedfitworkouts.Entities.Ejercicio;
import velascogculebras.personalizedfitworkouts.Entities.Rutina;
import velascogculebras.personalizedfitworkouts.Repositories.CategoriaRepository;
import velascogculebras.personalizedfitworkouts.Repositories.RutinaRepository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;


@Controller
public class PrincipalController {
    @Autowired
    private RutinaRepository rutinaRepository;
    @Autowired
    private CategoriaRepository categoriaRepository;

    @PostConstruct
    public void init() {

        List<Ejercicio> ejercicios = new ArrayList<>(4);
        Ejercicio ejercicio = new Ejercicio("Press Militar", 4, "12-10-10-8");
        ejercicios.add(ejercicio);
        ejercicio = new Ejercicio("Sentadilla", 4, "10-10-8-6");
        ejercicios.add(ejercicio);
        Rutina rutina = new Rutina(ejercicios);
        rutina.setNombre("rutina de prueba");
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
    }
}
