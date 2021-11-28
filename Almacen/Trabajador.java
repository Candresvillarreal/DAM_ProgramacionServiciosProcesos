package Almacen;

public class Trabajador extends Thread {
	
	//Creo las variables y objetos necesarios para procesar un pedido
	
	private String nombre;
	
	private Pedido pedido;
	
	private long initialTime;
	
	//Constructor
	
	public Trabajador(String nombre, Pedido pedido, long initialTime) {
		
		this.nombre=nombre;
		
		this.pedido=pedido;
		
		this.initialTime=initialTime;
	}
	
	@Override
	
	public void run() {
		
		//Mensaje de inicio
		
		System.out.println("El trabajador "  + this.nombre + " empieza a procesar el pedido " +
							this.pedido.getId() + " en el tiempo: " + (this.initialTime/1000) + " seg");
	
		
		//Se procesa uno a uno todos los productos
		
		for(int i=0; i<this.pedido.getProductos().length; i++) {
		
		this.esperarCamion(pedido.getProductos()[i]);
		
		System.out.println("Procesado el producto " + (i+1) + " del pedido " + this.pedido.getId() + " ->Tiempo: " +
		(System.currentTimeMillis()/1000));
		
		//Finalizado el pedido
		
		
		
		}
		
		System.out.println("El trabajador " + this.nombre + " ha terminado de procesar " + this.pedido.getId() +
				" en el tiempo: " + (System.currentTimeMillis())/1000 + "seg");
		
	}
	
	//Tiempo introducido para simular el tiempo que tarda en llegar cada producto al almacén
	
	public void esperarCamion(int segundos) {
		
		try {
			
			Thread.sleep(segundos*1000);
			
		}catch(InterruptedException ex) {
			
			Thread.currentThread().interrupt();
			
		}
		
	}
	
	

}
