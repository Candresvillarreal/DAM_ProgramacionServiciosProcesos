package Almacen;

public class Almacen {
	
	public static void main(String[]args) {
		
		Pedido pedido1 = new Pedido("Pedido 1", new int[] {2,2,1,5,2,3});
		
		Pedido pedido2 = new Pedido("Pedido 2", new int[] {1,3,5,1,1});
		
		//Tiempo inicial de referencia
		
		long initialTime = System.currentTimeMillis();
		
		Trabajador lucia = new Trabajador("Lucia", pedido1, initialTime);
		
		Trabajador juan = new Trabajador("Juan", pedido2, initialTime);
		
		lucia.start();
		
		juan.start();
		
		
	}

}
