package velascogculebras.personalizedfitworkouts.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import velascogculebras.personalizedfitworkouts.Entities.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria,Long> {
}
