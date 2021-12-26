
public class ControlSalida extends Thread{
	
	/*Utilizando el semáfoco cc creado en la clase CentroComercial, implementa el método que controla la salida del centro comercial
	 *Su constructor recibe por parámetro el nombre del Thread, para poder identificar el hilo que se está ejecutando, el cliente y 
	 *y el objeto único CentroComercial cc 
	 */
	
	private CentroComercial cc;
	
	private Cliente cliente;
	
	protected ControlSalida(String nombre, Cliente cliente, CentroComercial cc) {
		
		super(nombre);
		
		this.cliente = cliente;
		
		this.cc = cc;
		
	}
	
	//Sobreescribo el método run, que contiene el método que ejecuta el control de acceso al centro comercial (salir)
	
	public void run() {
		
		try {
			
			sleep(40);
			
			cc.salir(getName(), cliente);
			
			sleep(40);
			
		}catch(InterruptedException e) {
			
			e.printStackTrace();
			
		}
		
	}

}
