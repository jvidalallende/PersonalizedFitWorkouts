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



    public Usuario() {
    }



    public List<Rutina> getRutinasFav() {
        return rutinasFav;
    }

    public long getId() {
        return id;
    }


}


