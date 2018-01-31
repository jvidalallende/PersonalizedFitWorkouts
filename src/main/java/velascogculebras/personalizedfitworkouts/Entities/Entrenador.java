package velascogculebras.personalizedfitworkouts.Entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class Entrenador {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String biografia;
    private String mail;
    private String nombre;
    private String profileIcon;

    @OneToMany(mappedBy = "entrenador")
    private List<Rutina> rutinas;

    public Entrenador() {
    }

    public void setProfileIcon(String profileIcon) {
        this.profileIcon = profileIcon;
    }

    public void setBiografia(String biografia) {
        this.biografia = biografia;
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

    public void setRutinas(List<Rutina> rutinas) {
        this.rutinas = rutinas;
    }


}
