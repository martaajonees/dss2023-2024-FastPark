package es.uca.dss.fastpark;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class VehiculoTest {

    private Vehiculo vehiculo;
    @BeforeEach
    void setUp() {
        vehiculo = new Vehiculo("234577HJH");
    }

    @Test
    void inicio() {
        vehiculo.inicio();
        assertNotNull(vehiculo.get_inicio());
    }

    @Test
    void calcularTiempoEstacionado() {
        vehiculo.inicio();
        LocalDateTime inicio = vehiculo.get_inicio();
        LocalDateTime fin = inicio.plusMinutes(5);
        vehiculo.set_final(fin);
        assertEquals(5, vehiculo.calcularTiempoEstacionado());
    }

    @Test
    void matricula() {
        String matricula = vehiculo.matricula();
        assertNotNull(matricula);
        assertEquals(7, matricula.length()); // Comprobar longitud de la matrícula
        assertTrue(matricula.matches("\\d{4}[A-Z]{3}")); // Comprobar formato de la matrícula
    }

    @Test
    void setPago() {
    }

    @Test
    void pagado() {
    }

    @Test
    void tieneBono() {
    }

    @Test
    void setBono() {
    }
}