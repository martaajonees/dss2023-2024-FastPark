package es.uca.dss.fastpark;
import com.google.zxing.NotFoundException;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
public class PagoBono {
    private QRServicio codigo;
    private VehiculoRepositorio coches;
    public PagoBono(VehiculoRepositorio c){
        this.coches = c;
    }
    void obtenerBono(Bono b) throws IOException, NotFoundException {
        String mat = codigo.leerQR();
        Vehiculo v = coches.get(mat);
        System.out.println("El vehículo de matrícula "+ v.matricula()+ " debe pagar " + b.getPrecioBono() + " por el bono seleccionado.");
        // Pagar el bono
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy: HH:mm"); // Formato para la impresion
        System.out.println("Felicidades. Ha obtenido un bono válido hasta " + b.getCaducidad().format(formato));
        v.setBono(b); // Obtener Bono
    }
}
