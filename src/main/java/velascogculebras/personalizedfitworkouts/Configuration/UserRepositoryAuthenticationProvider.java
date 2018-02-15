package velascogculebras.personalizedfitworkouts.Configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import velascogculebras.personalizedfitworkouts.Entities.Usuario;
import velascogculebras.personalizedfitworkouts.Repositories.EntrenadorRepository;
import velascogculebras.personalizedfitworkouts.Repositories.UsuarioReporsitory;

public class UserRepositoryAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    public UsuarioReporsitory usuarioReporsitory;
    @Autowired
    public EntrenadorRepository entrenadorRepository;


    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        Usuario usuario = usuarioReporsitory.findByMail(authentication.getName())

    }

    @Override
    public boolean supports(Class<?> aClass) {
        return false;
    }
}
