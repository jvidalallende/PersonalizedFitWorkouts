package velascogculebras.personalizedfitworkouts.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import velascogculebras.personalizedfitworkouts.Entities.Entrenador;
import velascogculebras.personalizedfitworkouts.Entities.Usuario;
import velascogculebras.personalizedfitworkouts.Repositories.EntrenadorRepository;
import velascogculebras.personalizedfitworkouts.Repositories.UsuarioReporsitory;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;

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
                               @RequestParam String bio, @RequestParam("fileImage") MultipartFile fileImage) throws IOException {
        Usuario usuario = (Usuario) session.getAttribute("user");
        if(usuario.getRoles().contains("ROLE_TRAINER")){
            Entrenador trainer = (Entrenador) usuario;
            trainer.setName(name);
            trainer.setPasswordHash(passwordHash);
            trainer.setMail(email);
            trainer.setBiografia(bio);
            entrenadorRepository.save(trainer);

            if (trainer.getProfileIcon() != null){
                Resource res = new ClassPathResource("static/trainers/images"+trainer.getProfileIcon());
                File file = res.getFile();
                System.out.println(file.getAbsolutePath());
                file.delete();
            }

            String originalFilename = fileImage.getOriginalFilename();
            String extension = originalFilename.substring(originalFilename.lastIndexOf('.'),originalFilename.length());
            String newFilename = usuario.getId() +extension;
            Resource res = new ClassPathResource("static/trainers/images"+newFilename);
            File file = res.getFile();
            file.createNewFile();
            fileImage.transferTo(file);
            trainer.setProfileIcon(newFilename);
            entrenadorRepository.save(trainer);


        }
        return "redirect:/";
    }
}

