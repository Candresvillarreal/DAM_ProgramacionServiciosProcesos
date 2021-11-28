package AgenciaViajes;

public class Agencia implements Runnable{
	
	int numAsientos;
	private AsientosAvion avion = new AsientosAvion();

	public Agencia() {
		this.numAsientos=3;
	}

	@Override
	public void run() {
		gestionAsientosAvion(numAsientos);
		if(avion.getAsientosLibres()<=0) System.out.println("No hay asientos libres");
	}
	
	//Método que simula la gestión
	public void gestionAsientosAvion(int numSeientsReserva){
	
		//Comprobamos si hay suficientes
		if(avion.getAsientosLibres()>=numAsientos)
		{
			System.out.println(Thread.currentThread().getName()+" realizará una reserva de "+ numAsientos +" asientos");
			try {
				Thread.sleep(1000); //simulamos que el sistema debe consultar a través de internet
			}catch (InterruptedException ex) {
				//Salimos del escenario dormido
			}
			//Hacemos la reserva
			avion.reservarAsientos(numAsientos);
			System.out.println(Thread.currentThread().getName() + " REserva realizada con éxito."+" Los asientos libres son "+avion.getAsientosLibres());
		}else{
			System.out.println("No hay suficientes plazas para el cliente." + Thread.currentThread().getName()+" Las plazas libres son "+avion.getAsientosLibres());
			try {
				Thread.sleep(1000); //simulamos que el sistema debe consultar a través de internet
			}
			catch (InterruptedException ex) {
				//Salimos del escenario dormido
			}
		}
		 
		 
		}


}
