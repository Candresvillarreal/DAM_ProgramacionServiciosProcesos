package UD1_ProgramacionMultiproceso;

//Esta clase ejecuta el código de la clase Hilo.java

public class CreadorHilos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Hilo h1, h2;
		
		//creo los objetos de la clase Hilo.  Cada objeto tendrá un retardo aleatorio 
		
		h1 = new Hilo("hilo 1", (int)(Math.random()*2000));
		
		h2 = new Hilo("hilo 2", (int)(Math.random()*2000));
		
		//Llamo al método start() para que se ejecuten
		
		h1.start();
		
		h2.start();

	}

}
