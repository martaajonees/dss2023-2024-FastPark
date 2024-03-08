package es.uca.dss.fastpark;
import java.lang.String;
import java.util.concurrent.TimeUnit;

public class Parking {
    private final String nombre;
    private final int dirPostal, nPlazas;
    private int plazasOcupadas;
    private final VehiculoRepositorio coches;
    private final QRServicio cod;
    private final Barrera bar;
    private Tarificacion tarifas;
    private PagoEstancia pagoEstancia;
    //Constructor
    public Parking (String nom, int dir, int plazas){
        this.nombre = nom;
        this.dirPostal = dir;
        this.nPlazas = plazas;
        this.plazasOcupadas = 0; // Plazas ocupadas actuales
        this.coches = new VehiculosHash();
        this.cod = new QRServicio();
        this.bar = new Barrera();
    }

    // Método set tarificación
    public void setTarificacion(Tarificacion t){
        this.tarifas = t;
        this.pagoEstancia = new PagoEstancia(tarifas, coches);
    }
    // Métodos
    public void entrada(String mat){ // Se lee su matrícula automáticamente
        Vehiculo veh = new Vehiculo(mat); // Creamos el vehículo
        if(plazasOcupadas < nPlazas){ // Si hay hueco para el coche
            if(!bar.abierta()) bar.abrir(); // Abrimos la barrera
            cod.generarQR(mat); // Generamos QR: te lo guarda en ruta
            coches.guardar(mat, veh); // Añadimos al map
            plazasOcupadas ++; // Se ha ocupado una plaza más
            veh.inicio(); // Empezamos a contar tiempo de estancia
            try {
                TimeUnit.SECONDS.sleep(15);
            } catch (InterruptedException e){
                System.out.println(e);
            }
            bar.cerrar();
        } else System.out.println("No hay más espacio. Espere a que salga algún vehículo");
    }
    public void salida(){
        String mat = cod.leerQR();
        Vehiculo veh = coches.get(mat);
        if(veh != null){ // Verificamos que esté en la base de datos
            if(veh.pagado() || veh.tieneBono()){ // Vemos que esté pagado o tenga bono
                bar.abrir(); // abrimos barrera para que se vaya
                try {
                    TimeUnit.SECONDS.sleep(15);
                } catch (InterruptedException e){
                    System.out.println(e);
                }
                bar.cerrar();
                plazasOcupadas --;
                coches.remove(mat, veh);
            } else System.out.println("Debe pagar la estancia antes de salir");
        } else System.out.println("ERROR. No existe el vehículo asociado a esta matricula.");
    }
    public void pagarEstandar(){
        pagoEstancia.pagar();
    }

    @Override
    public String toString() {
        return "El Parking " + nombre + " con dirección postal " + dirPostal + " tiene " + plazasOcupadas + " de las " + nPlazas + " ocupadas";
    }
}

