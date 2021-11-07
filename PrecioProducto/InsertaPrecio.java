package PrecioProducto;

public class InsertaPrecio implements Runnable {
	
	//Clase que inserta proveedor y precio en el array PrecioProducto[]
	
	
	PrecioProducto productos[] = new PrecioProducto[10];
	
	private static Semaforo semaforo = null;
	
	public InsertaPrecio(PrecioProducto arrayProductos[], Semaforo s) {
		
		productos = arrayProductos;
		
		semaforo = s;
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		//Creo variables para ir cambiando el proveedor y el precio a cada vuelta del for
		
		String proveedor = "Proveedor";
		
		float precio = 10;
		
		for(int i=0; i<productos.length; i++) {
			
			productos[i] = new PrecioProducto(proveedor + i, precio + i);
			
			System.out.println(productos[i]);
			
			System.out.println("Datos insertados en posición " + i + " Liberando array");
			
			semaforo.inserta();
		
		}
			
	}
		
}
