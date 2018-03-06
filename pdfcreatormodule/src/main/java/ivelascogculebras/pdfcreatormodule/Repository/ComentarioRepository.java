package ivelascogculebras.pdfcreatormodule.Repository;

import ivelascogculebras.pdfcreatormodule.Entities.Comentario;
import ivelascogculebras.pdfcreatormodule.Entities.Rutina;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ComentarioRepository extends JpaRepository<Comentario, Long> {

    List<Comentario> findByRutinaOrderByDateAsc(Rutina rutina);
}
