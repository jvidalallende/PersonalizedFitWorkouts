package ivelascogculebras.pdfcreatormodule;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import ivelascogculebras.pdfcreatormodule.Entities.Ejercicio;
import ivelascogculebras.pdfcreatormodule.Entities.Rutina;
import ivelascogculebras.pdfcreatormodule.Repository.RutinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityNotFoundException;
import java.io.ByteArrayOutputStream;
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
        Font font = FontFactory.getFont(FontFactory.COURIER, 16, BaseColor.BLACK);
        Phrase nameChunk = new Phrase(rutina.getNombre(), font);

        PdfPTable table = new PdfPTable(4);
        table.setHorizontalAlignment(Element.ALIGN_CENTER);
        addTableHeader(table);
        for (int i = 0; i < rutina.getEjercicios().size(); i++) {
            addEjercicio(table, rutina.getEjercicios().get(i), i);
        }

        document.add(nameChunk);
        document.add(Chunk.NEWLINE);
        document.add(table);
        document.add(new Paragraph("Descripcion:", font));
        document.add(new Paragraph(rutina.getDescripcion()));
        document.close();
        return baos;
    }

    private static void addEjercicio(PdfPTable table, Ejercicio ejercicio, int i) {

        table.addCell(generateCell(String.valueOf(i)));
        table.addCell(generateCell(ejercicio.getNombre()));
        table.addCell(generateCell(String.valueOf(ejercicio.getSeries())));
        table.addCell(generateCell(ejercicio.getRepeticiones()));
    }

    private static PdfPCell generateCell(String value) {
        PdfPCell cell = new PdfPCell();
        cell.setVerticalAlignment(Element.ALIGN_CENTER);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setPhrase(new Phrase(value));
        return cell;
    }

    private static void addTableHeader(PdfPTable table) {
        Stream.of("#", "Nombre", "Series", "Repeticiones")
                .forEach(columnTitle -> {
                    PdfPCell header = new PdfPCell();
                    header.setBackgroundColor(BaseColor.LIGHT_GRAY);
                    header.setBorderWidth(1);
                    header.setHorizontalAlignment(Element.ALIGN_CENTER);
                    header.setPhrase(new Phrase(columnTitle));
                    table.addCell(header);
                });
    }

    @GetMapping("/getPdf/{rutinaId}")
    public ResponseEntity<Map<String, Object>> getPdf(@PathVariable long rutinaId) throws DocumentException {
        try {
            Rutina rutina = rutinaRepository.getOne(rutinaId);
            HashMap<String, Object> map = new HashMap<>();
            map.put("file", generatePdf(rutina).toByteArray());
            return new ResponseEntity<>(map, HttpStatus.OK);
        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


}
