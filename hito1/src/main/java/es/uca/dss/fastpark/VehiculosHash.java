package es.uca.dss.fastpark;

import java.util.HashMap;
import java.util.Map;

public class VehiculosHash implements VehiculoRepositorio {
    private final Map<String, Vehiculo> coches;
    public VehiculosHash (){
        this.coches = new HashMap<>();
    }
    @Override
    public Vehiculo get(String mat) {
        return coches.get(mat);
    }

    @Override
    public void guardar(String mat, Vehiculo v) {
        coches.put(mat, v);
    }

    @Override
    public void remove(String mat, Vehiculo v) {
        coches.remove(mat, v);
    }
}
