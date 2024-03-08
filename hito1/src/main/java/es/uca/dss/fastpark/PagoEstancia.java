package es.uca.dss.fastpark;

public class PagoEstancia {
    private final QRServicio cod_;
    private final Tarificacion tarifa;
    private final VehiculoRepositorio coches;
    public PagoEstancia (Tarificacion t, VehiculoRepositorio c) {
        this.tarifa = t;
        this.coches = c;
        this.cod_ = new QRServicio();
    }
    public void pagar(){
        String matricula = cod_.leerQR(); // Leemos el codigo QR
        Vehiculo vehiculo = coches.get(matricula); // Dada la matrícula cojo el vehiculo
        long precio = obtenerPrecio(vehiculo.calcularTiempoEstacionado());
        System.out.println("El vehículo con matrícula " + vehiculo.matricula() + " debe pagar " + precio + " euros.");
        // Pagar dinero
        vehiculo.setPago(true);
    }

    long obtenerPrecio(long minutos){
        return minutos * tarifa.getPrecioMinuto();
    }
}
