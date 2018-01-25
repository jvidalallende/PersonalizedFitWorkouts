package velascogculebras.personalizedfitworkouts.Entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class Rutina {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Ejercicio> ejercicios;

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Rutina() {
    }

    public Rutina(List<Ejercicio> ejercicios) {
        this.ejercicios = ejercicios;
    }

    public long getId() {
        return id;
    }

    public List<Ejercicio> getEjercicios() {
        return ejercicios;
    }
}
