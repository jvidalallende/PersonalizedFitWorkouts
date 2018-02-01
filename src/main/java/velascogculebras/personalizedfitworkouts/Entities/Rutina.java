package velascogculebras.personalizedfitworkouts.Entities;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Rutina {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String nombre;
    @ManyToOne
    private Entrenador entrenador;

    private Date date;

    public void setDate(Date date) {
        this.date = date;
    }

    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Ejercicio> ejercicios;
    @ManyToMany
    private List<Categoria> categorias;

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEjercicios(List<Ejercicio> ejercicios) {
        this.ejercicios = ejercicios;
    }

    public void setEntrenador(Entrenador entrenador) {
        this.entrenador = entrenador;
    }

    public void setCategorias(List<Categoria> categorias) {
        this.categorias = categorias;
    }

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
