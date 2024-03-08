package es.uca.dss.fastpark;

public class Tarificacion {
    public long minuto_;
    public Tarificacion (long minuto){
        this.minuto_ = minuto;
    }
    // Método setter
    public void setPrecioMinuto(long m) {
        this.minuto_ = m;
    }
    //Método getter
    public long getPrecioMinuto() {
        return minuto_;
    }

    @Override
    public String toString() {
        return "La tarifa para este parking es de " + getPrecioMinuto() + " euros el minuto";
    }
}
