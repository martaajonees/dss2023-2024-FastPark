package es.uca.dss.fastpark;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class BonoTrimestralTest {
    private BonoTrimestral bono;
    @BeforeEach
    void setUp() {
        bono = new BonoTrimestral();
    }

    @Test
    void calcularCaducidad() {
        //se debe iniciar con 0
        assertEquals(0, bono.getPrecioBono());
        LocalDateTime inicio = bono.getFechaInicio();
        LocalDateTime fechaCaducidadEsperada = inicio.plusMonths(3);
        LocalDateTime fechaCaducidad = bono.calcularCaducidad();
        assertEquals(fechaCaducidad, fechaCaducidadEsperada);
    }
}