package ivelascogculebras.pdfcreatormodule.Repository;

import ivelascogculebras.pdfcreatormodule.Entities.Entrenador;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntrenadorRepository extends CrudRepository<Entrenador, Long> {

    Entrenador findByMail(String mail);
}
