package es.uca.dss.fastpark;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class VehiculosHashTest {
    private VehiculosHash repositorio;
    @BeforeEach
    void setUp() {
        repositorio = new VehiculosHash();
    }

    @Test
    void get() {
        Vehiculo vehiculo = new Vehiculo("1234ABC");
        repositorio.guardar("1234ABC", vehiculo);
        assertEquals(vehiculo, repositorio.get("1234ABC"), "El vehículo recuperado debería ser igual al vehículo guardado");
    }

    @Test
    void guardar() {
        Vehiculo vehiculo = new Vehiculo("1234ABC");
        repositorio.guardar("1234ABC", vehiculo);
        assertEquals(vehiculo, repositorio.get("1234ABC"), "El vehículo guardado debería ser recuperable");
    }

    @Test
    void remove() {
        Vehiculo vehiculo = new Vehiculo("1234ABC");
        repositorio.guardar("1234ABC", vehiculo);
        repositorio.remove("1234ABC", vehiculo);
        assertNull(repositorio.get("1234ABC"), "El vehículo debería ser eliminado del repositorio");
    }
}