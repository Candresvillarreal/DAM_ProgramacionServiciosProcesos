package PrecioProducto;

public class Principal {
	
	static PrecioProducto productos[] = new PrecioProducto[10];
	
	public static void main(String[] args) {
		
        Thread Insertador = new Thread(new InsertaPrecio(productos, Semaforo.getInstance()));
        
        Thread Aviso = new Thread(new ArrayOcupado(productos, Semaforo.getInstance()));
       
        Insertador.start();
        
        Aviso.start();
       
	}

}
