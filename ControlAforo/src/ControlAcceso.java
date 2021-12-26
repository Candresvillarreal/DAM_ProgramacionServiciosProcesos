
public class ControlAcceso extends Thread {
	
	/*Utilizando el semáfoco cc creado en la clase CentroComercial, implementa el método que controla el acceso al centro comercial
	 *Su constructor recibe por parámetro el nombre del Thread, para poder identificar el hilo que se está ejecutando, el cliente y 
	 *y el objeto único CentroComercial cc 
	 */
	
	private Cliente cliente;
	
	private CentroComercial cc;
	
	protected ControlAcceso(String nombre, Cliente cliente, CentroComercial cc) {
		
		super(nombre);
		
		this.cliente = cliente;
		
		this.cc = cc;
		
	}
	
	//Sobreescribo el método run, que contiene el método que ejecuta el control de acceso al centro comercial (entrar)
	
	public void run() {
		
		try {
			
			sleep(40);
			
			cc.entrar(getName(), cliente);
			
			sleep(40);
			
		}catch(InterruptedException e) {
			
			e.printStackTrace();
			
		}
		
	}

}
