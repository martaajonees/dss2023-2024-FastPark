package es.uca.dss.fastpark;

import java.util.Vector;
import java.time.LocalDateTime;

public class VehiculosHistorial implements HistorialRepositorio{

    private final Vector<Fila> historial;

    public static class Fila {
        private final String matricula;
        private final LocalDateTime entrada, salida;

        Fila(String m, LocalDateTime e, LocalDateTime s){
            this.entrada = e;
            this.matricula = m;
            this.salida = s;
        }
        @Override
        public String toString(){
            return "Matrícula: " + matricula + "\t Fecha de inicio: " + entrada + "\t Fecha de fin: " + salida + "\n";
        }
    }

    VehiculosHistorial(){
       this.historial = new Vector<>();
    }
    public void guardar(String mat, Vehiculo v){
        LocalDateTime inicio = v.get_inicio();
        LocalDateTime fin = v.get_final();
        Fila newFila = new Fila(mat, inicio, fin);
        historial.add(newFila);

    }
    public void listar_historial(){
        for(Fila u: historial)
            System.out.println(u);
    }

    public void buscar_fecha_entrada(LocalDateTime f){
        for(Fila u: historial){
            if(u.entrada == f){
                System.out.println(u);
            }
        }

    }
    public void buscar_fecha_salida(LocalDateTime f){
        for(Fila u: historial){
            if(u.salida == f){
                System.out.println(u);
            }
        }
    }

    public void buscar_matricula(String m){
        for(Fila u: historial){
            if(u.matricula.equals(m)){
                System.out.println(u);
            }
        }
    }
}
