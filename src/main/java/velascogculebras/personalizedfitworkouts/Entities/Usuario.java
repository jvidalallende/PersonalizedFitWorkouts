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
    private String passwordHash;
    private String profileIcon;
    @OneToMany
    private List<Rutina> rutinasFav;
    @OneToMany(mappedBy = "user")
    private List<Comentario> comentarios;



    public Usuario() {
    }

    public void setMail(String mail) {this.mail = mail; }

    public void setName(String name) {this.name = name; }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public void setRutinasFav(List<Rutina> rutinasFav) {this.rutinasFav = rutinasFav;}

    public List<Rutina> getRutinasFav() {return rutinasFav;}

    public long getId() {return id;}


}


