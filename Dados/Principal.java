package Dados;

public class Principal {
	
	public static void main(String[] args) {
		// Ejemplo01 sin Thread
		Dado dado01=new Dado(12);
		Dado dado02=new Dado(10);
		
		/*
		//Primer dado
		for(int i=1;i<10;i++) {
			dado01.Tirada();
			System.out.println(dado01);
		}
		//Segundo dado
		for(int i=1;i<10;i++) {
			dado02.Tirada();
			System.out.println(dado02);
		}
		*/
		/*
		//Ejecución en paralelo
		Thread primerJuego=new Dado(6,10);
		Thread segundoJuego=new Dado(6,12);
		primerJuego.start();
		segundoJuego.start();
		*/
		//Ejecución en paralelo Dados
		int[] caras = {8, 10};
		int[] tiradas = {4, 8};
		//Thread juego=new Dados(2,caras,tiradas);
		Dados dados=new Dados(2,caras,tiradas);
		Thread juego=new Thread(dados);
		juego.start();
	}
	

}
