
public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Accedo al semáforo mediante el método getInstance
		
		CentroComercial cc = CentroComercial.getInstance();
		
		//Creo los hilos
		
		Thread e1 = new Thread(new ControlAcceso("Cliente 1", new Cliente(10,5), cc));
		
		Thread e2 = new Thread(new ControlAcceso("Cliente 2", new Cliente(5,0), cc));
		
		Thread e3 = new Thread(new ControlAcceso("Cliente 3", new Cliente(15,10), cc));
		
		Thread e4 = new Thread(new ControlAcceso("Cliente 4", new Cliente(3,1), cc));
		
		Thread e5 = new Thread(new ControlAcceso("Cliente 5", new Cliente(5,5), cc));
		
		Thread s1 = new Thread(new ControlSalida("Cliente 6", new Cliente(16,3), cc));
		
		Thread s2 = new Thread(new ControlSalida("Cliente 7", new Cliente(15,15), cc));
		
		//Ejecuto los hilos
		
		e1.start();
		
		e2.start();
		
		e3.start();
		
		e4.start();
		
		e5.start();
		
		s1.start();
		
		s2.start();
		
		try {
			
			e1.join();
			
			e2.join();
			
			e3.join();
			
			e4.join();
			
			e5.join();
			
			s1.join();
			
			s2.join();
			
			
		}catch(InterruptedException e) {
			
			e.printStackTrace();
			
		}
		
		//Muestro un resumen del aforo final y el número total de adultos y niños que quedan dentro
		
		
		System.out.println("\n------------------------------------------------Resumen Control Acceso-----------------------------------------------------------------");
		
		System.out.println("\nAforo final: " + cc.getAforo() + " clientes");
		
		System.out.println("Quedan " + cc.getNumAdultos() + " adultos y " + cc.getNumNinos() + " niños.");
		
		System.out.println("En total han entrado " + cc.getTotalClientesAcceso() + " clientes y han salido " + cc.getTotalClientesSalida());
		
		System.out.println("En total han entrado " + cc.getTotalAdultosAcceso() + " adultos y " + cc.getTotalNinyosAcceso() + " niños");
		
		System.out.println("En total han salido " + cc.getTotalAdultosSalida() + " adultos y " + cc.getTotalNinyosSalida() + " niños");
		
		System.out.println("\n------------------------------------------------Aplicación finalizada------------------------------------------------------------------");

	}

}
