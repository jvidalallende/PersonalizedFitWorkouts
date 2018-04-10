package velascogculebras.personalizedfitworkouts.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Ejercicio implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String nombre;
    private int series;
    private String repeticiones;

    public Ejercicio(String nombre, int series, String repeticions) {
        this.nombre = nombre;
        this.series = series;
        this.repeticiones = repeticions;
    }

    public Ejercicio() {

    }

    public long getId() {

        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public int getSeries() {
        return series;
    }

    public String getRepeticiones() {
        return repeticiones;
    }
}
