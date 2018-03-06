package velascogculebras.personalizedfitworkouts.Controllers;

import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import velascogculebras.personalizedfitworkouts.Entities.Rutina;
import velascogculebras.personalizedfitworkouts.Repositories.RutinaRepository;

@Controller
public class PdfController {
    private static final String url = "localhost:8080/getPdf/";
    @Autowired
    public RutinaRepository rutinaRepository;

    @GetMapping("pdf")
    public String getPdf(@RequestParam long rutinaId) {
        Rutina rutina = rutinaRepository.getOne(rutinaId);
        RestTemplate restTemplate = new RestTemplate();

        ObjectNode data = restTemplate.getForObject(url + rutinaId, ObjectNode.class);

        Byte[] bytes = data.


    }
}
