package es.uca.dss.fastpark;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BarreraTest {
    private Barrera barrera;

    @BeforeEach
    void setUp() {
        barrera = new Barrera();
    }

    @Test
    void abrir() {
        assertFalse(barrera.abierta()); // Cuando se crea está cerrada
        barrera.abrir(); // Abrimos
        assertTrue(barrera.abierta()); // Ahora sí está abierta
        barrera.cerrar(); // cerramos
    }

    @Test
    void cerrar() {
        assertFalse(barrera.abierta());
        barrera.abrir();
        assertTrue(barrera.abierta());
        barrera.cerrar();
        assertFalse(barrera.abierta());
    }
}