package es.uca.dss.fastpark;

public class FastPark {
    private final Parking parking;
    private final Tarificacion tarifas;
    public FastPark(Parking p, Tarificacion t){
        this.parking = p;
        this.tarifas = t;
        p.setTarificacion(t);
    }
    @Override
    public String toString() {
        return parking.toString() + tarifas.toString();
    }
}
