package es.uca.dss.fastpark;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class BonoMensualTest {
    private BonoMensual bono;
    @BeforeEach
    void setUp() {
        bono = new BonoMensual();
    }

    @Test
    void calcularCaducidad() {
        // se debe iniciar con 0
        assertEquals(0, bono.getPrecioBono());
        LocalDateTime inicio = bono.getFechaInicio();
        LocalDateTime fechaCaducidadEsperada = inicio.plusMonths(1);
        LocalDateTime fechacaducidad = bono.calcularCaducidad();
        assertEquals(fechacaducidad, fechaCaducidadEsperada);

    }
}