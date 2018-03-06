package ivelascogculebras.pdfcreatormodule;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import ivelascogculebras.pdfcreatormodule.Entities.Ejercicio;
import ivelascogculebras.pdfcreatormodule.Entities.Rutina;
import ivelascogculebras.pdfcreatormodule.Repository.RutinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

@RestController
public class Controller {
    @Autowired
    public RutinaRepository rutinaRepository;

    private static ByteArrayOutputStream generatePdf(Rutina rutina) throws DocumentException {
        Document document = new Document();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PdfWriter.getInstance(document, baos);
        document.open();
        PdfPTable table = new PdfPTable(4);
        addTableHeader(table);
        for (int i = 0; i < rutina.getEjercicios().size(); i++) {
            addEjercicio(table, rutina.getEjercicios().get(i), i);
        }
        document.add(table);
        document.close();
        return baos;
    }

    private static void addEjercicio(PdfPTable table, Ejercicio ejercicio, int i) {
        table.addCell(String.valueOf(i));
        table.addCell(ejercicio.getNombre());
        table.addCell(String.valueOf(ejercicio.getSeries()));
        table.addCell(ejercicio.getRepeticiones());
    }

    private static void addTableHeader(PdfPTable table) {
        Stream.of("#", "Nombre", "Series", "Repeticiones")
                .forEach(columnTitle -> {
                    PdfPCell header = new PdfPCell();
                    header.setBackgroundColor(BaseColor.LIGHT_GRAY);
                    header.setBorderWidth(1);
                    header.setPhrase(new Phrase(columnTitle));
                    table.addCell(header);
                });
    }

    @GetMapping("/getPdf/{rutinaId}")
    public Map<String, Object> getPdf(@PathVariable long rutinaId) throws FileNotFoundException, DocumentException {
        Rutina rutina = rutinaRepository.getOne(rutinaId);
        HashMap<String, Object> map = new HashMap<>();
        map.put("file", generatePdf(rutina).toByteArray());
        return map;
    }


}
