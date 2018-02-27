package velascogculebras.personalizedfitworkouts.Entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected long id;
    @Column(unique = true)
    protected String mail;
    protected String name;

    @ElementCollection(fetch = FetchType.EAGER)
    protected List<String> roles;
    protected String passwordHash;
    protected String profileIcon;
    @OneToMany
    protected List<Rutina> rutinasFav;
    @OneToMany(mappedBy = "user")
    protected List<Comentario> comentarios;

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    public String getProfileIcon() {
        return profileIcon;
    }

    public void setProfileIcon(String profileIcon) {
        this.profileIcon = profileIcon;
    }

    public List<Comentario> getComentarios() {
        return comentarios;
    }

    public void setComentarios(List<Comentario> comentarios) {
        this.comentarios = comentarios;
    }

    public Usuario() {
        roles = new ArrayList<>();
        roles.add("ROLE_USER");
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

    public void add_role(String role) {
        if (roles == null) {
            roles = new ArrayList<>();
        }

        roles.add(role);
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


