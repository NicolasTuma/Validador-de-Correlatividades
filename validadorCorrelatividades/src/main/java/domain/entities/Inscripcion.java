package domain.entities;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter

public class Inscripcion {
    Set<Materia> materiasACursar;
    boolean fueAprobada;
    Alumno alumno;

    public Inscripcion(Alumno alumno, Set<Materia> materiasACursar) {
        this.alumno = alumno;
        this.materiasACursar = materiasACursar;
    }

    boolean aprobada() {
        return materiasACursar
                .stream()
                .allMatch(materia -> materia.cumpleCorrelativas(alumno.getMateriasAprobadas()));
    }

    void fueAprobada() {
        fueAprobada = this.aprobada();
    }
}
