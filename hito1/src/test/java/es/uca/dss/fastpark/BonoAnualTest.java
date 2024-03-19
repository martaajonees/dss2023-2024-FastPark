package es.uca.dss.fastpark;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class BonoAnualTest {
    private BonoAnual bono;

    @BeforeEach
    void setUp() {
        bono = new BonoAnual();
        // se debe iniciar com 0
        assertEquals(0, bono.getPrecioBono());
    }

    @Test
    void calcularCaducidad() {
        LocalDateTime inicio = bono.getFechaInicio();
        LocalDateTime fechaCaducidadEsperada = inicio.plusYears(1);
        LocalDateTime fechacaducidad = bono.calcularCaducidad();
        assertEquals(fechacaducidad, fechaCaducidadEsperada);
    }
}