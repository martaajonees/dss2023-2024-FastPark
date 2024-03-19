package es.uca.dss.fastpark;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TarificacionTest {
    private  Tarificacion tarifa;
    @BeforeEach
    void setUp() {
        tarifa = new Tarificacion(10);
    }

    @Test
    void setPrecioMinuto() {
        tarifa.setPrecioMinuto(15);
        assertEquals(15, tarifa.getPrecioMinuto(), "El precio por minuto debería ser 15");
    }

    @Test
    void getPrecioMinuto() {
        assertEquals(10, tarifa.getPrecioMinuto(), "El precio por minuto debería ser 10");
    }

    @Test
    void testToString() {
        assertEquals("La tarifa para este parking es de 10 euros el minuto", tarifa.toString(),
                "La representación en cadena debería ser correcta");
    }
}