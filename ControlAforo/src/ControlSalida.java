
public class ControlSalida extends Thread{
	
	/*Utilizando el sem�foco cc creado en la clase CentroComercial, implementa el m�todo que controla la salida del centro comercial
	 *Su constructor recibe por par�metro el nombre del Thread, para poder identificar el hilo que se est� ejecutando, el cliente y 
	 *y el objeto �nico CentroComercial cc 
	 */
	
	private CentroComercial cc;
	
	private Cliente cliente;
	
	protected ControlSalida(String nombre, Cliente cliente, CentroComercial cc) {
		
		super(nombre);
		
		this.cliente = cliente;
		
		this.cc = cc;
		
	}
	
	//Sobreescribo el m�todo run, que contiene el m�todo que ejecuta el control de acceso al centro comercial (salir)
	
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
