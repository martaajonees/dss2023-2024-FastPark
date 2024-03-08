package es.uca.dss.fastpark;

public class Barrera {
    private boolean abierta_;
    public Barrera(){
        this.abierta_ = false;
    }
    public boolean abierta(){
        return abierta_;
    }
    public void abrir(){
        if(!abierta_){
            // Abrir barrera
            abierta_ = true;
        } else	{
            System.out.println("La barrera debe estar cerrada");
        }
    }
    public void cerrar(){
        // Cerrar barrera
        if(abierta_){
            abierta_ = false;
        }	else	{
            System.out.println("La barrera debe estar abierta");
        }
    }
}
