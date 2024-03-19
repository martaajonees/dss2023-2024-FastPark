package es.uca.dss.fastpark;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

class ParkingTest {
    private Parking parking;

    @BeforeEach
    void setUp() {
        parking = new Parking("Ejemplo", 123, 10);
    }

    @Test
    void testEntrada() {
        // Verificar que la entrada incrementa las plazas ocupadas
        parking.entrada("ABC123");
        assertEquals(1, parking.getPlazasOcupadas());
    }

    @Test
    void testSalida() {
        // Verificar que la salida disminuye las plazas ocupadas
        parking.entrada("ABC123");
        parking.salida();
        assertEquals(0, parking.getPlazasOcupadas());
    }

    @Test
    void testPagoEstandar() {
        // Verificar que se realiza el pago correctamente
        // Implementa tu lógica de prueba según tus requisitos
    }

    @Test
    void testToString() {
        // Verificar que el método toString funciona correctamente
        String expected = "El Parking Ejemplo con dirección postal 123 tiene 0 de las 10 ocupadas";
        assertEquals(expected, parking.toString());
    }
}