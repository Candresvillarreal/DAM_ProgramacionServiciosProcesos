package PrecioProducto;

public class ArrayOcupado implements Runnable{
	
	private static Semaforo semaforo = null;

	PrecioProducto productos[] = new PrecioProducto[10];
	
	public ArrayOcupado(PrecioProducto arrayProductos[],Semaforo s) {
		
		productos=arrayProductos;
		
    	semaforo = s;
	}
	
    @Override
    public void run() {
    	
        for(int i = 0; i<productos.length; i++){
        	
        	//System.out.println(productos[i].toString());
            
        	//System.out.println(producto[i]);
        	
        	System.out.println("Array ocupado.  No puede ser utilizado...");
        	System.out.println("-----------------------------------------");
        	
            semaforo.ocupado();
            
        }
        
    }
    
}
