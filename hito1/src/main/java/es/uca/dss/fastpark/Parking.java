package es.uca.dss.fastpark;
import com.google.zxing.NotFoundException;

import java.io.IOException;
import java.lang.String;
import java.util.concurrent.TimeUnit;

public class Parking {
    // info de la clase
    private final String nombre;
    private final int dirPostal, nPlazas;
    private int plazasOcupadas;
    // Objetos que lo componen
    private final VehiculoRepositorio coches;
    private final HistorialRepositorio historial;
    private final QRServicio cod;
    private final Barrera bar;
    private Tarificacion tarifas;
    private PagoEstancia pagoEstancia;
    private final PagoBono pagoBono;

    //Constructor
    public Parking (String nom, int dir, int plazas){
        this.nombre = nom;
        this.dirPostal = dir;
        this.nPlazas = plazas;
        this.plazasOcupadas = 0; // Plazas ocupadas actuales
        this.coches = new VehiculosHash();
        this.cod = new QRServicio();
        this.bar = new Barrera();
        this.historial = new VehiculosHistorial();
        this.pagoEstancia = new PagoEstancia(tarifas);
        this.pagoBono = new PagoBono();
    }

    // Método set tarificación
    public void setTarificacion(Tarificacion t){
        this.tarifas = t;
        this.pagoEstancia = new PagoEstancia(tarifas);
    }
    // Métodos
    public void entrada(String mat){ // Se lee su matrícula automáticamente
        Vehiculo veh = new Vehiculo(mat); // Creamos el vehículo
        if(plazasOcupadas < nPlazas){ // Si hay hueco para el coche
            if(!bar.abierta()) bar.abrir(); // Abrimos la barrera
            try{
                cod.generarQR(mat); // Generamos QR: te lo guarda en ruta
            } catch (Exception e)
            {
                System.err.println(e.getMessage());
            }
            plazasOcupadas ++; // Se ha ocupado una plaza más
            veh.inicio(); // Empezamos a contar tiempo de estancia
            coches.guardar(mat, veh); // Añadimos al map
            try {
                TimeUnit.SECONDS.sleep(15);
            } catch (InterruptedException e){
                System.err.println(e.getMessage());
            }
            bar.cerrar();
        } else System.out.println("No hay más espacio. Espere a que salga algún vehículo");
    }
    public void salida() throws IOException, NotFoundException {
        String mat = cod.leerQR();
        Vehiculo veh = coches.get(mat);

        if(veh != null){ // Verificamos que esté en la base de datos
            if(veh.pagado() || veh.tieneBono()){ // Vemos que esté pagado o tenga bono
                bar.abrir(); // abrimos barrera para que se vaya
                historial.guardar(mat, veh); // guardamos en el historial
                try {
                    TimeUnit.SECONDS.sleep(15);
                } catch (InterruptedException e){
                    System.err.println(e.getMessage());
                }
                bar.cerrar();
                plazasOcupadas--;
                System.out.println(plazasOcupadas);
                coches.remove(mat, veh);
            } else System.out.println("Debe pagar la estancia antes de salir");
        } else System.out.println("ERROR. No existe el vehículo asociado a esta matricula.");
    }
    public int getPlazasOcupadas()
    {
        return plazasOcupadas;
    }

    // Pagos Estándar
    public void pagarEstandar() throws IOException, NotFoundException{
        String matricula = cod.leerQR(); // Leemos el codigo QR
        Vehiculo vehiculo = coches.get(matricula); // Dada la matrícula cojo el vehiculo
        pagoEstancia.pagar(vehiculo);
    }
    //Pagar un Bono (de un tipo determinado)
    public void pagarBono(Bono b) throws NotFoundException, IOException{
        String matricula = cod.leerQR(); // Leemos el codigo QR
        Vehiculo v = coches.get(matricula); // Dada la matrícula cojo el vehiculo
        pagoBono.obtenerBono(b, v);
    }

    @Override
    public String toString() {
        return "El Parking " + nombre + " con dirección postal " + dirPostal + " tiene " + plazasOcupadas + " de las " + nPlazas + " ocupadas";
    }
}

