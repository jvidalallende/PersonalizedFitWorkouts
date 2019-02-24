package ivelascogculebras.pdfcreatormodule.Entities;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
public class Rutina {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long rutinaId;
    private String nombre;
    @OneToMany(mappedBy = "rutina")
    private List<Comentario> comentarios;

    @ManyToOne
    private Entrenador entrenador;
    private Date date;
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @Fetch(FetchMode.SUBSELECT)
    private List<Ejercicio> ejercicios;
    @ManyToMany(fetch = FetchType.EAGER)
    @Fetch(FetchMode.SUBSELECT)
    private List<Categoria> categorias;

    public Rutina(Rutina rutina) {
        this.rutinaId = rutina.rutinaId;
        this.nombre = rutina.nombre;
        this.comentarios = rutina.comentarios;
        this.entrenador = rutina.entrenador;
        this.date = rutina.date;
        this.descripcion = rutina.descripcion;
        this.ejercicios = rutina.ejercicios;
        this.categorias = rutina.categorias;
    }

    public Rutina() {
    }

    public Rutina(List<Ejercicio> ejercicios) {
        this.ejercicios = ejercicios;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rutina rutina = (Rutina) o;
        return rutinaId == rutina.rutinaId;
    }

    @Override
    public int hashCode() {

        return Objects.hash(rutinaId);
    }

    public List<Comentario> getComentarios() {
        return comentarios;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    public long getRutinaId() {
        return rutinaId;
    }

    public List<Ejercicio> getEjercicios() {
        return ejercicios;
    }

    public void setEjercicios(List<Ejercicio> ejercicios) {
        this.ejercicios = ejercicios;
    }

    public String getNombre() {
        return nombre;
    }
}
