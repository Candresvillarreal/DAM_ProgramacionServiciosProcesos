package Personas;

public class Persona {
	
	private String nombre;
	
	public Persona(String nombre) {
		
		this.nombre=nombre;
		
	}
	
	public void camina(int km) {
		
		System.out.println("["+this.nombre+"] empieza a caminar");
		
		for(int i=0; i<km; i++) {
			
			System.out.println("["+this.nombre+"] Km: " + i);
			
			//Creo la pausa para que camine
			
			try {
				
				Thread.sleep(500);   //0.5 segundos
				
			}catch(InterruptedException e) {
				
				Thread.currentThread().interrupt();
				
			}
		}
		
	}

}
