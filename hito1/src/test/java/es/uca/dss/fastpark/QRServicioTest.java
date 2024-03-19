package es.uca.dss.fastpark;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import com.google.zxing.NotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class QRServicioTest {
    private QRServicio qrServicio;
    @BeforeEach
    void setUp() {
        qrServicio = new QRServicio();
    }

    @Test
    void obtenerRuta() {
        String ruta = qrServicio.ObtenerRuta();
        assertNotNull(ruta);
    }

    @Test
    void generarQR() {
        String mensaje = "Hola, mundo!";
        try {
            qrServicio.generarQR(mensaje);
            // Verificar si se ha generado el archivo QR
            String rutaQR = qrServicio.ObtenerRuta() + java.io.File.separator + "QR.png";
            java.io.File archivoQR = new java.io.File(rutaQR);
            assertTrue(archivoQR.exists(), "El archivo QR no se ha generado correctamente");
        } catch (IOException e) {
            fail("Error al generar el código QR: " + e.getMessage());
        }
    }

    @Test
    void leerQR() {
        String mensaje = "Hola, mundo!";
        try {
            qrServicio.generarQR(mensaje);
            String textoLeido = qrServicio.leerQR();
            assertEquals(mensaje, textoLeido, "El texto leído del código QR no coincide con el mensaje original");
        } catch (IOException | NotFoundException e) {
            fail("Error al generar o leer el código QR: " + e.getMessage());
        }
    }
}