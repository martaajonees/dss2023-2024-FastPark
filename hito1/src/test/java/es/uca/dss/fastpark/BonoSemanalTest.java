package es.uca.dss.fastpark;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class BonoSemanalTest {
    private BonoSemanal bono;

    @BeforeEach
    void setUp() {
        bono = new BonoSemanal();
    }

    @Test
    void calcularCaducidad() {
        // se debe iniciar com 0
        assertEquals(0, bono.getPrecioBono());
        // fecha
        LocalDateTime inicio = bono.getFechaInicio();
        LocalDateTime fechaCaducidadEsperada = inicio.plusDays(7);
        LocalDateTime fechacaducidad = bono.calcularCaducidad();
        assertEquals(fechacaducidad, fechaCaducidadEsperada);
    }
}