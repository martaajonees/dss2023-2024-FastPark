package es.uca.dss.fastpark;
import java.time.LocalDateTime;

public class BonoMensual extends Bono {
    private long precio;
    public BonoMensual() {
        super();
        setPrecioBono(precio);
    }
    public void setPrecioBono(long p) {
        this.precio = p;
    }
    @Override
    public long getPrecioBono() {
        return precio;
    }
    @Override
    public LocalDateTime calcularCaducidad() {
        return getFechaInicio().plusMonths(1);
    }
}
