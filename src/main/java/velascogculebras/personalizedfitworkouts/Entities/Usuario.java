package velascogculebras.personalizedfitworkouts.Entities;
import javax.persistence.*;
import java.util.List;

@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private boolean userOrTrainer;
    @OneToMany
    private List<Rutina> rutinas;

    public Usuario() {
    }

    public Usuario(List<Rutina> rutina) {
        this.rutinas = rutina;
    }

    public long getId() {
        return id;
    }

    public List<Rutina> getRutina() {
        return rutinas;
    }
}


