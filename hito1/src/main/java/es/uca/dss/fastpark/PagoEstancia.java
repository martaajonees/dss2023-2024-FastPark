package es.uca.dss.fastpark;

import com.google.zxing.NotFoundException;

import java.io.IOException;

public class PagoEstancia {
    private final Tarificacion tarifa;

    public PagoEstancia (Tarificacion t) {
        this.tarifa = t;
    }
    public void pagar(Vehiculo vehiculo) throws IOException, NotFoundException {
        long precio = obtenerPrecio(vehiculo.calcularTiempoEstacionado());
        System.out.println("El vehículo con matrícula " + vehiculo.matricula() + " debe pagar " + precio + " euros.");
        // Pagar dinero
        vehiculo.setPago(true);
    }

    long obtenerPrecio(long minutos){
        return minutos * tarifa.getPrecioMinuto();
    }
}
