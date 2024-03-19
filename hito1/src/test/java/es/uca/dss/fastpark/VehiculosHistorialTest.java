package es.uca.dss.fastpark;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class VehiculosHistorialTest {

    private VehiculosHistorial historial;

    @BeforeEach
    void setUp() {
       this.historial = new VehiculosHistorial();
    }

    @Test
    void guardar() {
        String matricula = "1234ABC";
        Vehiculo vehiculo = new Vehiculo(matricula);

        // Empezar y terminar tiempo
        vehiculo.inicio();
        vehiculo.calcularTiempoEstacionado();

        // Guardar
        historial.guardar(matricula, vehiculo);

        assertEquals(1, historial.get_size());
    }

    @Test
    void listar_historial(){
        String matricula = "1234ABC";
        Vehiculo vehiculo = new Vehiculo(matricula);
        LocalDateTime t = vehiculo.get_inicio();

        // Empezar y terminar tiempo
        vehiculo.inicio();
        vehiculo.calcularTiempoEstacionado();

        // Guardar
        historial.guardar(matricula, vehiculo);

        historial.listar_historial();
    }

    @Test
    void buscar_fecha_entrada() {
        String matricula = "1234ABC";
        Vehiculo vehiculo = new Vehiculo(matricula);
        vehiculo.inicio();
        LocalDateTime t = vehiculo.get_inicio();

        // Empezar y terminar tiempo
        vehiculo.inicio();
        vehiculo.calcularTiempoEstacionado();

        // Guardar
        historial.guardar(matricula, vehiculo);

        // Buscar
        historial.buscar_fecha_entrada(t);
    }

    @Test
    void buscar_fecha_salida() {
        String matricula = "1234ABC";
        Vehiculo vehiculo = new Vehiculo(matricula);
        vehiculo.inicio();
        vehiculo.calcularTiempoEstacionado();
        LocalDateTime t = vehiculo.get_final();

        // Empezar y terminar tiempo
        vehiculo.inicio();
        vehiculo.calcularTiempoEstacionado();

        // Guardar
        historial.guardar(matricula, vehiculo);

        // Buscar
        historial.buscar_fecha_entrada(t);
    }

    @Test
    void buscar_matricula() {
        String matricula = "1234ABC";
        Vehiculo vehiculo = new Vehiculo(matricula);
        vehiculo.inicio();
        vehiculo.calcularTiempoEstacionado();
        LocalDateTime t = vehiculo.get_final();

        // Empezar y terminar tiempo
        vehiculo.inicio();
        vehiculo.calcularTiempoEstacionado();

        // Guardar
        historial.guardar(matricula, vehiculo);

        // Buscar
        historial.buscar_matricula(matricula);
    }
}