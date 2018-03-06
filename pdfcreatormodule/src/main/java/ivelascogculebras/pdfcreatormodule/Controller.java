package ivelascogculebras.pdfcreatormodule;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import velascogculebras.personalizedfitworkouts.Entities.Ejercicio;
import velascogculebras.personalizedfitworkouts.Entities.Rutina;
import velascogculebras.personalizedfitworkouts.Repositories.RutinaRepository;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

@RestController
public class Controller {
    @Autowired
    public RutinaRepository rutinaRepository;

    public static void generatePdf(Rutina rutina) throws DocumentException, FileNotFoundException {
        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream("iTextHelloWorld.pdf"));

        document.open();
        Font font = FontFactory.getFont(FontFactory.COURIER, 16, BaseColor.BLACK);
        Chunk chunk = new Chunk("Hello World", font);
        PdfPTable table = new PdfPTable(rutina.getEjercicios().size());
        for (int i = 0; i < rutina.getEjercicios().size(); i++) {
            addEjercicio(table, rutina.getEjercicios().get(i), i);
        }

        document.add(chunk);
        document.close();
    }

    private static void addEjercicio(PdfPTable table, Ejercicio ejercicio, int i) {
        table.addCell(String.valueOf(i));
        table.addCell(ejercicio.getNombre());
        table.addCell(String.valueOf(ejercicio.getSeries()));
        table.addCell(ejercicio.getRepeticiones());
    }

    @GetMapping("/getPdf")
    public void getPdf(@RequestParam long rutinaId) throws FileNotFoundException, DocumentException {
        Rutina rutina = rutinaRepository.getOne(rutinaId);
        generatePdf(rutina);
    }

}
