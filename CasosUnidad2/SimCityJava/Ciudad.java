package SimCityJava;

public class Ciudad extends Thread {

	//Caracteristicas
	
	String nombre="CIUDAD";
	
	int poblacionInicial=100;
	
	int poblacionActual=poblacionInicial;
	
	AlmacenComida aComida;

	public Ciudad(String nombre, AlmacenComida aComida) {
		
		this.nombre=nombre;
		
		this.aComida=aComida;
		
	}
	
	//AQU� FALTA C�DIGO {
	
	public void run() {
		
		try {
			
			while(poblacionActual>0) {
				
				//De forma aleatoria nacen y mueren habitantes. Además lo hacen de una forma en tiempo tambien aleatoria
				
				sleep((int) Math.floor(Math.random()*100)); //Esperamos un tiempo aleatorio
				
				int nacimientos=(int) Math.floor(Math.random()*5); //Nacen un numero aleatorio entre 0 y 5
				
				System.out.println("["+this.nombre+"] Ha tenido "+nacimientos+" nacimientos");
				
				poblacionActual=poblacionActual+nacimientos;
				
				//Se solicita la comida para la población actual
				
				boolean hayComida=this.aComida.solicitarComida(poblacionActual,this.nombre);
				
				if (!hayComida) {
					
					sleep((int) Math.floor(Math.random()*20));		//Este es el código que falta -> Esperamos un tiempo aleatorio
					
					int muertes=(int) Math.floor(Math.random()*10); 	//Este es el código que falta -> Mueren un numero aleatorio entre 0 y 10
					
					System.out.println("["+this.nombre+"] Ha tenido "+muertes+" muertes");
					
					poblacionActual = poblacionActual - muertes;  	//Este es el código que falta -> Restamos las muertes
					
				}
				
			}
			
			System.out.println("["+this.nombre+"] HA DESAPARECIDO");
			
		} catch (InterruptedException e) {
			
			e.printStackTrace();
			
		}
		
	}

}
