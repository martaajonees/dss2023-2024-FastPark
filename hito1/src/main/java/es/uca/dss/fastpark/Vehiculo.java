package es.uca.dss.fastpark;
import java.lang.String;
import java.time.LocalDateTime;
import java.time.Duration;
import java.util.Vector;

public class Vehiculo {
    // info de un vehiculo
    private LocalDateTime inicio_, fin_;
    private final String matricula_;
    private boolean pagado_;
    // Objetos
    private BonoRepositorio bonos;

    // Constructor
    public Vehiculo(String mat){
        this.matricula_ = mat;
        this.pagado_ = false;
        this.bonos = new BonoRepositorio();
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
    public boolean tieneBono() {
        if (bonos.vacia()) { // Si está vacío no tiene bono
            return false;
        } else if(bonos.get() != null){ // Si no está vacío y tiene uno activo
            return true;
        }
        return false;
    }
    public void addBono(Bono b){
        bonos.guardar(b);
    }
}
