package es.uca.dss.fastpark;

import static org.junit.jupiter.api.Assertions.*;

import com.google.zxing.NotFoundException;
import org.junit.jupiter.api.*;

import java.io.IOException;

class ParkingTest {
    private Parking parking;
    private Tarificacion t;

    @BeforeEach
    void setUp() throws IOException, NotFoundException {
        // Configuracion Parking
        parking = new Parking("Ejemplo", 123, 10);
        //Añadimos un coche y que entre
        String mat = "4567ABC";
        Vehiculo v = new Vehiculo(mat);
        v.setPago(true); // Hacemos como que el vehiculo ya ha pagado para que pueda salir
        parking.entrada(mat);
        // El coche debe pagar
        t = new Tarificacion(4);
        parking.setTarificacion(t);
        parking.pagarEstandar();


    }

    @Test
    void testEntrada() {
        // Verificar que la entrada incrementa las plazas ocupadas
        assertEquals(1, parking.getPlazasOcupadas());
    }

    @Test
    void testSalida() throws IOException, NotFoundException {
        // Verificar que la salida disminuye las plazas ocupadas
        parking.salida();
        assertEquals(0, parking.getPlazasOcupadas());
    }
    @Test
    void testToString() {
        // Verificar que el método toString funciona correctamente
        String expected = "El Parking Ejemplo con dirección postal 123 tiene 1 de las 10 ocupadas";
        assertEquals(expected, parking.toString());
    }
}