package ivelascogculebras.pdfcreatormodule.Repository;

import ivelascogculebras.pdfcreatormodule.Entities.Usuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioReporsitory extends CrudRepository<Usuario, Long> {


    Usuario findByMail(String mail);
}
