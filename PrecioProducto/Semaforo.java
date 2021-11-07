package PrecioProducto;

public class Semaforo {
	
	//Single-ton
	
	private static Semaforo semaforo;
	
	private static int recurso = 1;

	private Semaforo() {
		
	}
    public final static Semaforo getInstance(){
        if(semaforo == null){
        	semaforo = new Semaforo();
        }
        return semaforo;
    }
    
    //M�todo que se ejecutar� para insertatr datos en el array PrecioProducto[]
    
    public synchronized void inserta(){
        while(estaDisponible()){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        recurso -= 1;

        reporte();

        this.notifyAll();
    }
    
    //M�todo que se ejecutar� para indicar que el array PrecioProducto[] est� ocupado
    
    public synchronized void ocupado(){
        while(!estaDisponible()){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        recurso += 1;

        reporte();

        this.notifyAll();
    }
    
    //M�todo que determina si el sem�foro est� disponible (1) o no est� disponible (resto)
    
    public synchronized final static boolean estaDisponible(){
        return recurso == 1 ? true : false;
    }
    
    //M�todo que indica el valor de la variable utilizada para controlar el sem�foro (recurso)
    
    public synchronized final static void reporte(){
    	
    	if(recurso==1) {
    		
        System.out.println("Valor del recurso: " + recurso + " -> Insertando...");
        
    	} else {
    		
    		System.out.println("-----------------------------------------");
    		System.out.println("Valor del recurso: " + recurso + " -> Ocupado...");
    			
    	}
    
    }
	
}
