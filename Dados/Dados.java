package Dados;

import java.util.ArrayList;

public class Dados implements Runnable {
	
	int numDados;
	int numCaras[];
	int numTiradas[];
	
	//Constructores
	public Dados(int numDados,int[] numCaras,int[] numTiradas) {
		this.numDados=numDados;
		this.numCaras=numCaras;
		this.numTiradas=numTiradas;
	}
	public Dados() {
		//super(6,10);
		this.numDados=1;
	}

	@Override
	public void run() {
		for(int i=0;i<this.numDados;i++) {
			Thread dado=new Dado(this.numCaras[i],this.numTiradas[i]);
			dado.start();
		}
	}
	
	
	
	
	

}
