package ivelascogculebras.pdfcreatormodule.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Ejercicio {
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
