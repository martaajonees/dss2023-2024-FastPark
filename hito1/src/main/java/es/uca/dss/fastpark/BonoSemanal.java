package es.uca.dss.fastpark;
import java.time.LocalDateTime;
public class BonoSemanal extends Bono {
    private long precio;
    public BonoSemanal() {
        super();
        setPrecioBono(precio);
    }
    @Override
    public long getPrecioBono() {
        return precio;
    }
    public void setPrecioBono(long p) {
        this.precio = p;
    }
    @Override
    public LocalDateTime calcularCaducidad() {
        return getFechaInicio().plusWeeks(1);
    }
}