package ivelascogculebras.pdfcreatormodule.Entities;


import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Entrenador extends Usuario {
    private String biografia;
    @OneToMany(mappedBy = "entrenador")
    private List<Rutina> rutinas;

    public Entrenador() {
        super();
        roles.add("ROLE_TRAINER");
    }

    public String getBiografia() {
        return biografia;
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
}


