package es.uca.dss.fastpark;
import com.google.zxing.NotFoundException;
import java.io.IOException;
import java.time.format.DateTimeFormatter;

public class PagoBono {
    //Objetos
    public PagoBono(){}
    void obtenerBono(Bono b, Vehiculo v) throws IOException, NotFoundException {
        System.out.println("El vehículo de matrícula "+ v.matricula()+ " debe pagar " + b.getPrecioBono() + " por el bono seleccionado.");
        // Pagar el bono
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy: HH:mm"); // Formato para la impresion
        System.out.println("Felicidades. Ha obtenido un bono válido hasta " + b.getCaducidad().format(formato));
        v.addBono(b); // Obtener Bono
    }
}
