
public class ControlAcceso extends Thread {
	
	/*Utilizando el sem�foco cc creado en la clase CentroComercial, implementa el m�todo que controla el acceso al centro comercial
	 *Su constructor recibe por par�metro el nombre del Thread, para poder identificar el hilo que se est� ejecutando, el cliente y 
	 *y el objeto �nico CentroComercial cc 
	 */
	
	private Cliente cliente;
	
	private CentroComercial cc;
	
	protected ControlAcceso(String nombre, Cliente cliente, CentroComercial cc) {
		
		super(nombre);
		
		this.cliente = cliente;
		
		this.cc = cc;
		
	}
	
	//Sobreescribo el m�todo run, que contiene el m�todo que ejecuta el control de acceso al centro comercial (entrar)
	
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
