package Personas;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Ejemplo de hilo sencillo
		
		System.out.println("-------------Lanzamos el programa-------------");

		//Creo dos personas de la ciudad secuencial (Persona.java)
		
		Persona juan = new Persona("Juan");
		
		Persona maria = new Persona("María");
		
		//Hago que caminen
		
		juan.camina(5);
		
		maria.camina(6);
		
		//Creo dos personas de la ciudad paralea (PersonaHila.java)
		
		PersonaHila lucia = new PersonaHila("Lucía", 5);
		
		PersonaHila pedro = new PersonaHila("Pedro", 6);
		
		//Hago que caminen
		
		lucia.start();
		
		pedro.start();
	}

}
