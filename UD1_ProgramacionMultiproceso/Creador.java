package UD1_ProgramacionMultiproceso;

//Creaci�n de un proceso -> proceso que ejecuta la apertura de AdobeReader

import java.io.IOException;

public class Creador {
	
	//M�todo que crea el objeto proceso a trav�s de ProcessBuilder
	
	public void ejecutar(String ruta) {
		
		ProcessBuilder pb;
		
		try {
			
			//Creo el objeto ProcessBuilder
			
			pb = new ProcessBuilder(ruta);

			//Inicio el proceso
			
			pb.start();
			
		}catch(IOException e) {
			
			System.out.println("Error");
			
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Indico la ruta donde est� el ejecutable
		
		String ruta = "C:\\Program Files (x86)\\Adobe\\Acrobat Reader DC\\Reader\\AcroRd32.exe";
		
		//Instantio el objeto de la clase Creador
		
		Creador cr = new Creador();
		
		//Llamo al m�todo ejecutar que he creado
		
		cr.ejecutar(ruta);
		
		System.out.println("Proceso finalizado");

	}

}
