package es.uca.dss.fastpark;
import java.lang.String;

public interface VehiculoRepositorio {
    Vehiculo get(String mat);
    void guardar(String mat, Vehiculo v);
    void remove(String mat, Vehiculo v);
}
