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
    
    //Método que se ejecutará para insertatr datos en el array PrecioProducto[]
    
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
    
    //Método que se ejecutará para indicar que el array PrecioProducto[] está ocupado
    
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
    
    //Método que determina si el semáforo está disponible (1) o no está disponible (resto)
    
    public synchronized final static boolean estaDisponible(){
        return recurso == 1 ? true : false;
    }
    
    //Método que indica el valor de la variable utilizada para controlar el semáforo (recurso)
    
    public synchronized final static void reporte(){
    	
    	if(recurso==1) {
    		
        System.out.println("Valor del recurso: " + recurso + " -> Insertando...");
        
    	} else {
    		
    		System.out.println("-----------------------------------------");
    		System.out.println("Valor del recurso: " + recurso + " -> Ocupado...");
    			
    	}
    
    }
	
}
