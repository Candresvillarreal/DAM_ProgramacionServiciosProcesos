package Dados;

import java.util.ArrayList;

	public class Dado extends Thread {
		
		int cara;
		
		int tirada;
		
		int numTiradas;
		
		ArrayList<Integer> tiradas = new ArrayList<Integer>();
		
		//Constructores
		
		public Dado(int cara) {
			
			this.cara = tirada;
			
		}
		
		public Dado(int cara, int numTiradas) {
			
			this.cara = cara;
			
			this.numTiradas = numTiradas;
			
		}
		
		public Dado() {
			
			this.cara = 6;
			
			this.numTiradas = 10;
			
		}
		
		//Tirada
		
		public int Tirada() {
			
			this.tirada=(int) Math.floor(Math.random()*this.cara+1);
			
			return tirada;
		}
		
		//Metodo ejecutable en paralelo
		
		public void run() {
			
			for(int i=0;i<this.numTiradas;i++) {
				
				tiradas.add(this.Tirada());
				
				System.out.println("[id:"+this.getId()+"] "+this);
				
				try {
					
					this.sleep(500);
					
				} catch (InterruptedException e) {
					
					// Despertamos
				}	
			}
		}
		
		//Imprimir última tirada
		
		public String toString() {
			
			return "Ultima tirada: "+this.tirada;
			
		}

}
