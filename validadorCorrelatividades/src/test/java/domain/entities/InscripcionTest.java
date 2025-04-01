package domain.entities;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class InscripcionTest {
    @Test
    @DisplayName("Se acepta la iscripcion a un curso.")
    public void testInscripcionAprobada() {

        Materia algoritmos = new Materia("Algoritmo");
        Materia sYO = new Materia("SYO");
        Materia paradigmas = new Materia("Paradigmas");
        Materia analisisSistemas = new Materia("Analisis de Sistemas");
        Materia disenio = new Materia("Disenio");

        paradigmas.agregarCorrelativas(algoritmos);
        paradigmas.agregarCorrelativas(sYO);
        analisisSistemas.agregarCorrelativas(sYO);
        disenio.agregarCorrelativas(analisisSistemas);
        disenio.agregarCorrelativas(paradigmas);

        Alumno alumno = new Alumno("Nicolas","Tuma");
        alumno.agregarMateriasAprobadas(algoritmos);
        alumno.agregarMateriasAprobadas(sYO);
        alumno.agregarMateriasAprobadas(analisisSistemas);
        alumno.agregarMateriasAprobadas(paradigmas);

        Inscripcion inscripcion = new Inscripcion(alumno,Set.of(disenio));

        assertTrue(inscripcion.aprobada());
    }

    @Test
    @DisplayName("Se rechaza la iscripcion a un curso.")
    public void testInscripcionRechazada() {

        Materia algoritmos = new Materia("Algoritmo");
        Materia sYO = new Materia("SYO");
        Materia paradigmas = new Materia("Paradigmas");
        Materia analisisSistemas = new Materia("Analisis de Sistemas");
        Materia disenio = new Materia("Disenio");

        paradigmas.agregarCorrelativas(algoritmos);
        paradigmas.agregarCorrelativas(sYO);
        analisisSistemas.agregarCorrelativas(sYO);
        disenio.agregarCorrelativas(analisisSistemas);
        disenio.agregarCorrelativas(paradigmas);

        Alumno alumno = new Alumno("Nicolas","Tuma");
        alumno.agregarMateriasAprobadas(algoritmos);
        alumno.agregarMateriasAprobadas(paradigmas);
        alumno.agregarMateriasAprobadas(sYO);

        Inscripcion inscripcion = new Inscripcion(alumno,Set.of(disenio));

        assertFalse(inscripcion.aprobada());
    }

    @Test
    @DisplayName("Se acepta la iscripcion a una materia sin correlativas.")
    public void testInscripcionAMateriaSinCorrelativas() {

        Materia algoritmos = new Materia("Algoritmo");

        Alumno alumno = new Alumno("Nicolas","Tuma");

        Inscripcion inscripcion = new Inscripcion(alumno,Set.of(algoritmos));

        assertTrue(inscripcion.aprobada());
    }
}