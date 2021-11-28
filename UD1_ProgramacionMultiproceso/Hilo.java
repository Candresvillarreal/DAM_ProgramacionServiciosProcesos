package UD1_ProgramacionMultiproceso;

//Ejecuto este c�digo en la clase CreadorHilos

public class Hilo  extends Thread {
	
	private String nombre;
	
	private int retardo;
	
	//Establezco en el constructor que se pase como par�mentro un nombre y un retardo
	
	public Hilo(String n, int s) {
		
		this.nombre = n;
		
		this.retardo = s;
		
	}
	
	//Sobreescribo el m�todo run y llamo al m�todo sleep al que le paso como par�metro la variable retardo
	
	public void run() {
		
		try {
			
			sleep(retardo);
			
		}catch (InterruptedException e) {
			
			System.out.println(e.getMessage());
			
		}
		
		//Imprimo el nombre y el retardo del objeto
		
		System.out.println(nombre + " -> retardo: " + retardo);
	}

}
