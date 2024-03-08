package es.uca.dss.fastpark;
import java.time.LocalDateTime;

abstract class Bono {
    private final LocalDateTime inicio, caducidad;
    protected Bono() {
        this.inicio = LocalDateTime.now();
        this.caducidad = calcularCaducidad();
    }
    public abstract long getPrecioBono();
    public abstract void setPrecioBono(long p);
    public abstract LocalDateTime calcularCaducidad();

    public LocalDateTime getFechaInicio() {
        return inicio;
    }

    public LocalDateTime getCaducidad() {
        return caducidad;
    }
    public boolean estaActivo(LocalDateTime actual){
        return actual.isBefore(caducidad);
    }
}
