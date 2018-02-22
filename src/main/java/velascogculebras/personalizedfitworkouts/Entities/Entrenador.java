package velascogculebras.personalizedfitworkouts.Entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Entrenador {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String biografia;
    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> roles;
    @Column(unique = true)
    private String mail;
    private String passwordHash;
    private String name;
    private String profileIcon;
    @OneToMany(mappedBy = "entrenador")
    private List<Rutina> rutinas;

    public Entrenador() {
        roles = new ArrayList<>();
        roles.add("ROLE_TRAINER");
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public void setProfileIcon(String profileIcon) {
        this.profileIcon = profileIcon;
    }

    public void setBiografia(String biografia) {
        this.biografia = biografia;
    }

    public List<Rutina> getRutinas() {
        return rutinas;
    }

    public void setRutinas(List<Rutina> rutinas) {
        this.rutinas = rutinas;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String nombre) {
        this.name = nombre;
    }


    public List<String> getRoles() {
        return roles;
    }

    public void add_role(String role) {
        if (roles == null) {
            roles = new ArrayList<>();
        }

        roles.add(role);
    }
}
