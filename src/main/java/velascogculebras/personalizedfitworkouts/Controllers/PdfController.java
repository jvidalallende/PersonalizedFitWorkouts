package velascogculebras.personalizedfitworkouts.Controllers;

import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import velascogculebras.personalizedfitworkouts.Repositories.RutinaRepository;

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

@Controller
public class PdfController {
    private static final String url = "http://192.168.33.13:8080/getPdf/";
    @Autowired
    public RutinaRepository rutinaRepository;

    @GetMapping("pdf")
    public void getPdf(@RequestParam long rutinaId, HttpServletResponse response) throws IOException {
        RestTemplate restTemplate = new RestTemplate();
        try {

            ObjectNode data = restTemplate.getForObject(url + rutinaId, ObjectNode.class);

            byte[] bytes = data.get("file").binaryValue();
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            bos.write(bytes);
            bos.writeTo(response.getOutputStream());
            response.flushBuffer();
        } catch (Exception e) {
            response.sendRedirect("/error");
        }
    }
}
