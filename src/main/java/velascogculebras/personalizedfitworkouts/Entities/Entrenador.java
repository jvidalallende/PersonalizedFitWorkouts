package velascogculebras.personalizedfitworkouts.Entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class Entrenador {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String biografia;

    public String getMail() {
        return mail;
    }

    @Column(unique = true)
    private String mail;

    public String getPasswordHash() {
        return passwordHash;
    }

    private String passwordHash;
    private String nombre;
    private String profileIcon;
    @OneToMany(mappedBy = "entrenador")
    private List<Rutina> rutinas;

    public Entrenador() {
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

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


}
