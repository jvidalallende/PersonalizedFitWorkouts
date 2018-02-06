package velascogculebras.personalizedfitworkouts.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import velascogculebras.personalizedfitworkouts.Entities.Usuario;

@Repository
public interface UsuarioReporsitory extends JpaRepository<Usuario,Long> {

    Usuario findByMailAndPassword(String mail, String password);
}
