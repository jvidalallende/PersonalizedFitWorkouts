package ivelascogculebras.pdfcreatormodule.Repository;

import ivelascogculebras.pdfcreatormodule.Entities.Rutina;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RutinaRepository extends JpaRepository<Rutina, Long> {
}
