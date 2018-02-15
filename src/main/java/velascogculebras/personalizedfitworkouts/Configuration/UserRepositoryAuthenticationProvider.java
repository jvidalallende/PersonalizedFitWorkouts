package velascogculebras.personalizedfitworkouts.Configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import velascogculebras.personalizedfitworkouts.Entities.Entrenador;
import velascogculebras.personalizedfitworkouts.Entities.Usuario;
import velascogculebras.personalizedfitworkouts.Repositories.EntrenadorRepository;
import velascogculebras.personalizedfitworkouts.Repositories.UsuarioReporsitory;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserRepositoryAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    public UsuarioReporsitory usuarioReporsitory;
    @Autowired
    public EntrenadorRepository entrenadorRepository;


    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        Usuario usuario = usuarioReporsitory.findByMail(authentication.getName());
        if (usuario == null) {
            Entrenador entrenador = entrenadorRepository.findByMail(authentication.getName());
            if (entrenador == null) {
                throw new BadCredentialsException("User not found");
            }

            String password = (String) authentication.getCredentials();
            if (!new BCryptPasswordEncoder().matches(password, entrenador.getPasswordHash())) {
                throw new BadCredentialsException("Password incorrect");
            }

            for (String role : entrenador.getRoles()) {
                roles.add(new SimpleGrantedAuthority(role));
            }
            return new UsernamePasswordAuthenticationToken(entrenador.getMail(), password, roles);


        } else {
            String password = (String) authentication.getCredentials();
            if (!new BCryptPasswordEncoder().matches(password, usuario.getPasswordHash())) {
                throw new BadCredentialsException("Password incorrect");
            }
            List<GrantedAuthority> roles = new ArrayList<>();
            for (String role : usuario.getRoles()) {
                roles.add(new SimpleGrantedAuthority(role));
            }
            return new UsernamePasswordAuthenticationToken(usuario.getMail(), password, roles);
        }

    }

    @Override
    public boolean supports(Class<?> aClass) {
        return false;
    }
}
