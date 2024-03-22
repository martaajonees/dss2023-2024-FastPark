package es.uca.dss.fastpark;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

class VehiculoTest {

    private Vehiculo vehiculo;
    @BeforeEach
    void setUp() {
        vehiculo = new Vehiculo("2345HJH");
    }

    @Test
    void inicio() {
        vehiculo.inicio();
        assertNotNull(vehiculo.get_inicio());
    }

    @Test
    void calcularTiempoEstacionado(){
        vehiculo.inicio(); // inicio el tiempo
        assertEquals(0,vehiculo.calcularTiempoEstacionado()); // pasa 0 segundos
    }

    @Test
    void matricula() {
        String matricula = vehiculo.matricula();
        assertNotNull(matricula);
        assertEquals(7, matricula.length()); // Comprobar longitud de la matrícula
        assertTrue(matricula.matches("\\d{4}[A-Z]{3}")); // Comprobar formato de la matrícula
    }

    @Test
    void pagado() {
        assertFalse(vehiculo.pagado());
        vehiculo.setPago(true);
        assertTrue(vehiculo.pagado());
    }

    @Test
    void tieneBono() {
        assertFalse(vehiculo.tieneBono());
        Bono bono = new BonoAnual();
        vehiculo.addBono(bono);
        assertTrue(vehiculo.tieneBono());
    }

}