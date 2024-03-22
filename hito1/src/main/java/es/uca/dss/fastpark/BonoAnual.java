package es.uca.dss.fastpark;
import java.time.LocalDateTime;

public class BonoAnual extends Bono {
    private long precio;
    public BonoAnual() {
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
        return getFechaInicio().plusYears(1);
    }

}