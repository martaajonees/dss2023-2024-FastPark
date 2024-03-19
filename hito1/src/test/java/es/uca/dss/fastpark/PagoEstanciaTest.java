package es.uca.dss.fastpark;

import com.google.zxing.NotFoundException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class PagoEstanciaTest {
    private Tarificacion tarifas;
    private VehiculoRepositorio coches;
    private QRServicio qr;
    private PagoEstancia pago;
    @BeforeEach
    void setUp() throws IOException, NotFoundException {
        this.tarifas = new Tarificacion(4);
        this.coches = new VehiculosHash();
        this.qr = new QRServicio();
        this.pago = new PagoEstancia(tarifas, coches);
        // Creamos un vehiculo y lo añadimos
        String mat = "1234ABC";
        Vehiculo v = new Vehiculo(mat);
        v.inicio();
        coches.guardar(mat, v);
        // Genero qr
        qr.generarQR(mat);
    }

    @Test
    void pagar() throws IOException, NotFoundException{
        pago.pagar();
    }


}