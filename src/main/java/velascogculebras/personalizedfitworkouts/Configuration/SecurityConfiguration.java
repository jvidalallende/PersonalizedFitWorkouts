package velascogculebras.personalizedfitworkouts.Configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    public UserRepositoryAuthenticationProvider authenticationProvider;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/").permitAll();
        http.authorizeRequests().antMatchers("/login").permitAll();
        http.authorizeRequests().antMatchers("/loginerror").permitAll();
        http.authorizeRequests().antMatchers("/secRutinas").permitAll();
        http.authorizeRequests().antMatchers("/secEntrenadores").permitAll();
        http.authorizeRequests().antMatchers("/secRutina").permitAll();
        http.authorizeRequests().antMatchers("/secEntrenador").permitAll();
        http.authorizeRequests().antMatchers("/trainers/images/*").permitAll();
        http.authorizeRequests().antMatchers("/users/images/*").permitAll();
        http.authorizeRequests().antMatchers("/home").hasAnyRole("USER");
        http.authorizeRequests().antMatchers("/admin").hasAnyRole("ADMIN");
        http.authorizeRequests().antMatchers("/user").hasAnyRole("USER");
        http.authorizeRequests().antMatchers("/trainer").hasAnyRole("ADMIN");


        http.authorizeRequests().anyRequest().authenticated();

        // Login form
        http.formLogin().loginPage("/login");
        http.formLogin().usernameParameter("mail");
        http.formLogin().passwordParameter("password");
        http.formLogin().defaultSuccessUrl("/", true);
        http.formLogin().failureUrl("/loginerror");

        //logout
        http.logout().logoutUrl("/logout");
        http.logout().logoutSuccessUrl("/");

        // Disable CSRF at the moment
        http.csrf().disable();
    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider);

    }
}
