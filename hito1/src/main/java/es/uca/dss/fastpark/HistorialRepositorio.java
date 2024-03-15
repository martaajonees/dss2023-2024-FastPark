package es.uca.dss.fastpark;

import java.time.LocalDateTime;

public interface HistorialRepositorio {
    void guardar(String mat, Vehiculo v);
    void listar_historial();
    void buscar_fecha_entrada(LocalDateTime f);
    void buscar_fecha_salida(LocalDateTime f);
    void buscar_matricula(String m);
}
