package velascogculebras.personalizedfitworkouts.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import velascogculebras.personalizedfitworkouts.Entities.Categoria;
import velascogculebras.personalizedfitworkouts.Entities.Ejercicio;
import velascogculebras.personalizedfitworkouts.Entities.Entrenador;
import velascogculebras.personalizedfitworkouts.Entities.Rutina;
import velascogculebras.personalizedfitworkouts.Repositories.CategoriaRepository;
import velascogculebras.personalizedfitworkouts.Repositories.RutinaRepository;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class RutinaFormController {
    @Autowired
    private RutinaRepository rutinaRepository;
    @Autowired
    private CategoriaRepository categoriaRepository;

    @PostMapping("/rutinaForm")
    @CacheEvict(value = {"index", "rutinas"}, allEntries = true)
    public String getForm(Model model, @RequestParam String name, @RequestParam String e1, @RequestParam Integer s1, @RequestParam String r1,
                          @RequestParam String e2, @RequestParam Integer s2, @RequestParam String r2,
                          @RequestParam String e3, @RequestParam Integer s3, @RequestParam String r3,
                          @RequestParam String e4, @RequestParam Integer s4, @RequestParam String r4,
                          @RequestParam String e5, @RequestParam Integer s5, @RequestParam String r5,
                          @RequestParam String desc,@RequestParam String cat, HttpSession session){
        List<Ejercicio> ejercicios = new ArrayList<>();
        if (e1 != null && !e1.equals("")) {
            Ejercicio ej1 = new Ejercicio(e1,s1,r1);
            ejercicios.add(ej1);
        }
        if (e2 != null && !e2.equals("")) {
            Ejercicio ej2 = new Ejercicio(e2,s2,r2);
            ejercicios.add(ej2);
        }
        if (e3 != null && !e3.equals("")) {
            Ejercicio ej3 = new Ejercicio(e3,s3,r3);
            ejercicios.add(ej3);
        }
        if (e4 != null && !e4.equals("")) {
            Ejercicio ej4 = new Ejercicio(e4,s4,r4);
            ejercicios.add(ej4);
        }
        if (e5 != null && !e5.equals("")) {
            Ejercicio ej5 = new Ejercicio(e5,s5,r5);
            ejercicios.add(ej5);
        }


        Rutina rutina = new Rutina(ejercicios);
        rutina.setNombre(name);
        rutina.setDate(new Date());
        List<Categoria> categorias = new ArrayList<>();
        rutina.setEntrenador((Entrenador) session.getAttribute("user"));
        List<Rutina> rutinas = new ArrayList<>();
        if(cat != null){
            Categoria exist_cat = categoriaRepository.findByNombre(cat);
            if(exist_cat !=null){
                rutinas = exist_cat.getRutinas();
                rutinas.add(rutina);
                exist_cat.setRutinas(rutinas);
                categoriaRepository.save(exist_cat);
            }else{
                Categoria new_cat = new Categoria();
                new_cat.setNombre(cat);
                rutinas.add(rutina);
                new_cat.setRutinas(rutinas);
                categoriaRepository.save(new_cat);
            }
        }
        if(desc != null){
            rutina.setDescripcion(desc);
        }
        rutinaRepository.save(rutina);

        return "redirect:/";


    }
}
