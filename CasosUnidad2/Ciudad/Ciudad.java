package Ciudad;

public class Ciudad extends Thread {
	
	//Caracter�sticas

		String nombre="CIUDAD";

		int poblaci�nInicial=100;

		int poblacionActual=poblaci�nInicial;


		public Ciudad(String nombre) {

			this.nombre=nombre;

		}

		
		public void run() {			//Esta es la definici�n que faltaba

			try {

				while(poblacionActual>0) {

					//De forma aleatoria nacen y mueren habitantes. Adem�s lo hacen de una forma en tiempo tambi�n aleatoria

					sleep((int) Math.floor(Math.random()*100)); //Esperamos un tiempo aleatorio

					int nacimientos=(int) Math.floor(Math.random()*5); //Nacen un numero aleatorio entre 0 y 5

					System.out.println("La ciudad "+this.nombre+" ha tenido "+nacimientos+" nacimientos");
					
					poblacionActual=poblacionActual+nacimientos;		//Este es el c�digo que faltaba

					sleep((int) Math.floor(Math.random()*100)); //Esperamos un tiempo aleatorio

					int muertes=(int) Math.floor(Math.random()*10); //Mueren un numero aleatorio entre 0 y 10

					System.out.println("La ciudad "+this.nombre+" ha tenido "+muertes+" muertes");

					poblacionActual=poblacionActual-muertes;

				}

				System.out.println("La ciudad "+this.nombre+" ha desaparecido");

			} catch (InterruptedException e) {

				e.printStackTrace();

			}

		}

	}

