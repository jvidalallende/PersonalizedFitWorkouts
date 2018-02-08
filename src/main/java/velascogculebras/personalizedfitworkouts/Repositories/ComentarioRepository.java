package velascogculebras.personalizedfitworkouts.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import velascogculebras.personalizedfitworkouts.Entities.Categoria;

@Repository
public interface ComentarioRepository extends JpaRepository<Categoria,Long> {
}
