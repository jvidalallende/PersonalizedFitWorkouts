package velascogculebras.personalizedfitworkouts.Entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(unique = true)
    private String mail;
    private String name;

    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> roles;
    private String passwordHash;
    private String profileIcon;
    @OneToMany
    private List<Rutina> rutinasFav;
    @OneToMany(mappedBy = "user")
    private List<Comentario> comentarios;

    public Usuario() {
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Rutina> getRutinasFav() {
        return rutinasFav;
    }

    public void setRutinasFav(List<Rutina> rutinasFav) {
        this.rutinasFav = rutinasFav;
    }

    public long getId() {
        return id;
    }


    public List<String> getRoles() {
        return roles;
    }
}


