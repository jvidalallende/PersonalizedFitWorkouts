package velascogculebras.personalizedfitworkouts.Entities;
import javax.persistence.*;
import java.util.List;

@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String mail;
    private String name;
    private String password;
    @OneToMany
    private List<Rutina> rutinasFav;
    @OneToMany(mappedBy = "user")
    private List<Comentario> comentarios;



    public Usuario() {
    }

    public void setMail(String mail) {this.mail = mail; }

    public void setName(String name) {this.name = name; }

    public void setPassword(String password) {this.password = password;}

    public void setRutinasFav(List<Rutina> rutinasFav) {this.rutinasFav = rutinasFav;}

    public List<Rutina> getRutinasFav() {return rutinasFav;}

    public long getId() {return id;}


}


