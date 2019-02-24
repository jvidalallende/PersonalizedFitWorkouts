package velascogculebras.personalizedfitworkouts.Controllers;

import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
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
    private static final String HOST = System.getenv().get("PDF_CREATOR_HOST");
    private static final String PORT = System.getenv().get("PDF_CREATOR_PORT");
    private static final String PDF_SERVICE_URL = "http://" + HOST + ":" + PORT + "getPdf/";

    @Autowired
    public RutinaRepository rutinaRepository;

    @GetMapping("pdf")
    @Cacheable("pdf")
    public void getPdf(@RequestParam long rutinaId, HttpServletResponse response) throws IOException {
        RestTemplate restTemplate = new RestTemplate();
        try {

            ObjectNode data = restTemplate.getForObject(PDF_SERVICE_URL + rutinaId, ObjectNode.class);

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
