package UD1_ProgramacionMultiproceso;

//Ejecuto este código en la clase CreadorHilos

public class Hilo  extends Thread {
	
	private String nombre;
	
	private int retardo;
	
	//Establezco en el constructor que se pase como parámentro un nombre y un retardo
	
	public Hilo(String n, int s) {
		
		this.nombre = n;
		
		this.retardo = s;
		
	}
	
	//Sobreescribo el método run y llamo al método sleep al que le paso como parámetro la variable retardo
	
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
