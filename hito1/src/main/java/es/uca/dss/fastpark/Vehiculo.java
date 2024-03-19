package es.uca.dss.fastpark;
import java.lang.String;
import java.time.LocalDateTime;
import java.time.Duration;
public class Vehiculo {
    private LocalDateTime inicio_, fin_;
    private final String matricula_;
    private Bono bono;
    private boolean pagado_;
    public Vehiculo(String mat){
        this.matricula_ = mat;
        this.pagado_ = false;
    }
    public void inicio()
    {
        inicio_ = LocalDateTime.now();
    }
    public LocalDateTime get_inicio(){
        return inicio_;
    }
    public LocalDateTime get_final(){
        return fin_;
    }

    public void set_final(LocalDateTime t){
        fin_ = t;
    } // Solo para los tests

    public long calcularTiempoEstacionado(){
        fin_ = LocalDateTime.now();

        return Duration.between(inicio_, fin_).toMinutes(); // Devuelve los minutos
    }
    public String matricula(){
        return matricula_;
    }
    public void setPago (boolean p ){ //  se ha registrado el pago de su última visita
        this.pagado_ = p;
    }
    public boolean pagado(){
        return pagado_;
    }
    public boolean tieneBono(){
        return bono != null && bono.estaActivo(LocalDateTime.now());
    }
    public void setBono(Bono b){
        bono = b;
    }
}
