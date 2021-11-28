package AgenciaViajes;

public class Ventanilla {
	
	public static void main(String[] args) {
		Agencia ag=new Agencia();
		
		Thread cliente1=new Thread(ag);
		Thread cliente2=new Thread(ag);
		cliente1.setName("Cliente 1");
		cliente2.setName("Cliente 2");
		cliente1.start();
		cliente2.start();

	}

}
