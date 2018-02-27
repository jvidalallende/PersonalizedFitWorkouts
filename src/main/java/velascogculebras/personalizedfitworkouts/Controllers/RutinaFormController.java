package velascogculebras.personalizedfitworkouts.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import velascogculebras.personalizedfitworkouts.Entities.Ejercicio;
import velascogculebras.personalizedfitworkouts.Entities.Rutina;
import velascogculebras.personalizedfitworkouts.Repositories.RutinaRepository;

import java.util.ArrayList;
import java.util.List;

@Controller
public class RutinaFormController {
    @Autowired
    private RutinaRepository rutinaRepository;

    @GetMapping("/rutinaForm")
    public String getForm(Model model,@RequestParam String name,@RequestParam String e1, @RequestParam int s1,@RequestParam String r1,
                                      @RequestParam String e2, @RequestParam int s2,@RequestParam String r2,
                                      @RequestParam String e3, @RequestParam int s3,@RequestParam String r3,
                                      @RequestParam String e4, @RequestParam int s4,@RequestParam String r4,
                                      @RequestParam String e5, @RequestParam int s5,@RequestParam String r5){
        List<Ejercicio> ejercicios = new ArrayList<>();
        if(e1 != null){
            Ejercicio ej1 = new Ejercicio(e1,s1,r1);
            ejercicios.add(ej1);
        }
        if(e2 != null){
            Ejercicio ej2 = new Ejercicio(e2,s2,r2);
            ejercicios.add(ej2);
        }
        if(e3 != null){
            Ejercicio ej3 = new Ejercicio(e3,s3,r3);
            ejercicios.add(ej3);
        }
        if(e4 != null){
            Ejercicio ej4 = new Ejercicio(e4,s4,r4);
            ejercicios.add(ej4);
        }
        if(e5 != null){
            Ejercicio ej5 = new Ejercicio(e5,s5,r5);
            ejercicios.add(ej5);
        }


        Rutina rutina = new Rutina(ejercicios);
        rutina.setNombre(name);
        rutinaRepository.save(rutina);

        return "redirect:/";


    }
}
