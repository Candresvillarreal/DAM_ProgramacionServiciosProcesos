package GestionStock;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		GestionStock compras = new GestionStock();
		
		GestionStock ventas = new GestionStock();
		
		//Creo los threads
		
		Thread comprasThread = new Thread(compras);
		
		Thread ventasThread = new Thread(ventas);
		
		//Arranco los procesos
		
		comprasThread.start();
		
		ventasThread.start();

	}

}
