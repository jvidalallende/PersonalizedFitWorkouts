package velascogculebras.personalizedfitworkouts.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import velascogculebras.personalizedfitworkouts.Entities.Entrenador;

@Repository
public interface EntrenadorRepository extends CrudRepository<Entrenador, Long> {

    Entrenador findByMail(String mail);
}
