package velascogculebras.personalizedfitworkouts.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import velascogculebras.personalizedfitworkouts.Entities.Usuario;

@Repository
public interface UsuarioReporsitory extends CrudRepository<Usuario, Long> {


    Usuario findByMail(String mail);
}
