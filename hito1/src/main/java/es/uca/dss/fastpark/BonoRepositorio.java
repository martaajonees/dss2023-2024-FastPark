package es.uca.dss.fastpark;

import java.time.LocalDateTime;
import java.util.Vector;


public class BonoRepositorio{
    private final Vector<Bono> bonos;
    public BonoRepositorio (){
        this.bonos = new Vector<>();
    }

    public Bono get() { // Devuelve el bono activo
        for(Bono b: bonos){
            if(b.estaActivo(LocalDateTime.now())){
                return b;
            }
        }
        return null;
    }

    public void guardar(Bono b) {
        bonos.add(b);
    }

    public boolean vacia(){
        return bonos.isEmpty();
    }
}
