package domain.entities;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;
@Setter
@Getter

public class Alumno {
    private String nombre;
    private String apellido;
    private Set<Materia> materiasAprobadas;

    public Alumno(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.materiasAprobadas = new HashSet<>();
    }

    void agregarMateriasAprobadas(Materia materia) {
        materiasAprobadas.add(materia);
    }

    Set<Materia> getMateriasAprobadas() {
        return materiasAprobadas;
    }
}
