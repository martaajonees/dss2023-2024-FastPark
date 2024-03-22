package es.uca.dss.fastpark;

import com.google.zxing.NotFoundException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class PagoBonoTest {
    private PagoBono pago_bono;
    private VehiculoRepositorio coches;
    private QRServicio qr;

    @BeforeEach
    void setUp() {
        this.coches = new VehiculosHash();
        this.pago_bono = new PagoBono();
        // Creamos un vehiculo y lo guardamos
        String mat = "1234ABC";
        Vehiculo v = new Vehiculo(mat);
        coches.guardar(mat, v);
        this.qr = new QRServicio();
    }

    @Test
    void obtenerBono() throws IOException, NotFoundException {
        qr.generarQR("1234ABC");
        Bono bono = new BonoTrimestral();
        bono.setPrecioBono(5);
        String matricula = qr.leerQR(); // Leemos el codigo QR
        Vehiculo v = coches.get(matricula); // Dada la matrícula cojo el vehiculo
        pago_bono.obtenerBono(bono, v);
    }
}