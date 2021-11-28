package Personas;

public class PersonaHila extends Thread {
	
	private String nombre;
	
	private int km;
	
	public PersonaHila(String nombre, int km) {
		
		this.nombre=nombre;
		
		this.km=km;
		
	}
	
	public void run() {
		
		System.out.println("["+this.nombre+"] Empieza a caminar");
		//System.out.println(this.nombre + " Empieza a caminar");
		
		for(int i=0; i<this.km; i++) {
			
			System.out.println("["+this.nombre+"]" + this.km + ": "  + i);
			//System.out.println(this.nombre + this.km + i);
			
			//creo la pausa para que la persona camine
			
			try {
				
				Thread.sleep(500); //0.5 segundos de pausa
			
			}catch(InterruptedException e){
				
				Thread.currentThread().interrupt();
				
			}
		}
		
	}
}
