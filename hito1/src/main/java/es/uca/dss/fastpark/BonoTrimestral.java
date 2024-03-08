package es.uca.dss.fastpark;
import java.time.LocalDateTime;
public class BonoTrimestral extends Bono {
    private long precio;
    public BonoTrimestral() {
        super();
        setPrecioBono(precio);
    }
    public void setPrecioBono(long p) {
        this.precio = p;
    }
    @Override
    public LocalDateTime calcularCaducidad() {
        return getFechaInicio().plusMonths(3);
    }
    @Override
    public long getPrecioBono() {
        return precio;
    }
}
