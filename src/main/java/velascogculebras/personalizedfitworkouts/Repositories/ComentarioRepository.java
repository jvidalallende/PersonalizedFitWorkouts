package velascogculebras.personalizedfitworkouts.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import velascogculebras.personalizedfitworkouts.Entities.Comentario;
import velascogculebras.personalizedfitworkouts.Entities.Rutina;

import java.util.List;

@Repository
public interface ComentarioRepository extends JpaRepository<Comentario, Long> {

    List<Comentario> findByRutinaOrderByDateAsc(Rutina rutina);
}
