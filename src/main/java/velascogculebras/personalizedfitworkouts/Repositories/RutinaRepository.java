package velascogculebras.personalizedfitworkouts.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import velascogculebras.personalizedfitworkouts.Entities.Rutina;

@Repository
public interface RutinaRepository extends JpaRepository<Rutina, Long> {
}
